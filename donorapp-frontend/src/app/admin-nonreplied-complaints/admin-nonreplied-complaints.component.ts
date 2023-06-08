import { Component } from '@angular/core';
import { DonationCenterComplaint } from '../donation-center-complaint';
import { StaffComplaint } from '../staff-complaint';
import { AdminComplaint } from '../admin-complaint';
import { AdminNonrepliedComplaintsService } from '../services/admin-nonreplied-complaints.service';
import { Router } from '@angular/router';
import { DonationCenterComplaintReply } from '../donation-center-complaint-reply';
import { StaffComplaintReply } from '../staff-complaint-reply';

@Component({
  selector: 'app-admin-nonreplied-complaints',
  templateUrl: './admin-nonreplied-complaints.component.html',
  styleUrls: ['../shared-style.css']
})
export class AdminNonrepliedComplaintsComponent {
  public centerComplaints = [] as DonationCenterComplaint[];
  public staffComplaints = [] as StaffComplaint[];
  public complaints = [] as AdminComplaint[];
  errorMsg = "";
  displayOption = "center";
  selectedId = -1;
  text = "";

  constructor(private router: Router, private _adminNonepliedComplaintsService: AdminNonrepliedComplaintsService) { }
  
  loadCenterComplaints(): void {
    this._adminNonepliedComplaintsService.getNonRepliedDonationCenterComplaints().subscribe(data => {
      this.centerComplaints = data;
      this.updateDisplay();
    },
      error => this.errorMsg = "Couldn't load center complaints");
  }

  loadStaffComplaints(): void {
    this._adminNonepliedComplaintsService.getNonRepliedStaffComplaints().subscribe(data => {
      this.staffComplaints = data;
      this.updateDisplay();
    },
      error => this.errorMsg = "Couldn't load staff complaints");
  }

  ngOnInit(): void {
    this.loadCenterComplaints();
    this.loadStaffComplaints();
  }

  updateDisplay(): void {
    switch(this.displayOption){
      case "center":
        this.complaints = [];
        for(var i = 0; i < this.centerComplaints.length; i++){
          var centerComplaint = this.centerComplaints[i];
          var complaint = new AdminComplaint(centerComplaint.id, 'center', centerComplaint.centerName, centerComplaint.text,
                                            centerComplaint.reply, centerComplaint.userFirstName + ' ' + centerComplaint.userLastName);
          if(complaint.text != null)
            complaint.text = complaint.text.replaceAll("\n", "<br>");
          this.complaints.push(complaint);
          console.log(complaint);
        }
        break;
      case "staff":
        this.complaints = [];
        for(var i = 0; i < this.staffComplaints.length; i++){
          var staffComplaint = this.staffComplaints[i];
          var complaint = new AdminComplaint(staffComplaint.id, 'staff' ,staffComplaint.staffFirstName + ' ' + staffComplaint.staffLastName,
                                    staffComplaint.text, staffComplaint.reply, staffComplaint.userFirstName + ' ' + staffComplaint.userLastName);
          if(complaint.text != null)
            complaint.text = complaint.text.replaceAll("\n", "<br>");
          this.complaints.push(complaint);
          console.log(complaint);
        }
        break;
      default:
        break;
    }
    this.selectedId = -1;
  }

  selectComplaint(id: number): void {
    this.selectedId = id;
  }

  submitReply(): void {
    switch(this.displayOption){
      case "center":
        let centerComplaint = new DonationCenterComplaintReply(this.selectedId, this.text);
        this._adminNonepliedComplaintsService.replyDonationCenterComplaint(centerComplaint).subscribe(
        data => {
          this.loadCenterComplaints();
        },
        error => {
          this.errorMsg = "Submission failed."
        });
        break;
      case "staff":
        let staffComplaint = new StaffComplaintReply(this.selectedId, this.text);
        this._adminNonepliedComplaintsService.replyStaffComplaint(staffComplaint).subscribe(
        data => {
          this.loadStaffComplaints();
        },
        error => {
          this.errorMsg = "Submission failed."
        });
        break;
      default:
        break;
    }
  }
}
