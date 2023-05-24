import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationCenter } from '../donation-center';

@Injectable({
  providedIn: 'root'
})
export class StaffHomepageService {

  constructor(private http: HttpClient) { }

  getAllDonationCenters() : Observable<DonationCenter[]>{
    return this.http.get<DonationCenter[]>("/api/donation_center/all");
  }
}
