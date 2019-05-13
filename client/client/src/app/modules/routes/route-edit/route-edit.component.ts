import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {RouteService} from "../../../service/route/route.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-route-edit',
  templateUrl: './route-edit.component.html',
  styleUrls: ['./route-edit.component.css']
})
export class RouteEditComponent implements OnInit, OnDestroy {

  customRoute: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private routeService: RouteService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id){
        this.routeService.get(id).subscribe((customRoute: any) =>{
          if (customRoute) {
            this.customRoute = customRoute;
          }else {
            console.log(`Route with id '${id}' not found, returning to list`);
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
    this.router.navigate(['/routes']);
  }

  save(form: NgForm){
    this.routeService.save(form).subscribe(result =>{
      this.goToList();
    }, error => console.error(error));
  }

  delete(id: string){
    this.routeService.delete(id).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

}
