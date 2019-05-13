import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  public API = '//localhost:8080';
  public FLIGHT_API = this.API + '/flights';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get(this.FLIGHT_API);
  }

  get(id: string){
    return this.http.get(this.FLIGHT_API + '/' + id);
  }

  save(flight: any): Observable<any>{
    let result: Observable<Object>;
    if(flight['id']){
      result = this.http.put(this.FLIGHT_API + '/' + flight.id, flight);
    }else {
      result = this.http.post(this.FLIGHT_API, flight);
    }
    return result;
  }

  delete(id: string){
    return this.http.delete(this.FLIGHT_API + '/' + id);
  }
}
