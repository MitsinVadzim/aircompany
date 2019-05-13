import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  public API = '//localhost:8080';
  public DISCOUNT_API = this.API + '/discounts';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get('//localhost:8080/discounts')
  }

  get(id: string){
    return this.http.get(this.DISCOUNT_API + '/' + id);
  }

  save(discount: any): Observable<any>{
    let result: Observable<Object>;
    if(discount['id']){
      result = this.http.put(this.DISCOUNT_API + '/' + discount.id, discount);
    }else {
      result = this.http.post(this.DISCOUNT_API, discount);
    }
    return result;
  }

  delete(id: string){
    return this.http.delete(this.DISCOUNT_API + '/' + id);
  }

}
