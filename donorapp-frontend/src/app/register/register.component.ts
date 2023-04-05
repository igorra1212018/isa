import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRegister } from './user-register';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  email: string = "horar70418@djpich.com";
  password: string = "hori123";
  confirmPassword: string = "hori123"
  firstName: string = "Hori";
  lastName: string = "Horic";
  address: string = "Nikole Tesle 12";
  city: string = "Novi Sad";
  country: string = "Serbia";
  phoneNumber: string = "063123123"
  jmbg: string = "3213213213213";
  gender: string = "MALE";
  occupation: string = "Student";
  occupationInfo: string = "Fakultet tehnickih nauka";

  registrationCompleted: boolean = false;
  responseMessage: string = "";

  constructor(private router: Router, private _registerService: RegisterService) { }

  ngOnInit(): void {
  
  }

  register() {
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
      response => {
        this.registrationCompleted = true;
        console.log(response);
      },
      error => {
        this.responseMessage = error.error;
      }
      /*
      success => setTimeout(() => {
        
        //this.router.navigate(['']);
      }, 800)*/);
  }

  contentIsValid(){
    return true;
  }

}