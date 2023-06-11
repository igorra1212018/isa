import * as SockJS from 'sockjs-client';
import {Injectable} from '@angular/core';
import {WebSocketShareService} from "./web-socket-share.service";
// @ts-ignore
import * as Stomp from 'stompjs'

@Injectable({
  providedIn: 'root'
})
export class SocketService {
  set topic(value: string) {
    this._topic = value;
  }

  webSocketEndPoint: string = 'http://localhost:8081/ws';
  private _topic: string = "/topic/location";
  stompClient: any;
  websocketShare: WebSocketShareService


  constructor(
    //private toastr: ToastrService,
    //private <pa sl linija>
    websocketShare: WebSocketShareService) {
      this.websocketShare = websocketShare;
  }

  _connect() {
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(this.webSocketEndPoint);
    const _this = this;
    let token = localStorage.getItem("AccessToken");
    if(token){
      console.log(token);
    
      this.stompClient = Stomp.over(ws);
      _this.stompClient.connect({ 'X-Authorization': "Bearer " + token }, () => {
        _this.stompClient.subscribe(this._topic, (sdkEvent: any) => {
          _this.onMessageReceived(sdkEvent);
        }, { 'X-Authorization': "Bearer " + token });
        //_this.stompClient.reconnect_delay = 2000;
      }, this.errorCallBack);
    }
  };

  _disconnect() {
    if (this.stompClient !== null) {
      let token = localStorage.getItem("AccessToken");
      if (token){
        console.log(token);
        this.stompClient.disconnect(() => {}, { 'X-Authorization': "Bearer " + token });
      }
    }
    console.log("Disconnected");
  }

  // on error, schedule a reconnection attempt
  // @ts-ignore
  errorCallBack(error) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
      this._connect();
    }, 5000);
  }

  // @ts-ignore
  onMessageReceived(message) {
    //this.toastr.success(message.body);
    this.websocketShare.onNewValueReceive(message.body);
  }

}
