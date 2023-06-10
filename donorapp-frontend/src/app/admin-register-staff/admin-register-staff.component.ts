import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StaffService } from '../services/staff-service.service';
import { StaffDTO } from '../staff-profile/staffDTO';
import { AdminDonationCenterService } from '../services/admin-donation-center.service';
import { DonationCenterDTO } from '../admin-donation-center/donation-center';
import { DonationCenter } from '../donation-center';

@Component({
  selector: 'app-admin-register-staff',
  templateUrl: './admin-register-staff.component.html',
  styleUrls: ['./admin-register-staff.component.css']
})
export class AdminRegisterStaffComponent implements OnInit {
  email: string = 'horar70418@djpich.com';
  password: string = 'hori123';
  confirmPassword: string = 'hori123';
  firstName: string = 'Hori';
  lastName: string = 'Horic';
  address: string = 'Nikole Tesle 12';
  city: string = 'Novi Sad';
  country: string = 'Serbia';
  phoneNumber: string = '063123123';
  jmbg: string = '3213213213213';
  gender: string = 'MALE';
  occupation: string = 'Student';
  occupationInfo: string = 'Fakultet tehnickih nauka';

  registrationCompleted: boolean = false;
  responseMessage: string = '';
  donationCenters= [] as DonationCenter[];

  value: string = "";
  viewValue: string = "";
  selectedValue: any;

  constructor(private router: Router, private _staffService: StaffService, private _adminDonationCenterService: AdminDonationCenterService) {}

  ngOnInit(): void {
    this._adminDonationCenterService.getAllDonationCenters().subscribe(data =>{
      this.donationCenters = data;
      console.log(data);
   });
  } 

  register() {

      let staff = new StaffDTO();
      staff.email = this.email;
      staff.password = this.password;
      staff.firstName = this.firstName;
      staff.lastName = this.lastName;
      staff.address = this.address;
      staff.city = this.city;
      staff.country = this.country;
      staff.phoneNumber = this.phoneNumber;
      staff.gender = this.gender;
      staff.jmbg = this.jmbg;
      staff.occupation = this.occupation;
      staff.occupationInfo = this.occupationInfo;
      staff.centerId = this.selectedValue;

      console.log(staff);

      this._staffService.registerStaff(staff).subscribe(
          (response) => {
              this.registrationCompleted = true;
              console.log(response);
          },
          (error) => {
              this.responseMessage = error.error;
          });
  }

  contentIsValid() {
      return true;
  }
}
