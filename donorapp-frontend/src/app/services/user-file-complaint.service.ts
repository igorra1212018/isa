import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterFileComplaint } from '../center-file-complaint';
import { DonationCenterComplaintCreate } from '../donation-center-complaint-create';
import { StaffComplaintCreate } from '../staff-complaint-create';

@Injectable({
  providedIn: 'root'
})
export class UserFileComplaintService {

  constructor(private http: HttpClient) { }

  getDonationCenter(id: number) : Observable<CenterFileComplaint>{
    return this.http.get<CenterFileComplaint>("/api/donation_center/file_complaint/" + id);
  }

  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };
  
  centerComplaintSubmit(complaint: DonationCenterComplaintCreate): Observable<string> {
    return this.http.post('/api/donation_center_complaint/create', JSON.stringify(complaint), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }

  staffComplaintSubmit(complaint: StaffComplaintCreate): Observable<string> {
    return this.http.post('/api/staff_complaint/create', JSON.stringify(complaint), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }
}
