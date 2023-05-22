import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DonationCenter } from '../donation-center';
import { Observable } from 'rxjs';
import { Term } from '../term';

@Injectable({
  providedIn: 'root'
})
export class UserDonationCenterService {
  
  constructor(private http: HttpClient) { }

  getDonationCenter(id: number) : Observable<DonationCenter>{
    return this.http.get<DonationCenter>("/api/donation_center/" + id);
  }

  getFreeTerms(id: number) : Observable<Term[]>{
    return this.http.get<Term[]>("/api/term/center/" + id);
  }

  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };
  
  reserve(id: number): Observable<string> {
    return this.http.post('/api/term/reserve/'+id, JSON.stringify(""), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }
}
