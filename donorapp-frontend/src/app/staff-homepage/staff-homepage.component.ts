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
  public center = new DonationCenter;
  errorMsg = "";
  selectedSortOption = "name"

  constructor(private router: Router, private _staffHomepageService: StaffHomepageService) { }

  ngOnInit(): void {
    this._staffHomepageService.getMyDonationCenter().subscribe(data => {this.center = data},
      error => this.errorMsg = "Couldn't load centers");
  }

  openCenter(id: number): void {
    this.router.navigate(['staff-donation-center/' + id]);

  } 
}
