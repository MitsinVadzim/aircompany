import { Component, OnInit } from '@angular/core';

import {Route} from "../../modules/models/route.model";
import {RouteService} from "../../shared/route/route.service";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {
  private routes: Route[];

  constructor(private routeService: RouteService) { }

  ngOnInit() {
    this.routeService.getAll().subscribe(data => {
      this.routes = data;
    })
  }
}
