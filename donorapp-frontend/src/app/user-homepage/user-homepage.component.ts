import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserHomepageService } from '../services/user-homepage.service';
import { DonationCenter } from '../donation-center';
import { UserHomepageInfo } from '../user-homepage-info';
import { Role } from '../role';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit{
  penaltyCount: number = 0;
  public centers = [] as DonationCenter[];
  userInfo!: UserHomepageInfo;
  errorMsg = "";
  selectedSortOption = "name"
  loadUserFailed = false;

  constructor(private router: Router, private _userHomepageService: UserHomepageService) { }
  
  ngOnInit(): void {
    this.userInfo = new UserHomepageInfo("", "", "", 0);

    this._userHomepageService.getAllDonationCenters().subscribe(data => {this.centers = data},
      error => this.errorMsg = "Couldn't load centers");

    let role = localStorage.getItem("Role");
    if(role == Role.User)
      this._userHomepageService.getUserInfo().subscribe(data => {this.userInfo = data;},
        error => this.loadUserFailed = true);
    else
        this.loadUserFailed = true;
    
  }

  sortCenters(): void {
    switch (this.selectedSortOption) {
      case 'name':
        this.centers.sort((a, b) => a.name.localeCompare(b.name));
        break;
      case 'rating':
        this.centers.sort((a, b) => b.rating - a.rating);
        break;
      case 'city':
        this.centers.sort((a, b) => a.city.localeCompare(b.city));
        break;
      default:
        break;
    }
  }

  openCenter(id: number): void {
    this.router.navigate(['user-donation-center/' + id]);
  } 
}
