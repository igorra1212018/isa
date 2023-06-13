import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './interceptor';
import { AuthGuard } from './auth.guard';
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { UserUpcomingAppointmentsComponent } from './user-upcoming-appointments/user-upcoming-appointments.component';
import { UserQuestionnaireComponent } from './user-questionnaire/user-questionnaire.component';
import { UserDonationCenterComponent } from './user-donation-center/user-donation-center.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserQrCodesComponent } from './user-qr-codes/user-qr-codes.component';
import { UserAppointmentHistoryComponent } from './user-appointment-history/user-appointment-history.component';
import { StaffProfileComponent } from './staff-profile/staff-profile.component';
import { StaffDonationCenterComponent } from './staff-donation-center/staff-donation-center.component';
import { StaffHomepageComponent } from './staff-homepage/staff-homepage.component';
import { AdminDonationCenterComponent } from './admin-donation-center/admin-donation-center.component';
import { StaffEditDonationCenterComponent } from './staff-edit-donation-center/staff-edit-donation-center.component';
import { StaffBloodViewComponent } from './staff-blood-view/staff-blood-view.component';
import { MatTableModule } from '@angular/material/table';
import { HomeComponent } from './home/home.component';
import { UserFileComplaintComponent } from './user-file-complaint/user-file-complaint.component';
import { UserComplaintsComponent } from './user-complaints/user-complaints.component'  
import { AdminRegisterStaffComponent } from './admin-register-staff/admin-register-staff.component'  ;
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatSelectModule} from '@angular/material/select';
import { AdminRepliedComplaintsComponent } from './admin-replied-complaints/admin-replied-complaints.component';
import { AdminNonrepliedComplaintsComponent } from './admin-nonreplied-complaints/admin-nonreplied-complaints.component';
import { StaffDefineTermComponent } from './staff-define-term/staff-define-term.component';
import { StaffProcessedReservationsComponent } from './staff-processed-reservations/staff-processed-reservations.component';
import { MatSortModule } from '@angular/material/sort';

import { StarRatingComponent } from './star-rating/star-rating.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatIconModule } from '@angular/material/icon';
import { WebSocketShareService } from "./services/web-socket-share.service";
import { StaffDeliveryTrackingComponent } from './staff-delivery-tracking/staff-delivery-tracking.component';
import { UserMakeAppointmentComponent } from './user-make-appointment/user-make-appointment.component';
import { UserListComponent } from './user-list/user-list.component';
import { StaffWorkCalendarComponent } from './staff-work-calendar/staff-work-calendar.component';
import { StaffStartAppointmentComponent } from './staff-start-appointment/staff-start-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    UserHomepageComponent,
    UserUpcomingAppointmentsComponent,
    UserQuestionnaireComponent,
    UserDonationCenterComponent,
    UserProfileComponent,
    NavbarComponent,
    UserQrCodesComponent,
    UserAppointmentHistoryComponent,
    StaffProfileComponent,
    StaffDonationCenterComponent,
    StaffHomepageComponent,
    AdminDonationCenterComponent,
    StaffEditDonationCenterComponent,
    StaffBloodViewComponent,
    HomeComponent,
    UserFileComplaintComponent,
    UserComplaintsComponent,
    AdminRegisterStaffComponent,
    AdminRepliedComplaintsComponent,
    AdminNonrepliedComplaintsComponent,
    StaffDefineTermComponent,
    StaffProcessedReservationsComponent,
    StarRatingComponent,
    StaffDeliveryTrackingComponent,
    UserMakeAppointmentComponent,
    UserListComponent,
    StaffWorkCalendarComponent,
    StaffWorkCalendarComponent,
    StaffStartAppointmentComponent,
    StaffStartAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    CommonModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSortModule,
    MatSnackBarModule,
    MatIconModule,
    MatSelectModule
  ],
  providers: [
    AuthGuard,
    {provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    WebSocketShareService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }