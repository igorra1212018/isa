import { Component } from '@angular/core';
import { DonationCenterComplaint } from '../donation-center-complaint';
import { StaffComplaint } from '../staff-complaint';
import { AdminRepliedComplaintsService } from '../services/admin-replied-complaints.service';
import { Router } from '@angular/router';
import { AdminComplaint } from '../admin-complaint';

@Component({
  selector: 'app-admin-replied-complaints',
  templateUrl: './admin-replied-complaints.component.html',
  styleUrls: ['../shared-style.css']
})
export class AdminRepliedComplaintsComponent {
  public centerComplaints = [] as DonationCenterComplaint[];
  public staffComplaints = [] as StaffComplaint[];
  public complaints = [] as AdminComplaint[];
  errorMsg = "";
  displayOption = "center";

  constructor(private router: Router, private _adminRepliedComplaintsService: AdminRepliedComplaintsService) { }
  
  ngOnInit(): void {
    this._adminRepliedComplaintsService.getRepliedDonationCenterComplaints().subscribe(data => {
      this.centerComplaints = data;
      this.updateDisplay();
    },
      error => this.errorMsg = "Couldn't load center complaints");

    this._adminRepliedComplaintsService.getRepliedStaffComplaints().subscribe(data => {
      this.staffComplaints = data;
    },
      error => this.errorMsg = "Couldn't load staff complaints");
  }

  updateDisplay(): void {
    switch(this.displayOption){
      case "center":
        this.complaints = [];
        for(var i = 0; i < this.centerComplaints.length; i++){
          var centerComplaint = this.centerComplaints[i];
          var complaint = new AdminComplaint(centerComplaint.centerId, 'center', centerComplaint.centerName, centerComplaint.text,
                                            centerComplaint.reply, centerComplaint.userFirstName + ' ' + centerComplaint.userLastName);
          if(complaint.text != null)
            complaint.text = complaint.text.replaceAll("\n", "<br>");
          if(complaint.reply != null)
            complaint.reply = complaint.reply.replaceAll("\n", "<br>");
          this.complaints.push(complaint);
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
          if(complaint.reply != null)
            complaint.reply = complaint.reply.replaceAll("\n", "<br>");
          this.complaints.push(complaint);
        }
        break;
      default:
        break;
    }
  }
}
