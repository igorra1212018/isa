import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from '../appointment';
import { UserUpcomingAppointmentsService } from '../user-upcoming-appointments.service';

@Component({
  selector: 'app-user-upcoming-appointments',
  templateUrl: './user-upcoming-appointments.component.html',
  styleUrls: ['./user-upcoming-appointments.component.css']
})
export class UserUpcomingAppointmentsComponent {
  public appointments = [] as Appointment[];
  errorMsg = "";
  currentDate: Date = new Date()

  constructor(private router: Router, private _userUpcomingAppointmentsService: UserUpcomingAppointmentsService) { }
  
  ngOnInit(): void {
    this._userUpcomingAppointmentsService.getUpcomingAppointments().subscribe(data => {
      this.appointments = data;
      this.appointments.forEach(function (value) {
        value.date = new Date(value.date);
        value.reservationDate = new Date(value.reservationDate);
      });
    },
      error => this.errorMsg = "Couldn't load centers");
  }

  cancelAppointment(id: number): void{

  }
}
