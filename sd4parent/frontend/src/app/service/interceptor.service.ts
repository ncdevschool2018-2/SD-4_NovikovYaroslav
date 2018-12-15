import {Injectable} from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent} from '@angular/common/http';
import {Observable, throwError} from "rxjs";
import {TokenStorage} from "./token.storage";
import {catchError} from "rxjs/operators";
import {Router} from "@angular/router";
import { AuthService } from "./auth.service";

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

  constructor(private token: TokenStorage, private router: Router, private authService: AuthService) {
  }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    if (this.token.getToken() != null) {
      authReq = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken())});
    }
    else if(this.token.getToken() == undefined) {
      this.router.navigateByUrl('/');
    }
    return next.handle(authReq);
  }
}
