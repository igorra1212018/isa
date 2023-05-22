import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRegister } from '../register/user-register';
import { RegisterService } from '../services/register.service';

enum Role {
    USER,
    ADMINISTRATOR,
    STAFF,
}

@Component({
    selector: 'app-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
    email: string = 'horar70418@djpich.com';
    password: string = 'hori123';
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
    role: Role = Role.USER;

    infoChanged: boolean = false;
    responseMessage: string = '';

    constructor(private router: Router, private _registerService: RegisterService) {}

    ngOnInit(): void {}

    changeInfo() {
        //TODO: validacija unosa

        let user = new UserRegister();
        user.email = this.email;
        user.password = this.password;
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

        this._registerService.register(user).subscribe(
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
