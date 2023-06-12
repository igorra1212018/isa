import { Component, OnInit } from '@angular/core';
import { StaffProcessedReservationsService } from '../services/staff-processed-reservations.service';
import { ProcessedUser } from '../processedUsers';

@Component({
  selector: 'app-staff-processed-reservations',
  templateUrl: './staff-processed-reservations.component.html',
  styleUrls: ['./staff-processed-reservations.component.css']
})

export class StaffProcessedReservationsComponent implements OnInit{
  public processedUsers = [] as ProcessedUser[];
  selectedSortOption = "date";
  /*firstName: string = "";
  lastName: string = "";
  duration: number = 0;
  date: Date = new Date();  

  dataSource: any;  
  displayedColumns: string[] = ['firstName', 'lastName', 'duration', 'date'];*/

  constructor(private _processedReservationsService: StaffProcessedReservationsService) { }

  ngOnInit(): void {
    this._processedReservationsService.getProcessedUsers().subscribe(data =>{
      this.processedUsers = data;
      //this.dataSource = data;
      console.log(data);
        this.processedUsers.forEach(function (value) {
        value.date = new Date(value.date);
      });
      this.sortUsers();
    })
  }

  sortUsers(): void {
    switch (this.selectedSortOption) {
      case 'date':
        this.processedUsers.sort((a, b) => {
          return a.date.getTime() - b.date.getTime();
        });
        break;
      case 'duration':
        this.processedUsers.sort((a, b) => {
          return a.duration - b.duration;
        });
        break;
      case 'firstName':
        this.processedUsers.sort((a, b) => {
          return compare(a.user.firstName, b.user.firstName);
        });
        break;
      case 'lastName':
        this.processedUsers.sort((a, b) => {
          return compare(a.user.lastName, b.user.lastName);
        });
        break;
      default:
        break;
    }
  }
}

function compare(a: number | string, b: number | string) {
  return (a < b ? -1 : 1);
}
