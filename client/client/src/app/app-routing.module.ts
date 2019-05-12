import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {RoutesComponent} from "./routes/route-list/routes.component";
import {RouteEditComponent} from "./routes/route-edit/route-edit.component";

const routes: Routes = [
  {path: '', redirectTo: '/routes', pathMatch: 'full'},
  {
    path: 'routes',
    component: RoutesComponent
  },
  {
    path: 'route-add',
    component: RouteEditComponent
  },
  {
    path: 'route-edit/:id',
    component: RouteEditComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
}
