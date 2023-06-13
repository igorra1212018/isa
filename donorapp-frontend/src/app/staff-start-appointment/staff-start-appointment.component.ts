import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StaffReservationsService } from '../services/staff-reservations.service';
import { Equipment } from './equipment';
import { StaffQuestionnaireDTO } from './StaffQuestionnaireDTO';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-staff-start-appointment',
  templateUrl: './staff-start-appointment.component.html',
  styleUrls: ['./staff-start-appointment.component.css']
})
export class StaffStartAppointmentComponent implements OnInit {

	krvnaGrupa: string = "";	
	napomenaDoktoru: string = "";	
	bakarSulfat: number = 0;	
	nivo: string = "";		
	hemoglobinometar: number = 0;	
	ocitanaVrednost: number = 0;	
	pluca: string = "";	
	srce: string = "";	
	gornjiPritisak: number = 0;	
	donjiPritisak: number = 0;		
	trombinskoVreme: number = 0;		
	razlogOdbijanja: string = "";	
	tipKese: string = "";	
	brojLotaKese: number = 0;	
	mestoPunkcije: string = "";	
  kolicinaUzeteKrvi: number = 0;	
	pocetakDavanja: any;
	zavrsetakDavanja: any;
	razlogPrekida: string = "";	
  selectedValueRejected: any;
  nazivOpreme: string = "";
  kolicinaOpreme: number = 0;


  responseMessage: string = '';
  centerEquipment = [] as Equipment[];
  usedEquipment = [] as Equipment[];
  reservationId: number = 0;
  viewValue: string = "";
  selectedValue: any;
  equipmentName: string = "";
  
  constructor(private route: ActivatedRoute, private router: Router, private _processedReservationsService: StaffReservationsService, private snackBar: MatSnackBar) {}

  ngOnInit(): void {
    this.reservationId = Number(this.route.snapshot.paramMap.get('id'));
    this.initEquipment();
  }

  initEquipment() {
    this._processedReservationsService.getEquipmentFromCenter().subscribe(data =>{
      this.centerEquipment = data;
      console.log(data);
   });
  }

  add() {
         this.centerEquipment.forEach(element => {
        if(element.id == this.selectedValue){
        this.equipmentName = element.name
        }
      });
      if(this.equipmentName != ""){
      let equipment = new Equipment(this.selectedValue, this.kolicinaOpreme, this.equipmentName);
      console.log(equipment);
      console.log(this.usedEquipment);
      if(this.usedEquipment.length == 0){ 
        this.usedEquipment.push(equipment);
        console.log(this.usedEquipment);
        this.viewValue = this.viewValue.concat(this.equipmentName + "-" + this.kolicinaOpreme + ", ");
      }else {
      this.usedEquipment.forEach(element => {      
        if(element.id == this.selectedValue){ 
          this.snackBar.open('Ta oprema je vec dodata', '', {
            duration: 2000
          });}
          else{
            this.usedEquipment.push(equipment);
            console.log(this.usedEquipment);
            this.viewValue = this.viewValue.concat(this.equipmentName + "-" + this.kolicinaOpreme + ", ");
          }
        });    
      }
    }else{
      this.snackBar.open('Niste izabrali opremu', '', {
        duration: 2000
      });
    }
  }

  saveAppointment() {
    let staffQuestionnaireDTO = new StaffQuestionnaireDTO();
    staffQuestionnaireDTO.krvnaGrupa = this.krvnaGrupa;
    staffQuestionnaireDTO.napomenaDoktoru = this.napomenaDoktoru;
    staffQuestionnaireDTO.bakarSulfat = this.bakarSulfat;
    staffQuestionnaireDTO.nivo = this.nivo;
    staffQuestionnaireDTO.hemoglobinometar = this.hemoglobinometar;
    staffQuestionnaireDTO.ocitanaVrednost = this.ocitanaVrednost;
    staffQuestionnaireDTO.pluca = this.pluca;
    staffQuestionnaireDTO.srce = this.srce;
    staffQuestionnaireDTO.gornjiPritisak = this.gornjiPritisak;
    staffQuestionnaireDTO.donjiPritisak = this.donjiPritisak;
    staffQuestionnaireDTO.trombinskoVreme = this.trombinskoVreme;
    staffQuestionnaireDTO.odbijen = this.selectedValueRejected;
    staffQuestionnaireDTO.razlogOdbijanja = this.razlogOdbijanja;
    staffQuestionnaireDTO.tipKese = this.tipKese;
    staffQuestionnaireDTO.brojLotaKese = this.brojLotaKese;
    staffQuestionnaireDTO.mestoPunkcije = this.mestoPunkcije;
    staffQuestionnaireDTO.pocetakDavanja = this.pocetakDavanja;
    staffQuestionnaireDTO.zavrsetakDavanja = this.zavrsetakDavanja;
    staffQuestionnaireDTO.kolicinaUzeteKrvi = this.kolicinaUzeteKrvi;
    staffQuestionnaireDTO.razlogPrekida = this.razlogPrekida;
    staffQuestionnaireDTO.equipment = this.usedEquipment;
    staffQuestionnaireDTO.reservationId = this.reservationId;
    console.log(staffQuestionnaireDTO);
    this._processedReservationsService.startAppointment(staffQuestionnaireDTO).subscribe(
      (response) => {
           console.log(response);
      },
      (error) => {
          this.responseMessage = error.error;
      }
  );

  }

}
