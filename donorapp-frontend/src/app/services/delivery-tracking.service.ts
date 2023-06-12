import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeliveryCoordinates } from '../delivery-coordinates';

@Injectable({
  providedIn: 'root'
})
export class DeliveryTrackingService {
  private _url: string = 'api/donation_center/start_delivery';
  httpOptions = {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
  };

  constructor(private http: HttpClient) {}

  startDelivery(user: DeliveryCoordinates): Observable<string> {
      return this.http.post(this._url, JSON.stringify(user), {
          ...this.httpOptions,
          responseType: 'text',
      });
  }
}
