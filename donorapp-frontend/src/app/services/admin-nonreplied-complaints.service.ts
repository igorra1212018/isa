import { Injectable } from '@angular/core';
import { DonationCenterComplaint } from '../donation-center-complaint';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StaffComplaint } from '../staff-complaint';
import { DonationCenterComplaintReply } from '../donation-center-complaint-reply';
import { StaffComplaintReply } from '../staff-complaint-reply';

@Injectable({
  providedIn: 'root'
})
export class AdminNonrepliedComplaintsService {

  constructor(private http: HttpClient) { }

  getNonRepliedDonationCenterComplaints() : Observable<DonationCenterComplaint[]>{
    return this.http.get<DonationCenterComplaint[]>("/api/donation_center_complaint/no_reply");
  }

  getNonRepliedStaffComplaints() : Observable<StaffComplaint[]>{
    return this.http.get<StaffComplaint[]>("/api/staff_complaint/no_reply");
  }
  
  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };
  
  replyDonationCenterComplaint(complaint: DonationCenterComplaintReply): Observable<string> {
    return this.http.put('/api/donation_center_complaint/reply', JSON.stringify(complaint), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }

  replyStaffComplaint(complaint: StaffComplaintReply): Observable<string> {
    return this.http.put('/api/staff_complaint/reply', JSON.stringify(complaint), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }
}
