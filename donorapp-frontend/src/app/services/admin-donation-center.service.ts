import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DonationCenter } from '../donation-center';
import { DonationCenterDTO } from '../admin-donation-center/donation-center';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminDonationCenterService {
  private _url: string = '/api/donation_center';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

  constructor(private http: HttpClient) { }

  registerCenter(donation_center: DonationCenterDTO): Observable<string> {
    return this.http.post(this._url + "/register", JSON.stringify(donation_center), {
        ...this.httpOptions,
        responseType: 'text',
    });
  }

  getAllDonationCenters() : Observable<DonationCenter[]>{
    return this.http.get<DonationCenter[]>("/api/donation_center/all");
  }
}
