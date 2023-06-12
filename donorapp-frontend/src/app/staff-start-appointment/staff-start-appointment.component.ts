import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StaffReservationsService } from '../services/staff-reservations.service';
import { Equipment } from './equipment';
import { StaffQuestionnaireDTO } from './StaffQuestionnaireDTO';

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
  selectedValue: any;
  nazivOpreme: string = "";
  kolicinaOpreme: number = 0;

  responseMessage: string = '';
  usedEquipment = [] as Equipment[];
  reservationId: number = 0;

  
  constructor(private route: ActivatedRoute, private router: Router, private _processedReservationsService: StaffReservationsService) {}

  ngOnInit(): void {
    this.reservationId = Number(this.route.snapshot.paramMap.get('id'));
  }

  add() {
    let equipment = new Equipment(this.kolicinaOpreme, this.nazivOpreme);
    this.usedEquipment.push(equipment);
    console.log(this.usedEquipment);
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
    staffQuestionnaireDTO.odbijen = this.selectedValue;
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
