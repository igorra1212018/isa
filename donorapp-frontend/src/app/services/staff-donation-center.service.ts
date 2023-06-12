import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationCenter } from '../donation-center';
import { Term } from '../term';
import { DonationCenterDTO } from '../admin-donation-center/donation-center';
import { TermDTO } from '../staff-define-term/termDTO';
import { TermAddDTO } from '../staff-define-term/termAddDTO';

@Injectable({
    providedIn: 'root',
})
export class StaffDonationCenterService {
    private _url: string = '/api/donation_center/';
    httpOptions = {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
    };

    constructor(private http: HttpClient) {}

    getDonationCenter(id: number): Observable<DonationCenter> {
        return this.http.get<DonationCenter>(this._url + id);
    }

    getFreeTerms(id: number): Observable<Term[]> {
        return this.http.get<Term[]>('/api/term/center/' + id);
    }

    getFreeTermsForDate(id: number, date: Date): Observable<TermDTO[]> {
        const params = new HttpParams().set('date', date.toISOString());
        return this.http.get<TermDTO[]>('/api/term/center/date/' + id, { params });
    }

    addNewTerm(term: TermAddDTO): Observable<any> {
        return this.http.post('/api/term/center/addTerm', JSON.stringify(term), this.httpOptions);
    }

    makeAppointment(term: TermAddDTO): Observable<any> {
        return this.http.post('/api/term/center/makeAppointment', JSON.stringify(term), this.httpOptions);
    }

    updateDonationCenterInfo(newData: DonationCenterDTO): Observable<any> {
        return this.http.put(this._url + 'update', JSON.stringify(newData), this.httpOptions);
    }

    getAvailableCenters(date: Date) : Observable<DonationCenter[]> {
        const params = new HttpParams().set('date', date.toISOString());
        return this.http.get<DonationCenter[]>(this._url + 'allAvailable',  { params });
    }
}
