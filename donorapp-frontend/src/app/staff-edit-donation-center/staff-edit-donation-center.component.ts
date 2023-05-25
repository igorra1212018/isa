import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StaffDonationCenterService } from '../services/staff-donation-center.service';
import { DonationCenterDTO } from '../admin-donation-center/donation-center';

@Component({
  selector: 'app-staff-edit-donation-center',
  templateUrl: './staff-edit-donation-center.component.html',
  styleUrls: ['./staff-edit-donation-center.component.css']
})
export class StaffEditDonationCenterComponent implements OnInit {
  name: string = "";
  city: string = "";
  country: string = "";
  address: string = "";
  description: string = "";
  latitude: number = 0;
  longitude: number = 0;
  donationCenterDTO: DonationCenterDTO = new DonationCenterDTO();

  infoChanged: boolean = false;
  responseMessage: string = '';

  constructor(private route: ActivatedRoute, private router: Router, private _staffDonationService: StaffDonationCenterService) {}

  ngOnInit(): void {
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this._staffDonationService.getDonationCenter(centerId).subscribe(data => {
      this.donationCenterDTO = data
      this.name = this.donationCenterDTO.name;
      this.city = this.donationCenterDTO.city;
      this.country = this.donationCenterDTO.country;
      this.address = this.donationCenterDTO.address;
      this.description = this.donationCenterDTO.description;
      this.latitude = this.donationCenterDTO.latitude;
      this.longitude = this.donationCenterDTO.longitude;

    },);
  }

  changeInfo(){
    let donationCenter = new DonationCenterDTO();
    donationCenter.name = this.name;
    donationCenter.city = this.city;
    donationCenter.country = this.country;
    donationCenter.address = this.address;
    donationCenter.description = this.description;
    donationCenter.latitude= this.latitude;
    donationCenter.longitude= this.longitude;

    this._staffDonationService.updateDonationCenterInfo(donationCenter).subscribe(
      (response) => {
          this.infoChanged = true;
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
