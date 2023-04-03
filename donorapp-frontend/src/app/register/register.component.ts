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
  firstName: string = "Hori";
  lastName: string = "Horic";
  address: string = "HH 12";
  city: string = "Hori Had";
  country: string = "Horbia";
  jmbg: string = "3213213213213";
  gender: string = "MALE";
  occupation: string = "FFFFF";
  occupationInfo: string = "KKKKK SSS";

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
    user.gender = this.gender;
    user.jmbg = this.jmbg;
    user.occupation = this.occupation;
    user.occupationInfo = this.occupationInfo;

    this._registerService.register(user).subscribe(
      success => setTimeout(() => {
        this.router.navigate(['login']);
      }, 800));
  }

  contentIsValid(){
    return true;
  }

}