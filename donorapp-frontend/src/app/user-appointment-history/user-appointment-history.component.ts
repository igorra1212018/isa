import { Component } from '@angular/core';
import { UserAppointmentHistoryService } from '../services/user-appointment-history.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-user-appointment-history',
  templateUrl: './user-appointment-history.component.html',
  styleUrls: ['./user-appointment-history.component.css']
})
export class UserAppointmentHistoryComponent {
  public appointments = [] as Appointment[];
  errorMsg = "";
  currentDate: Date = new Date();
  selectedSortOption = "date";

  constructor(private route: ActivatedRoute, private router: Router, private _userAppointmentHistoryService: UserAppointmentHistoryService) { }
  
  loadVisitedAppointments(): void {
    this._userAppointmentHistoryService.getVisitedAppointments().subscribe(data => {
      this.appointments = data;
      this.appointments.forEach(function (value) {
        value.date = new Date(value.date);
        value.reservationDate = new Date(value.reservationDate);
      });
      this.sortAppointments();
    },
      error => this.errorMsg = "Couldn't load visited appointments");
  }

  ngOnInit(): void {
    this.loadVisitedAppointments();
  }

  sortAppointments(): void {
    switch (this.selectedSortOption) {
      case 'date':
        this.appointments.sort((a, b) => {
          return a.date.getTime() - b.date.getTime();
        });
        break;
      case 'duration':
        this.appointments.sort((a, b) => {
          return a.duration - b.duration;
        });
        break;
      default:
        break;
    }
  }
}
