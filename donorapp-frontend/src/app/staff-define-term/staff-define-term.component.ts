import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StaffDonationCenterService } from '../services/staff-donation-center.service';
import { TermDTO } from './termDTO';
import { TermAddDTO } from './termAddDTO';

@Component({
    selector: 'app-staff-define-term',
    templateUrl: './staff-define-term.component.html',
    styleUrls: ['./staff-define-term.component.css'],
})
export class StaffDefineTermComponent implements OnInit {
    public terms = [] as TermDTO[];
    errorMsg = '';
    selectedDate: Date = new Date();
    showAlreadyDefinedTerms = false;
    termHHMM: string = '';
    duration: number = 30;
    centerId: number = 0;
    stringDate: string = '';
    finalDate: Date = new Date();
    overlapDetected: boolean = false;
    pipe = new DatePipe('en-US');

    constructor(private route: ActivatedRoute, private _staffDonationCenterService: StaffDonationCenterService) {}

    onDateChange() {
        this.getFreeTermsForDate();
        this.showAlreadyDefinedTerms = true;
        this.overlapDetected = false;
        this.termHHMM = '';
        this.parseTime();
        this.checkOverlap();
    }

    onTimeChange() {
        this.overlapDetected = false;
        this.parseTime();
        this.checkOverlap();
    }

    getFreeTermsForDate() {
        this._staffDonationCenterService.getFreeTermsForDate(this.centerId, new Date(this.selectedDate)).subscribe(
            (data) => {
                this.terms = data;
                this.terms.forEach(function (value) {
                    value.date = new Date(value.date);
                });
                this.sortTerms();
            },
            (error) => (this.errorMsg += "\nCouldn't load terms")
        );
    }

    ngOnInit() {
        this.centerId = Number(this.route.snapshot.paramMap.get('id'));
    }

    parseTime() {
        var regexp = new RegExp("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
        if (!regexp.test(this.termHHMM))
            return;
        const hours = Number(this.termHHMM.split(':')[0]);
        const minutes = Number(this.termHHMM.split(':')[1]);
        const temp1 = new Date(this.selectedDate).setHours(hours, minutes);
        this.stringDate = this.pipe.transform(new Date(temp1), 'yyyy-MM-dd HH:mm:ss') as string;
        if (this.stringDate !== null) this.finalDate = new Date(this.stringDate);
    }

    checkOverlap() {
        const finalDateMs = this.finalDate.getTime();

        for (const term of this.terms) {
            const termDateMs = new Date(term.date).getTime();

            if (finalDateMs >= termDateMs && finalDateMs < termDateMs + term.duration * 60 * 1000) {
                this.overlapDetected = true;
            }
        }
    }

    addTerm() {
        this.parseTime();
        this.checkOverlap();
        let newTerm: TermAddDTO = new TermAddDTO(this.stringDate, this.duration, this.centerId);
        this._staffDonationCenterService.addNewTerm(newTerm).subscribe(
            (data) => {},
            (error) => (this.errorMsg = 'Failed to add term!')
        );
    }

    sortTerms(): void {
        this.terms.sort((a, b) => {
            const timeA = new Date(a.date).getTime() % (24 * 60 * 60 * 1000);
            const timeB = new Date(b.date).getTime() % (24 * 60 * 60 * 1000);
            return timeA - timeB;
        });
    }
}
