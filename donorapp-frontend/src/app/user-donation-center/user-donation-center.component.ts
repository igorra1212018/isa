import { Component, OnInit } from '@angular/core';
//import 'ol/ol.css';
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import {useGeographic} from 'ol/proj.js';
import { DonationCenter } from '../donation-center';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDonationCenterService } from '../user-donation-center.service';
import { Term } from '../term';

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

  constructor(private route: ActivatedRoute, private router: Router, private _userDonationCenterService: UserDonationCenterService) { }
  
  loadTerms(centerId: number) {
    this._userDonationCenterService.getFreeTerms(centerId).subscribe(data => {
      this.terms = data;
      this.terms.forEach(function (value) {
        value.date = new Date(value.date);
      });
    },
      error => this.errorMsg += "\nCouldn't load terms");
  }

  ngOnInit() {
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this._userDonationCenterService.getDonationCenter(centerId).subscribe(data => {
      this.center = data
      const latitude = this.center.latitude;
      const longitude = this.center.longitude;
      console.log(latitude + ", " + longitude);
      
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
        interactions: []
      });
    },
      error => this.errorMsg = "Couldn't load center");


  }

  reserve(id: number) {
    this._userDonationCenterService.reserve(id).subscribe(
      response => {
        console.log(response);
        let centerId = Number(this.route.snapshot.paramMap.get('id'));
        this.loadTerms(centerId);
      },
      error => {
        console.log(error.error);
      });
  }
}
