import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  public role: any;

  constructor(private router: Router) { }
  ngOnInit(): void {
    this.role = localStorage.getItem('Role');
    console.log(this.role);

    if(this.role == "ROLE_USER"){
      this.role = "user";
    }
    else if (this.role == "ROLE_ADMINISTRATOR"){
      this.role = "admin";
    }
    else if (this.role == "ROLE_STAFF"){
      this.role = "staff";
    }
    else {
      this.role = " ";
    }

  }

  signout(){
    localStorage.clear();
  }

}
