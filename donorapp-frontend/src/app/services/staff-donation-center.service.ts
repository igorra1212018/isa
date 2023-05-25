import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationCenter } from '../donation-center';
import { Term } from '../term';
import { DonationCenterDTO } from '../admin-donation-center/donation-center';

@Injectable({
  providedIn: 'root'
})
export class StaffDonationCenterService {
  private _url: string = '/api/donation_center/';
  httpOptions = {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
  };
 
  constructor(private http: HttpClient) { }

  getDonationCenter(id: number) : Observable<DonationCenter>{
    return this.http.get<DonationCenter>(this._url + id);
  }

  getFreeTerms(id: number) : Observable<Term[]>{
    return this.http.get<Term[]>("/api/term/center/" + id);
  }

  updateDonationCenterInfo(newData: DonationCenterDTO): Observable<any> {
    return this.http.put(this._url + "update", JSON.stringify(newData), this.httpOptions);
  }
}