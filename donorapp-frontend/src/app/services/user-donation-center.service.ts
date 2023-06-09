import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DonationCenter } from '../donation-center';
import { Observable } from 'rxjs';
import { Term } from '../term';
import { DonationCenterScore } from '../donation-center-score';

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

  getCenterScore(id: number) : Observable<any>{
    return this.http.get<any>("/api/donation_center/get_score/" + id);
  }

  setCenterScore(new_score: DonationCenterScore) : Observable<any>{
    return this.http.post<any>("/api/donation_center/set_score", JSON.stringify(new_score), this.httpOptions);
  }

  updateCenterScore(new_score: DonationCenterScore) : Observable<any>{
    return this.http.put("/api/donation_center/update_score", JSON.stringify(new_score), this.httpOptions);
  }

}
