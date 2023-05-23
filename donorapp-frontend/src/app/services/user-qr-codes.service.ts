import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReservationQR } from '../reservation-qr';

@Injectable({
  providedIn: 'root'
})
export class UserQrCodesService {
  
  constructor(private http: HttpClient) { }

  getAllReservationQRs() : Observable<ReservationQR[]>{
    return this.http.get<ReservationQR[]>("/api/term/qr-codes");
  }
}
