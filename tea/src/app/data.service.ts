import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { From } from './from';
import { HttpClient } from '@angular/common/http';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private url = 'http://192.168.43.29:8080';

  constructor(private http: HttpClient) {

  }

  getHttpFrom(): Observable<From> {
    return this.http.get<From>(`${this.url}/tea/v1/from`);
  }

  postOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(`${this.url}/tea/v1/add`, order);
  }

  getOrderList(page: number): Observable<[number, Order[]]> {
    return this.http.get<[number, Order[]]>(`${this.url}/tea/v1/orderlist/${page}`);
  }

  postOutOrder(order: Order): Observable<{}> {
    return this.http.post<{}>(`${this.url}/tea/v1/out`, order);
  }

  getOutOrderList(page: number): Observable<[number, Order[]]> {
    return this.http.get<[number, Order[]]>(`${this.url}/tea/v1/outOrderlist/${page}`);
  }
}
