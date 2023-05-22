import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegister } from '../register/user-register';

@Injectable({
    providedIn: 'root',
})
export class UserProfileService {
    private _url: string = 'api/user/profile';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

    constructor(private http: HttpClient) {}

    gtUserData(userId: Number): Observable<any> {
        return this.http.get(this._url, this.httpOptions);
    }

    changeUserData(newData: UserRegister): Observable<any> {
        return this.http.put(this._url, JSON.stringify(newData), this.httpOptions);
    }
}
