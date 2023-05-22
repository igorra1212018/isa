import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from '../appointment';
import { UserUpcomingAppointmentsService } from '../services/user-upcoming-appointments.service';

@Component({
  selector: 'app-user-upcoming-appointments',
  templateUrl: './user-upcoming-appointments.component.html',
  styleUrls: ['./user-upcoming-appointments.component.css']
})
export class UserUpcomingAppointmentsComponent {
  public appointments = [] as Appointment[];
  errorMsg = "";
  currentDate: Date = new Date()

  constructor(private route: ActivatedRoute, private router: Router, private _userUpcomingAppointmentsService: UserUpcomingAppointmentsService) { }
  
  loadUpcomingAppointments(): void {
    this._userUpcomingAppointmentsService.getUpcomingAppointments().subscribe(data => {
      this.appointments = data;
      this.appointments.forEach(function (value) {
        value.date = new Date(value.date);
        value.reservationDate = new Date(value.reservationDate);
      });
    },
      error => this.errorMsg = "Couldn't load upcoming appointments");
  }

  ngOnInit(): void {
    this.loadUpcomingAppointments();
  }

  cancelAppointment(id: number): void{
    this._userUpcomingAppointmentsService.cancel(id).subscribe(
      response => {
        console.log(response);
        this.loadUpcomingAppointments();
      },
      error => {
        console.log(error.error);
      });
  }
}
