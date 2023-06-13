import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
//import { Chart } from 'chart.js';
import Chart from 'chart.js/auto';
import { StaffDonationCenterService } from '../services/staff-donation-center.service';
import { DonationCenter } from '../donation-center';
import { StaffHomepageService } from '../services/staff-homepage.service';

@Component({
  selector: 'app-staff-graphical-analytics',
  templateUrl: './staff-graphical-analytics.component.html',
  styleUrls: ['./staff-graphical-analytics.component.css']
})
export class StaffGraphicalAnalyticsComponent implements OnInit {
  center: DonationCenter = new DonationCenter();


  constructor(private _donationService: StaffDonationCenterService, private _staffService: StaffHomepageService) {}

  ngOnInit(): void {
      this._staffService.getMyDonationCenter().subscribe((data) => {this.center = data});
      this.initializeCharts();
  }

  averageGrade() {
    new Chart('rating', {
      type: 'bar',
      data: {
        labels: ['Average rating'],
        datasets: [{
          label: 'Rating',
          data: [this.center.rating],
          borderWidth: 1
        }]
      },
    });
  }

  terms() {

  }

  expenses() {

  }

  blood() {

  }

  initializeCharts() {
    this.averageGrade();
    this.terms();
    this.expenses();
    this.blood();
  }

}