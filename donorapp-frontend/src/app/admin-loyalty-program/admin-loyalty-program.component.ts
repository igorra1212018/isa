import { Component, OnInit } from '@angular/core';
import { LoyaltyProgramDTO } from './loyaltyProgramDTO';
import { AdminDonationCenterService } from '../services/admin-donation-center.service';

@Component({
  selector: 'app-admin-loyalty-program',
  templateUrl: './admin-loyalty-program.component.html',
  styleUrls: ['./admin-loyalty-program.component.css']
})
export class AdminLoyaltyProgramComponent implements OnInit {
  loyaltyProgram: LoyaltyProgramDTO = new LoyaltyProgramDTO(0, '', 0, '', 0, '', 0);
  pointsPerDonation: number = 0;
  category1Name: string = '';
  category1Points: number = 0;
  category2Name: string = '';
  category2Points: number = 0;
  category3Name: string = '';
  category3Points: number = 0;

  constructor(private _adminService: AdminDonationCenterService) {
    
  }

  ngOnInit(): void {
      this._adminService.loadLoyaltyProgram().subscribe(
        (data) => {
          this.pointsPerDonation = data.pointsPerDonation;
          this.category1Name = data.category1Name;
          this.category1Points = data.category1Points;
          this.category2Name = data.category2Name;
          this.category2Points = data.category2Points;
          this.category3Name = data.category3Name;
          this.category3Points = data.category3Points;
        }
      );
  }

  updateData() {
    this.loyaltyProgram.pointsPerDonation = this.pointsPerDonation;
    this.loyaltyProgram.category1Name = this.category1Name;
    this.loyaltyProgram.category2Name = this.category2Name;
    this.loyaltyProgram.category3Name = this.category3Name;
    this.loyaltyProgram.category1Points = this.category1Points;
    this.loyaltyProgram.category2Points = this.category2Points;
    this.loyaltyProgram.category3Points = this.category3Points;

  }



  saveLoyaltyProgram() {
    this.updateData();
    this._adminService.updateLoyaltyProgram(this.loyaltyProgram).subscribe();
  }
}
