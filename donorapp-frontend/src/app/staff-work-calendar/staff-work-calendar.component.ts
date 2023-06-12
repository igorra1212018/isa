import { Component, OnInit } from '@angular/core';
import { StaffReservationsService } from '../services/staff-reservations.service';
import { ProcessedUser } from '../processedUsers';

@Component({
  selector: 'app-staff-work-calendar',
  templateUrl: './staff-work-calendar.component.html',
  styleUrls: ['./staff-work-calendar.component.css']
})
export class StaffWorkCalendarComponent implements OnInit{
  public processedUsers = [] as ProcessedUser[];
  selectedSortOption = "today";

  constructor(private _processedReservationsService: StaffReservationsService) { }

  ngOnInit(): void {
    this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
      this.processedUsers = data;
       console.log(data);
        this.processedUsers.forEach(function (value) {
        value.date = new Date(value.date);
      });
      this.sortReservations();
    })
  }

  sortReservations(){
    this.processedUsers.sort((a, b) => {
      return a.date.getTime() - b.date.getTime();
    });
  }

  timeFrame(){
  switch (this.selectedSortOption) {
    case 'week':
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
        this.sortReservations();
      })
      break;
    case 'month':
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
        this.sortReservations();
      })
      break;
    case 'year':
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
        this.sortReservations();
      })
      break;
    default:
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
        this.sortReservations();
      })
      break;
    }
  }

  stoodUpAppointment(id: number){
    console.log(id);
    this._processedReservationsService.stoodUpAppointment(id).subscribe()
  }

  reqsNotMetAppointment(id: number){
    this._processedReservationsService.reqsNotMetAppointment(id).subscribe()
  }

  startAppointment(id: number){}

}
