import { Component, OnInit } from '@angular/core';
import { StaffProcessedReservationsService } from '../services/staff-processed-reservations.service';
import { ProcessedUser } from '../processedUsers';

@Component({
  selector: 'app-staff-work-calendar',
  templateUrl: './staff-work-calendar.component.html',
  styleUrls: ['./staff-work-calendar.component.css']
})
export class StaffWorkCalendarComponent implements OnInit{
  public processedUsers = [] as ProcessedUser[];
  selectedSortOption = "today";

  constructor(private _processedReservationsService: StaffProcessedReservationsService) { }

  ngOnInit(): void {
    this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
      this.processedUsers = data;
       console.log(data);
        this.processedUsers.forEach(function (value) {
        value.date = new Date(value.date);
      });
    })
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
      })
      break;
    case 'month':
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
      })
      break;
    case 'year':
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
      })
      break;
    default:
      this._processedReservationsService.getNewReservations(this.selectedSortOption).subscribe(data =>{
        this.processedUsers = data;
         console.log(data);
          this.processedUsers.forEach(function (value) {
          value.date = new Date(value.date);
        });
      })
      break;
    }
  }

}
