import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserRegister } from './register/user-register';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private _url: string = "api/user/register";
  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };

  constructor(private http: HttpClient) { }

  register(user: UserRegister): Observable<UserRegister> {
    return this.http.post<UserRegister>(this._url, JSON.stringify(user), this.httpOptions);
  }
}