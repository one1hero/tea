import { Component, OnInit, ViewChild } from '@angular/core';
import { Order } from '../order';
import { DataService } from '../data.service';
import { OutorderComponent } from '../outorder/outorder.component';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  drink: string[];
  cuptype: string[];
  sweet: string[];
  temperature: string[];
  ingredient: string[];

  order = new Order();

  orderList: Array<Order>;

  page = 1;
  totalPages = 0;

  sum: number[];

  @ViewChild('outorder')
  outorder: OutorderComponent;

  constructor(private service: DataService) {

    service.getHttpFrom().subscribe(
      (res) => {
        this.drink = res.drinks;
        this.cuptype = res.cuptypes;
        this.sweet = res.sweets;
        this.temperature = res.temperatures;
        this.ingredient = res.ingredients;
        this.order.drink = this.drink[0];
      }
    );
  }

  subOrder() {
    this.service.postOrder(this.order).subscribe(
      (res) => {
        this.pageable();
      }
    );
  }


  setIngredient(value: string) {
    const index = this.order.ingredients.indexOf(value);
    if (index === -1) {
      this.order.ingredients.push(value);
    } else {
      this.order.ingredients.splice(index, 1);
    }
  }

  next() {
    if (this.page < this.totalPages) {
      this.page++;
      this.pageable();
    }
  }

  previous() {
    if (this.page > 1) {
      this.page--;
      this.pageable();
    }
  }

  setPage(page: number) {
    this.page = page;
    this.pageable();
  }

  pageable() {
    this.service.getOrderList(this.page).subscribe(
      (res) => {
        this.totalPages = res[0];
        this.orderList = res[1];
        this.sum = Array.from(new Array(this.totalPages), (val, index) => index);
      }
    );
  }

  outOrder(index: number) {
    this.service.postOutOrder(this.orderList[index]).subscribe(
      (res) => {
        if (this.orderList.length === 1 && this.page > 1) {
          this.page--;
        }
        this.pageable();
        this.outorder.pageable();
      }
    );
  }


  ngOnInit() {
    this.pageable();
  }

}
