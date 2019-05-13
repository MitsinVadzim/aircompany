import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FlightService} from "../../../service/flight/flight.service";
import {Flight} from "../../models/flight.model";

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  private flights: Flight[] = [];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private flightService: FlightService) { }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      const id = params['id'];
      if (id){
        this.flightService.get(id).subscribe((flight: Flight) =>{
          this.flights.push(flight);
        });
      }else {
        this.flightService.getAll().subscribe(data => {
          this.flights = data;
        })
      }
    });

  }

}
