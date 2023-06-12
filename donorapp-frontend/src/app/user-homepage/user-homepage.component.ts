import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserHomepageService } from '../services/user-homepage.service';
import { DonationCenter } from '../donation-center';
import { UserHomepageInfo } from '../user-homepage-info';
import { Role } from '../role';

@Component({
    selector: 'app-user-homepage',
    templateUrl: './user-homepage.component.html',
    styleUrls: ['./user-homepage.component.css'],
})
export class UserHomepageComponent implements OnInit {
    penaltyCount: number = 0;
    public centers = [] as DonationCenter[];
    public centersSearchResult = [] as DonationCenter[];
    userInfo!: UserHomepageInfo;
    errorMsg = '';
    selectedSortOption = 'name';
    loadUserFailed = true;
    searchField: string = '';
    selectedFilterOption: string = '-1';

    constructor(private router: Router, private _userHomepageService: UserHomepageService) {}

    ngOnInit(): void {
        this.userInfo = new UserHomepageInfo('', '', '', 0);

        this._userHomepageService.getAllDonationCenters().subscribe(
            (data) => {
                this.centers = data;
                this.centersSearchResult = data;
                this.sortCenters();
            },
            (error) => (this.errorMsg = "Couldn't load centers")
        );

        let role = localStorage.getItem('Role');
        if (role == Role.User)
            this._userHomepageService.getUserInfo().subscribe(
                (data) => {
                    this.userInfo = data;
                    this.loadUserFailed = false;
                },
                (error) => (this.loadUserFailed = true)
            );
        else this.loadUserFailed = true;
    }

    searchFilterAndSort() {
        this.centersSearchResult = [...this.centers];
        this.searchCenters();
        this.filterCenters();
        this.sortCenters();
    }

    searchCenters() {
        if (this.searchField.trim() !== '') {
            this.centersSearchResult = this.centersSearchResult.filter(
                (center) =>
                    center.name.toLowerCase().includes(this.searchField.toLowerCase()) ||
                    center.city.toLowerCase().includes(this.searchField.toLowerCase()) ||
                    center.address.toLowerCase().includes(this.searchField.toLowerCase())
            );
        }
    }

    filterCenters() {
        if (this.selectedFilterOption !== '-1') {
            this.centersSearchResult = this.centersSearchResult.filter(
                (center) => center.rating > Number(this.selectedFilterOption)
            );
        }
    }

    sortCenters(): void {
        switch (this.selectedSortOption) {
            case 'name':
                this.centersSearchResult.sort((a, b) => a.name.localeCompare(b.name));
                break;
            case 'rating':
                this.centersSearchResult.sort((a, b) => b.rating - a.rating);
                break;
            case 'city':
                this.centersSearchResult.sort((a, b) => a.city.localeCompare(b.city));
                break;
            default:
                break;
        }
    }

    newAppointment() {
        this.router.navigate(['user-make-appointment']);
    }

    openCenter(id: number): void {
        this.router.navigate(['user-donation-center/' + id]);
    }
}
