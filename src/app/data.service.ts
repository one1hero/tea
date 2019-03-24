import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { From } from './from';
import { HttpClient } from '@angular/common/http';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private url = 'http://192.168.1.103:8080/tea/v1';


  constructor(private http: HttpClient) {

  }

  getHttpFrom(): Observable<From> {
    return this.http.get<From>(`${this.url}/from`);
  }

  postOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(`${this.url}/add`, order);
  }

  getOrderList(page: number): Observable<[number, Order[]]> {
    return this.http.get<[number, Order[]]>(`${this.url}/orderlist/${page}`);
  }

  postOutOrder(order: Order): Observable<{}> {
    return this.http.post<{}>(`${this.url}/out`, order);
  }

  getOutOrderList(page: number): Observable<[number, Order[]]> {
    return this.http.get<[number, Order[]]>(`${this.url}/outOrderlist/${page}`);
  }

  getViewData(): Observable<[]> {
    return this.http.get<[]>(`${this.url}/viewdata`);
  }
}
