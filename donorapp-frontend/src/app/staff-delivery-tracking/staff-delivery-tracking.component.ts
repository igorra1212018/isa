import {Component, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {Router} from "@angular/router";
import {WebSocketShareService} from "../services/web-socket-share.service";
import {SocketService} from "../services/socket.service";

@Component({
  selector: 'app-staff-delivery-tracking',
  templateUrl: './staff-delivery-tracking.component.html',
  styleUrls: ['./staff-delivery-tracking.component.css']
})
export class StaffDeliveryTrackingComponent implements OnInit {

  userRole: any;
  displayValue: any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private websocketService: WebSocketShareService, private webSocketAPI: SocketService,
              private breakpointObserver: BreakpointObserver, private router: Router) {
  }


  ngOnInit() {
    this.webSocketAPI._connect();
    this.onNewValueReceive();
  }

  ngOnDestroy() {
    this.disconnect()
  }


  connect() {
    this.webSocketAPI._connect();
  }

  disconnect() {
    this.webSocketAPI._disconnect();
  }

  // method to receive the updated data.
  onNewValueReceive() {
    this.websocketService.getNewValue().subscribe(resp => {
      if (resp !== undefined) this.displayValue = resp
    });
  }

}
