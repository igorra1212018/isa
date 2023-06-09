import { Component, OnInit } from '@angular/core';
//import 'ol/ol.css';
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import {useGeographic} from 'ol/proj.js';
import { DonationCenter } from '../donation-center';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDonationCenterService } from '../services/user-donation-center.service';
import { Term } from '../term';
import { StarRatingColor } from '../star-rating/star-rating.component';
import { DonationCenterScore } from '../donation-center-score';

useGeographic();

@Component({
  selector: 'app-user-donation-center',
  templateUrl: './user-donation-center.component.html',
  styleUrls: ['./user-donation-center.component.css']
})
export class UserDonationCenterComponent implements OnInit{
  map: Map | null = null;
  center: DonationCenter = new DonationCenter();
  errorMsg = "";
  public terms = [] as Term[];
  selectedSortOption = "date";
  donationCenterScore: DonationCenterScore = new DonationCenterScore();

  rating:number = 3;
  starCount:number = 5;
  starColor:StarRatingColor = StarRatingColor.accent;
  starColorP:StarRatingColor = StarRatingColor.primary;
  starColorW:StarRatingColor = StarRatingColor.warn;
  public ratingExists: boolean = true;

  constructor(private route: ActivatedRoute, private router: Router, private _userDonationCenterService: UserDonationCenterService) { }
  
  loadTerms(centerId: number) {
    this._userDonationCenterService.getFreeTerms(centerId).subscribe(data => {
      this.terms = data;
      this.terms.forEach(function (value) {
        value.date = new Date(value.date);
      });
      this.sortTerms();
    },
      error => this.errorMsg += "\nCouldn't load terms");
  }

  loadScore(centerId: number){
    this._userDonationCenterService.getCenterScore(centerId).subscribe(data => {
      this.donationCenterScore = data;
      if(data == null){
        this.rating = 0;
      }else{
        this.rating = this.donationCenterScore.score;
      }
     });
  }

  ngOnInit() {
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this._userDonationCenterService.getDonationCenter(centerId).subscribe(data => {
      this.center = data
      const latitude = this.center.latitude;
      const longitude = this.center.longitude;
      console.log(latitude + ", " + longitude);

      this.loadScore(centerId);

      if(this.center.rating == 0){
        this.ratingExists = false
      }else{
        this.ratingExists = true;
      }

      console.log(this.ratingExists);
      console.log(this.center.rating);
      
      this.loadTerms(centerId);
      
      const view = new View({
        center: [longitude, latitude],
        zoom: 19,
      });
  
      const layer = new TileLayer({
        source: new OSM(),
      });

      this.map = new Map({
        target: 'map',
        layers: [layer],
        view: view,
        interactions: [],
        controls: []
      });
    },
      error => this.errorMsg = "Couldn't load center");

  }

  onRatingChanged(rating: number){
    let newScore = new DonationCenterScore();
    newScore.id = this.donationCenterScore.id;
    newScore.score = rating;
    newScore.centerId = this.center.id;
    console.log(rating);
    this.rating = rating;
    console.log(newScore);
    if(this.ratingExists == false){
      this._userDonationCenterService.setCenterScore(newScore).subscribe();
    }
    else{
      this._userDonationCenterService.updateCenterScore(newScore).subscribe();
    }
  }

  reserve(id: number) {
    this._userDonationCenterService.reserve(id).subscribe(
      response => {
        console.log(response);
        let centerId = Number(this.route.snapshot.paramMap.get('id'));
        this.loadTerms(centerId);
        this.sortTerms();
      },
      error => {
        console.log(error.error);
      });
  }

  sortTerms(): void {
    switch (this.selectedSortOption) {
      case 'date':
        this.terms.sort((a, b) => {
          const dateA = new Date(a.date).setHours(0, 0, 0, 0);
          const dateB = new Date(b.date).setHours(0, 0, 0, 0);
          return dateA - dateB;
        });
        break;
      case 'time':
        this.terms.sort((a, b) => {
          const timeA = new Date(a.date).getTime() % (24 * 60 * 60 * 1000);
          const timeB = new Date(b.date).getTime() % (24 * 60 * 60 * 1000);
          return timeA - timeB;
        });
        break;
      default:
        break;
    }
  }

  complain(): void {
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this.router.navigate(['user-file-complaint/' + centerId]);
  }
}
