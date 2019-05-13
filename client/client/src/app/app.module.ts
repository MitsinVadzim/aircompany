import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RoutesComponent } from './modules/routes/route-list/routes.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import { RouteEditComponent } from './modules/routes/route-edit/route-edit.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule, MatDatepickerModule,
  MatInputModule,
  MatListModule, MatNativeDateModule,
  MatToolbarModule
} from "@angular/material";
import { FlightListComponent } from './modules/flight/flight-list/flight-list.component';
import { FlightEditComponent } from './modules/flight/flight-edit/flight-edit.component';
import { DiscountListComponent } from './modules/discounts/discount-list/discount-list.component';

@NgModule({
  declarations: [
    AppComponent,
    RoutesComponent,
    RouteEditComponent,
    FlightListComponent,
    FlightEditComponent,
    DiscountListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatAutocompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
