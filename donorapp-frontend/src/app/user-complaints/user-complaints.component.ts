import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserComplaintsService } from '../services/user-complaints.service';
import { DonationCenterComplaint } from '../donation-center-complaint';
import { StaffComplaint } from '../staff-complaint';
import { UserComplaint } from '../user-complaint';

@Component({
  selector: 'app-user-complaints',
  templateUrl: './user-complaints.component.html',
  styleUrls: ['../shared-style.css']
})
export class UserComplaintsComponent {
  public centerComplaints = [] as DonationCenterComplaint[];
  public staffComplaints = [] as StaffComplaint[];
  public complaints = [] as UserComplaint[];
  errorMsg = "";
  displayOption = "center";

  constructor(private router: Router, private _userComplaintsService: UserComplaintsService) { }
  
  ngOnInit(): void {
    this._userComplaintsService.getDonationCenterComplaints().subscribe(data => {
      this.centerComplaints = data;
      this.updateDisplay();
    },
      error => this.errorMsg = "Couldn't load center complaints");

    this._userComplaintsService.getStaffComplaints().subscribe(data => {
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
          var complaint = new UserComplaint(centerComplaint.centerName, centerComplaint.text, centerComplaint.reply);
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
          var complaint = new UserComplaint(staffComplaint.staffFirstName + ' ' + staffComplaint.staffLastName, staffComplaint.text,
                                            staffComplaint.reply);
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
