import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
// Data service
export class ProductService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('/api/pr');
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>('/api/pr', product);
  }

  deleteProduct(productId: string): Observable<void> {
    return this.http.delete<void>('/api/pr/' + productId);
  }

}
