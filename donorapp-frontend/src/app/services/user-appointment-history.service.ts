import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../appointment';

@Injectable({
  providedIn: 'root'
})
export class UserAppointmentHistoryService {
  constructor(private http: HttpClient) { }

  getVisitedAppointments() : Observable<Appointment[]>{
    return this.http.get<Appointment[]>("/api/term/visited");
  }

  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };
}
