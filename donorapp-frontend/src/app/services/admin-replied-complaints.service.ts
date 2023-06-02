import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DonationCenterComplaint } from '../donation-center-complaint';
import { StaffComplaint } from '../staff-complaint';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminRepliedComplaintsService {

  constructor(private http: HttpClient) { }

  getRepliedDonationCenterComplaints() : Observable<DonationCenterComplaint[]>{
    return this.http.get<DonationCenterComplaint[]>("/api/donation_center_complaint/replied");
  }

  getRepliedStaffComplaints() : Observable<StaffComplaint[]>{
    return this.http.get<StaffComplaint[]>("/api/staff_complaint/replied");
  }
}
