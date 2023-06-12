import { Component, OnInit } from '@angular/core';
import { StaffDonationCenterService } from '../services/staff-donation-center.service';
import { DonationCenter } from '../donation-center';
import { TermAddDTO } from '../staff-define-term/termAddDTO';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-make-appointment',
  templateUrl: './user-make-appointment.component.html',
  styleUrls: ['../shared-style.css', './user-make-appointment.component.css']
})
export class UserMakeAppointmentComponent implements OnInit {
  selectedDate: string = '';
  termHHMM: string = '';
  minDate!: string;
  finalDate: Date = new Date();
  centers = [] as DonationCenter[];
  errorMsg: string = '';
  response: string = '';

  constructor(private _donationCenterService: StaffDonationCenterService, private router: Router) {}

  ngOnInit(): void {
    const today = new Date();
    this.minDate = today.toISOString().split('T')[0];
  }

  onTimeChange() {
      this.finalDate = new Date(this.selectedDate);
      const hours = Number(this.termHHMM.split(':')[0]);
      const minutes = Number(this.termHHMM.split(':')[1]);
      this.finalDate.setHours(hours, minutes);
      console.log(this.finalDate);
      this.loadAvailableCenters();
  }

  loadAvailableCenters() {
    this._donationCenterService.getAvailableCenters(this.finalDate).subscribe(
      (data) => {
          this.centers = data;
      },
      (error) => (this.errorMsg = "Couldn't load centers")
    );
  }

  chooseCenter(centerId: number) {
    let newTerm: TermAddDTO = new TermAddDTO(this.finalDate.toISOString(), 30, centerId);
    this._donationCenterService.makeAppointment(newTerm).subscribe(
      (data) => {
         this.response = data;
         this.router.navigate(['user-upcoming-appointments']);
      },
      (error) => {
        if (error.error == "Failed to make appointment (user doesn't meet requirements)!")
          this.router.navigate(['user-questionnaire']);
      });
  }

  sortCenters() {
    this.centers.sort((a, b) => b.rating - a.rating);
  }

}
