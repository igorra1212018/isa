import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DonationCenterComplaint } from '../donation-center-complaint';
import { Observable } from 'rxjs';
import { StaffComplaint } from '../staff-complaint';

@Injectable({
  providedIn: 'root'
})
export class UserComplaintsService {

  constructor(private http: HttpClient) { }

  getDonationCenterComplaints() : Observable<DonationCenterComplaint[]>{
    return this.http.get<DonationCenterComplaint[]>("/api/donation_center_complaint/user");
  }

  getStaffComplaints() : Observable<StaffComplaint[]>{
    return this.http.get<StaffComplaint[]>("/api/staff_complaint/user");
  }
}
