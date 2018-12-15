import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"
import { Observable } from "rxjs"
import {AccountProduct} from "../model/accountProduct";

@Injectable({
  providedIn: 'root'
})
export class AccountProductService {

  constructor(private http: HttpClient) { }

  getAccountProduct(subscriptionId: string): Observable<AccountProduct> {
    return this.http.get<AccountProduct>("api/ap/" + subscriptionId);
  }

  getAccountProducts(): Observable<AccountProduct[]> {
    return this.http.get<AccountProduct[]>("api/ap");
  }

  saveAccountProduct(sub: AccountProduct ): Observable<AccountProduct> {
    return this.http.post<AccountProduct>("api/ap", sub);
  }

  deleteAccountProduct(subscriptionId: string): Observable<void> {
    return this.http.delete<void>("api/ap/" + subscriptionId);
  }

  getAccountProductsByLogin(login: string): Observable<AccountProduct[]> {
    return this.http.get<AccountProduct[]>("api/ap/?login=" + login);
  }
}
