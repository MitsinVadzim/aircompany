import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Discount} from "../../models/discount.model";
import {DiscountService} from "../../../service/discount/discount.service";
import {Route} from "../../models/route.model";
import {RouteService} from "../../../service/route/route.service";

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {

  private discounts: Discount[] = [];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private discountService: DiscountService) { }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      const id = params['id'];
      if (id){
        this.discountService.get(id).subscribe((discount: Discount) =>{
          this.discounts.push(discount);
        });
      }else {
        this.discountService.getAll().subscribe(data => {
          this.discounts = data;
        })
      }
    });

  }

}
