import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {el} from "@angular/platform-browser/testing/src/browser_util";

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
    return  this.http.delete(this.ROUTE_API + '/' + id);
  }


}
