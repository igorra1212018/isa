import { Component } from '@angular/core';
import { UserFileComplaintService } from '../services/user-file-complaint.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CenterFileComplaint } from '../center-file-complaint';
import { DonationCenterComplaintCreate } from '../donation-center-complaint-create';
import { StaffComplaintCreate } from '../staff-complaint-create';

@Component({
  selector: 'app-user-file-complaint',
  templateUrl: './user-file-complaint.component.html',
  styleUrls: ['../shared-style.css']
})
export class UserFileComplaintComponent {
  text = "";
  errorMsg = "";
  center!: CenterFileComplaint;
  selectedStaff = -1;
  complaintType = "center";
  submitCompleted = false;

  constructor(private route: ActivatedRoute, private router: Router, private _userFileComplaintService: UserFileComplaintService) { }
  
  ngOnInit(): void {
    this.center = new CenterFileComplaint(-1, "", []);
    let centerId = Number(this.route.snapshot.paramMap.get('id'));
    this._userFileComplaintService.getDonationCenter(centerId).subscribe(data => {
      this.center = data;
    },
      error => this.errorMsg = "Couldn't load center");
  }

  submit() {
    switch(this.complaintType){
      case "center":
        let centerComplaint = new DonationCenterComplaintCreate(this.center.id, this.text);
        this._userFileComplaintService.centerComplaintSubmit(centerComplaint).subscribe(
        data => {
          this.submitCompleted = true;
        },
        error => {
          this.errorMsg = "Submission failed."
        });
        break;
      case "staff":
        let staffComplaint = new StaffComplaintCreate(this.selectedStaff, this.text);
        this._userFileComplaintService.staffComplaintSubmit(staffComplaint).subscribe(
        data => {
          this.submitCompleted = true;
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
