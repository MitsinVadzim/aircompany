import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, NgForm} from "@angular/forms";
import {FlightService} from "../../../service/flight/flight.service";
import {debounceTime, distinctUntilChanged} from "rxjs/operators";
import {RouteService} from "../../../service/route/route.service";
import {Route} from "../../models/route.model";
import {Flight} from "../../models/flight.model";

@Component({
  selector: 'app-flight-edit',
  templateUrl: './flight-edit.component.html',
  styleUrls: ['./flight-edit.component.css']
})
export class FlightEditComponent implements OnInit, OnDestroy {

  flightToSend: Flight = new Flight;
  flight: any = {};
  routes: Route[] = [];
  routePlaceControl: FormControl = new FormControl();
  currentRouteId: any;

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private flightService: FlightService,
              private routeService: RouteService) { }

  ngOnInit() {
    this.observeFlightChanges(this.routePlaceControl);
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id){
        this.flightService.get(id).subscribe((flight: any) =>{
          if (flight) {
            this.flight = flight;
          }else {
            console.log(`Flight with id '${id}' not found, returning to list`);
            this.goToList();
          }
        })
      }
    })
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  goToList(){
    this.router.navigate(['/flights']);
  }

  save(){
    this.flightToSend.routeId = this.routePlaceControl.value;
    this.flightService.save(this.flightToSend).subscribe(result =>{
      this.goToList();
    }, error => console.error(error));
  }

  delete(id: string){
    this.flightService.delete(id).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

  public observeFlightChanges(formControl: FormControl){
    this.currentRouteId = formControl.value;
    formControl.valueChanges.pipe(debounceTime(500), distinctUntilChanged()).subscribe(
      routePlace => {
        if(routePlace !== ''){
          this.routeService.getAutocompleteRoutes(routePlace).subscribe(
            routes => {
              this.routes = routes;
            }
          )
        }else {
          this.loadRoutes();
        }
      }
    )
  }

  private loadRoutes(): void{
    this.routeService.getAll().subscribe(routes =>{
      this.routes = routes as Route[];
    })
  }

}
