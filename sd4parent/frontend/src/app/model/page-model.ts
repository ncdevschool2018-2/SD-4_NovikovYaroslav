import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserAccount} from "../model/userAccount";
import {Token} from "../model/token";
import {Role} from "../model/role";

@Injectable({
  providedIn: 'root'
})
export class TableModelService {

  constructor(private http: HttpClient) {
  }

  getRoles(): Observable<Role[]> {
    return this.http.get<Role[]>('/api/ba-roles');
  }

  /*security*/
  attemptAuth(login: string, password: string): Observable<Token> {
    const credentials = {login: login, password: password};
    return this.http.post<Token>('/token/generate-token', credentials);
  }

  getAccountById(id: number): Observable<UserAccount> {
    return this.http.get<UserAccount>("/api/us/" + id);
  }

  getUserByLogin(login: string): Observable<UserAccount> {
    return this.http.get<UserAccount>("/api/us/auth?login=" + login);
  }

  /**/
}
