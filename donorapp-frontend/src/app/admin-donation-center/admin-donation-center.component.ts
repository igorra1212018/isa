import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminDonationCenterService } from '../services/admin-donation-center.service';
import { DonationCenterDTO } from './donation-center';

@Component({
  selector: 'app-admin-donation-center',
  templateUrl: './admin-donation-center.component.html',
  styleUrls: ['./admin-donation-center.component.css']
})
export class AdminDonationCenterComponent {
  name: string = "";
  city: string = "";
  country: string = "";
  address: string = "";
  description: string = "";
  latitude: number = 0;
  longitude: number = 0;

  registrationCompleted: boolean = false;
  responseMessage: string = '';

  constructor(private router: Router, private _adminDonationCenterService: AdminDonationCenterService) {}

  registerCenter() {
    let donation_center = new DonationCenterDTO();
        donation_center.name = this.name;
        donation_center.city = this.city;
        donation_center.country = this.country;
        donation_center.address = this.address;
        donation_center.description = this.description;
        donation_center.latitude = this.latitude;
        donation_center.longitude = this.longitude;

        this._adminDonationCenterService.registerCenter(donation_center).subscribe(
            (response) => {
                this.registrationCompleted = true;
                console.log(response);
            },
            (error) => {
                this.responseMessage = error.error;
            }

        );
    }

  contentIsValid() {
    return true;
  }
}
