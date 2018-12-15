import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TokenStorage} from "./token.storage";
import {LoginUser} from "../model/loginUser";
import {Decode} from "../model/decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private token: TokenStorage) {
  }

  attemptAuth(loginUser: LoginUser): Observable<any> {
    // console.log('AttemptAuth ::');
    return this.http.post<any>('/token/generate-token', loginUser);
  }

  decodeJwt(token: string): any {
    let encodedJwt = token.split('.')[1];
    let decodedJwt = window.atob(encodedJwt);
    return JSON.parse(decodedJwt);
  }

  getUsername(): string {
    let decodeObj: Decode = this.decodeJwt(this.token.getToken());
    return decodeObj.sub;
  }

  getRole(): string {
    let decodeObj: Decode = this.decodeJwt(this.token.getToken());
    return decodeObj.scopes;
  }

}
