import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StaffDTO } from '../staff-profile/staffDTO';

@Injectable({
  providedIn: 'root'
})
export class StaffService {
  private _url: string = 'api/staff/';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

      constructor(private http: HttpClient) {}

    GetUserData(): Observable<any> {
        return this.http.get<any>(this._url + "profile", this.httpOptions);
    }

    UpdateStaffInfo(newData: StaffDTO): Observable<any> {
        return this.http.put(this._url + "update", JSON.stringify(newData), this.httpOptions);
    }
    
}
