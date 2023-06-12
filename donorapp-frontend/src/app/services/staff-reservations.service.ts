import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProcessedUser} from '../processedUsers';

@Injectable({
  providedIn: 'root'
})
export class StaffReservationsService {
  private _url: string = 'api/staff/';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

  constructor(private http: HttpClient) {}

  getProcessedUsers() : Observable<ProcessedUser[]> {
    return this.http.get<ProcessedUser[]>(this._url + "processed_users", this.httpOptions);
  }

  getNewReservations(parse: string) : Observable<ProcessedUser[]> {
    return this.http.get<ProcessedUser[]>(this._url + "work_calendar/" + parse, this.httpOptions);
  }

  stoodUpAppointment(id: number): Observable<any> {
    return this.http.put(this._url + "stood_up/" + id, this.httpOptions);
  }

  reqsNotMetAppointment(id: number): Observable<any> {
    return this.http.put(this._url + "rejected/" + id, this.httpOptions);
  }
}

