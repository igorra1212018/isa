import { Component, OnInit } from '@angular/core';
import { useGeographic } from 'ol/proj';
import Map from 'ol/Map';
import View from 'ol/View';
import { DonationCenter } from '../donation-center';
import { Term } from '../term';
import { ActivatedRoute, Router } from '@angular/router';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import { StaffDonationCenterService } from '../services/staff-donation-center.service';
import { StaffDTO } from '../staff-profile/staffDTO';
import { StaffService } from '../services/staff-service.service';

useGeographic();

@Component({
  selector: 'app-staff-donation-center',
  templateUrl: './staff-donation-center.component.html',
  styleUrls: ['./staff-donation-center.component.css']
})
export class StaffDonationCenterComponent implements OnInit{

  map: Map | null = null;
  public staff = [] as StaffDTO[];
  public otherStaff: string = "";
  center: DonationCenter = new DonationCenter();
  errorMsg = "";
  public terms = [] as Term[];
  selectedSortOption = "date";

  constructor(private route: ActivatedRoute, private router: Router, private _staffDonationCenterService: StaffDonationCenterService, private _staffService: StaffService) { }
  
  loadTerms(centerId: number) {
    this._staffDonationCenterService.getFreeTerms(centerId).subscribe(data => {
      this.terms = data;
      this.terms.forEach(function (value) {
        value.date = new Date(value.date);
      });
      this.sortTerms();
    },
      error => this.errorMsg += "\nCouldn't load terms");
  }

  loadStaff(){
    this._staffService.getStaffByCenterId().subscribe(data => {
      this.staff = data;
       this.staff.forEach(function(value){
        value.firstName
      })
    });
  }

  ngOnInit() {
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this._staffDonationCenterService.getDonationCenter(centerId).subscribe(data => {
      this.center = data
      const latitude = this.center.latitude;
      const longitude = this.center.longitude;
      console.log(data);
      this.loadStaff();
      
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

  update() {
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this.router.navigate(['staff-edit-donation-center/' + centerId]);
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
}
