import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {RoutesComponent} from "./modules/routes/route-list/routes.component";
import {RouteEditComponent} from "./modules/routes/route-edit/route-edit.component";
import {FlightListComponent} from "./modules/flight/flight-list/flight-list.component";
import {FlightEditComponent} from "./modules/flight/flight-edit/flight-edit.component";
import {DiscountListComponent} from "./modules/discounts/discount-list/discount-list.component";

const routes: Routes = [
  {path: '', redirectTo: '/routes', pathMatch: 'full'},
  {
    path: 'routes',
    component: RoutesComponent
  },
  {
    path: 'routes/:id',
    component: RoutesComponent
  },
  {
    path: 'route-add',
    component: RouteEditComponent
  },
  {
    path: 'route-edit/:id',
    component: RouteEditComponent
  },
  {
    path: 'flights',
    component: FlightListComponent
  },
  {
    path: 'flights/:id',
    component: FlightListComponent
  },
  {
    path: 'flight-add',
    component: FlightEditComponent
  },
  {
    path: 'flight-edit/:id',
    component: FlightEditComponent
  },
  {
    path: 'discounts',
    component: DiscountListComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
}
