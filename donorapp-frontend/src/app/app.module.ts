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
import { StaffProfileComponent } from './staff-profile/staff-profile.component';
import { StaffDonationCenterComponent } from './staff-donation-center/staff-donation-center.component';
import { StaffHomepageComponent } from './staff-homepage/staff-homepage.component';
import { AdminDonationCenterComponent } from './admin-donation-center/admin-donation-center.component';

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
    StaffProfileComponent,
    StaffDonationCenterComponent,
    StaffHomepageComponent,
    AdminDonationCenterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    CommonModule,
  ],
  providers: [
    AuthGuard,
    {provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }