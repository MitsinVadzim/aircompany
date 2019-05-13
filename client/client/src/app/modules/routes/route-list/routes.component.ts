import { Component, OnInit } from '@angular/core';

import {Route} from "../../models/route.model";
import {RouteService} from "../../../service/route/route.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {
  private routes: Route[] = [];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private routeService: RouteService) { }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      const id = params['id'];
      if (id){
        this.routeService.get(id).subscribe((customRoute: Route) =>{
          this.routes.push(customRoute);
        });
      }else {
        this.routeService.getAll().subscribe(data => {
          this.routes = data;
        })
      }
    });

  }
}
