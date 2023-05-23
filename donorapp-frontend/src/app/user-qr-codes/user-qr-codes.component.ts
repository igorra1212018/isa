import { Component } from '@angular/core';
import { ReservationQR } from '../reservation-qr';
import { Router } from '@angular/router';
import { UserQrCodesService } from '../services/user-qr-codes.service';

@Component({
  selector: 'app-user-qr-codes',
  templateUrl: './user-qr-codes.component.html',
  styleUrls: ['./user-qr-codes.component.css']
})
export class UserQrCodesComponent {
  public reservations = [] as ReservationQR[];
  public displayReservations = [] as ReservationQR[];
  errorMsg = "";
  selectedSortOption = "date"
  filterOption = "ALL";

  constructor(private router: Router, private _userQRCodesService: UserQrCodesService) { }
  
  ngOnInit(): void {
    this._userQRCodesService.getAllReservationQRs().subscribe(data => {
      this.reservations = data;
      for(var i = 0; i < this.reservations.length; i++)
        this.reservations[i].creationDate = new Date(this.reservations[i].creationDate);
      this.filterandSortReservations();
    },
      error => this.errorMsg = "Couldn't load reservations");
  }
  
  filterandSortReservations(): void {
    // Filter
    if(this.filterOption == "NEW" || this.filterOption == "PROCESSED" || this.filterOption == "REJECTED")
      this.displayReservations = this.reservations.filter((element) => element.status == this.filterOption);
    else{
      this.displayReservations = this.reservations;
    }
    // Sort
    switch (this.selectedSortOption) {
      case 'date':
        this.displayReservations.sort((a, b) => {return b.creationDate.getTime() - a.creationDate.getTime()});
        break;
      case 'status':
        this.displayReservations.sort((a, b) => a.status.localeCompare(b.status));
        break;
      default:
        break;
    }
  }
}
