import { Component, OnInit } from '@angular/core';
import { DonationCenter } from '../donation-center';
import { Router } from '@angular/router';
import { StaffHomepageService } from '../services/staff-homepage.service';

@Component({
  selector: 'app-staff-homepage',
  templateUrl: './staff-homepage.component.html',
  styleUrls: ['./staff-homepage.component.css']
})
export class StaffHomepageComponent implements OnInit{
  public centers = [] as DonationCenter[];
  errorMsg = "";
  selectedSortOption = "name"

  constructor(private router: Router, private _staffHomepageService: StaffHomepageService) { }

  ngOnInit(): void {
    this._staffHomepageService.getAllDonationCenters().subscribe(data => {this.centers = data},
      error => this.errorMsg = "Couldn't load centers");
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
    this.router.navigate(['staff-donation-center/' + id]);

  } 
}
