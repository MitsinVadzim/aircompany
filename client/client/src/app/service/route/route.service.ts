import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Route} from "../../modules/models/route.model";
import {debounceTime} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  public API = '//localhost:8080';
  public ROUTE_API = this.API + '/routes';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get('//localhost:8080/routes')
  }

  get(id: string){
    return this.http.get(this.ROUTE_API + '/' + id);
  }

  save(route: any): Observable<any>{
    let result: Observable<Object>;
    if(route['id']){
      result = this.http.put(this.ROUTE_API + '/' + route.id, route);
    }else {
      result = this.http.post(this.ROUTE_API, route);
    }
    return result;
  }

  delete(id: string){
     return this.http.delete(this.ROUTE_API + '/' + id);
  }

  getAutocompleteRoutes(input: string): Observable<Route[]>{
    return this.http.get<Route[]>(this.ROUTE_API + '/place/' + input).pipe(debounceTime(500));
  }


}
