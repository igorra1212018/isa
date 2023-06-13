import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProcessedUser} from '../processedUsers';
import { StaffQuestionnaireDTO } from '../staff-start-appointment/StaffQuestionnaireDTO';
import { Equipment } from '../staff-start-appointment/equipment';

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

  startAppointment(newData: StaffQuestionnaireDTO): Observable<any>{
    return this.http.post<any>(this._url + "startAppointment", JSON.stringify(newData), this.httpOptions);
  }
  getEquipmentFromCenter() : Observable<Equipment[]> {
    return this.http.get<Equipment[]>(this._url + "equipment", this.httpOptions);
  }

}

