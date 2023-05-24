import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationCenter } from '../donation-center';
import { UserHomepageInfo } from '../user-homepage-info';

@Injectable({
  providedIn: 'root'
})
export class UserHomepageService {

  constructor(private http: HttpClient) { }

  getAllDonationCenters() : Observable<DonationCenter[]>{
    return this.http.get<DonationCenter[]>("/api/donation_center/all");
  }

  getUserInfo() : Observable<UserHomepageInfo>{
    return this.http.get<UserHomepageInfo>("/api/user/homepage_info");
  }
}
