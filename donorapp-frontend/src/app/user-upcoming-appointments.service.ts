import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class UserUpcomingAppointmentsService {
  constructor(private http: HttpClient) { }

  getUpcomingAppointments() : Observable<Appointment[]>{
    return this.http.get<Appointment[]>("/api/term/upcoming");
  }

  httpOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };
  
  cancel(id: number): Observable<string> {
    return this.http.put('/api/term/cancel/'+id, JSON.stringify(""), {
      ...this.httpOptions,
      responseType: 'text'
    });
  }
}
