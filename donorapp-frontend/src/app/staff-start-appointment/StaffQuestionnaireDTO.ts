import { Time } from "@angular/common";
import { Equipment } from "./equipment";

export class StaffQuestionnaireDTO {
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
	odbijen: boolean = false;
	razlogOdbijanja: string = "";	
	tipKese: string = "";	
	brojLotaKese: number = 0;	
	mestoPunkcije: string = "";	
	pocetakDavanja: any;
	zavrsetakDavanja: any;
	kolicinaUzeteKrvi: number = 0;	
	razlogPrekida: string = "";	
	equipment = [] as Equipment[];
	reservationId: number = 0;	
}