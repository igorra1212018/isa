import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProcessedUser} from '../processedUsers';

@Injectable({
  providedIn: 'root'
})
export class StaffProcessedReservationsService {
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
}

