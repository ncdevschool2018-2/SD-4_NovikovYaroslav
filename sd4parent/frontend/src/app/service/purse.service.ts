import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"
import { Observable } from "rxjs"
import {Purse} from "../model/purse";
import { MoneyOperation } from "../model/moneyOperation";

@Injectable({
  providedIn: 'root'
})
export class PurseService {

  constructor(private http: HttpClient) { }

  getPurse(purseId: string): Observable<Purse> {
    return this.http.get<Purse>("api/pu/" + purseId);
  }

  getPurses(): Observable<Purse[]> {
    return this.http.get<Purse[]>("/api/pu");
  }

  savePurse(purse: Purse): Observable<Purse> {
    return this.http.post<Purse>("/api/pu", purse);
  }

  deletePurse(purseId: string): Observable<void> {
    return this.http.delete<void>("api/pu/" + purseId);
  }

  getPurseByOwnerId(id: string): Observable<Purse> {
    return this.http.get<Purse>("api/pu/?userId=" + id);
  }

  setMoney(purse: MoneyOperation): Observable<void> {
    return this.http.post<void>("api/pu/fill", purse);
  }
}
