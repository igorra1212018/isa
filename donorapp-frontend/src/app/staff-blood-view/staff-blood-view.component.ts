import { Component, OnInit } from '@angular/core';
import { StaffBloodService } from '../services/staff-blood.service';

@Component({
  selector: 'app-staff-blood-view',
  templateUrl: './staff-blood-view.component.html',
  styleUrls: ['./staff-blood-view.component.css']
})
export class StaffBloodViewComponent implements OnInit{
  type: string = "";
  quantity: number = 0;
  dataSource: any;

  displayedColumns: string[] = ['type', 'quantity'];

  constructor(private _bloodService: StaffBloodService) { }

  ngOnInit(): void {
    this._bloodService.getAllBloodTypes().subscribe(data =>{
      this.dataSource = data;
    })
  }

}
