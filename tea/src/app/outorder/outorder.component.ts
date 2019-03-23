import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../data.service';
import { Order } from '../order';

@Component({
  selector: 'app-outorder',
  templateUrl: './outorder.component.html',
  styleUrls: ['./outorder.component.css']
})
export class OutorderComponent implements OnInit {

  @Input() ingredient: Array<string>;

  orderList: Array<Order>;
  maxPage = 0;
  page = 1;
  sum: number[];

  constructor(private service: DataService) {
    this.pageable();
  }

  next() {
    if (this.page < this.maxPage) {
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
    this.service.getOutOrderList(this.page).subscribe(
      (res) => {
        this.maxPage = res[0];
        this.orderList = res[1];
        this.sum = Array.from(new Array(this.maxPage), (val, index) => index);
      }
    );
  }

  ngOnInit() {
  }

}
