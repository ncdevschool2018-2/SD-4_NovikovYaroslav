import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/us');
  }

  saveUser(user: User): Observable<User>{
    return this.http.post<User>('/api/us', user);
  }

  getUserById(id: string): Observable<User>{
    return this.http.get<User>('/api/us/' + id);
  }

  getUser(): Observable<User>{
    return this.http.get<User>('/api/us/userLogin/');
  }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>("api/us/?login=" + login);
  }

}
