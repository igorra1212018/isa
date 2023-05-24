import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProfileService } from '../services/user-profile.service';
import { StaffService } from '../services/staff-service.service';
import { StaffDTO } from './staffDTO';

enum Role {
  USER,
  ADMINISTRATOR,
  STAFF,
}

@Component({
  selector: 'app-staff-profile',
  templateUrl: './staff-profile.component.html',
  styleUrls: ['./staff-profile.component.css']
})
export class StaffProfileComponent implements OnInit {

  email: string = '';
  newPassword: string = '';
  confirmPassword: string = '';
  firstName: string = '';
  lastName: string = '';
  address: string = '';
  city: string = '';
  country: string = '';
  phoneNumber: string = '';
  jmbg: string = '';
  gender: string = '';
  occupation: string = '';
  occupationInfo: string = '';
  role: Role = Role.STAFF;
  staffDTO: StaffDTO = new StaffDTO();

  infoChanged: boolean = false;
  responseMessage: string = '';
  
  constructor(private router: Router, private _staffService: StaffService) {}

  ngOnInit(): void {
    this._staffService.GetUserData().subscribe(data => {
      this.staffDTO = data
      this.email = this.staffDTO.email
      this.firstName = this.staffDTO.firstName
      this.lastName = this.staffDTO.lastName
      this.address = this.staffDTO.address
      this.city = this.staffDTO.city
      this.country = this.staffDTO.country
      this.phoneNumber = this.staffDTO.phoneNumber
      this.jmbg = this.staffDTO.jmbg
      this.gender = this.staffDTO.gender
      this.occupation = this.staffDTO.occupation
      this.occupationInfo = this.staffDTO.occupationInfo
    },);
  }

  changeInfo() {
    let user = new StaffDTO();
        user.email = this.email;
        user.password = this.newPassword;
        user.firstName = this.firstName;
        user.lastName = this.lastName;
        user.address = this.address;
        user.city = this.city;
        user.country = this.country;
        user.phoneNumber = this.phoneNumber;
        user.gender = this.gender;
        user.jmbg = this.jmbg;
        user.occupation = this.occupation;
        user.occupationInfo = this.occupationInfo;

        this._staffService.updateStaffInfo(user).subscribe(
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
