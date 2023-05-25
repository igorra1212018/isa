import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BloodDTO } from '../staff-blood-view/blood';

@Injectable({
  providedIn: 'root'
})
export class StaffBloodService {
  private _url: string = 'api/blood/';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

  constructor(private http: HttpClient) {}

  getAllBloodTypes() : Observable<BloodDTO[]>{
    return this.http.get<any>(this._url + "all", this.httpOptions);
  }
}
