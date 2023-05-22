import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class UserProfileService {
    private _url: string = 'api/user/';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

    constructor(private http: HttpClient) {}

    gtUserData(userId: Number): Observable<any> {
        return this.http.get(this._url + userId, this.httpOptions);
    }
}
