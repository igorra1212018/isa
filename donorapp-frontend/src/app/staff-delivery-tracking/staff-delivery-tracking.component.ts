import {Component, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {Router} from "@angular/router";
import {WebSocketShareService} from "../services/web-socket-share.service";
import {SocketService} from "../services/socket.service";
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import {useGeographic} from 'ol/proj.js';
import { Feature } from 'ol';
import { Point } from 'ol/geom';
import { Vector as VectorLayer } from 'ol/layer';
import { Vector as VectorSource } from 'ol/source';
import { Style, Fill, Circle } from 'ol/style';
import { DeliveryTrackingService } from '../services/delivery-tracking.service';
import { DeliveryCoordinates } from '../delivery-coordinates';

@Component({
  selector: 'app-staff-delivery-tracking',
  templateUrl: './staff-delivery-tracking.component.html',
  styleUrls: ['../shared-style.css', './staff-delivery-tracking.component.css']
})
export class StaffDeliveryTrackingComponent implements OnInit {
  map: Map | null = null;
  userRole: any;
  displayValue: any;
  latitude!: number;
  longitude!: number;

  startLat: string = '45.24365';
  startLong: string = '19.83517';
  endLat: string = '45.25232';
  endLong: string = '19.82115';

  // Create a point feature
  point = new Feature({
    geometry: new Point([19.83517, 45.24365]) // Set the coordinates of the point
  });

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private websocketService: WebSocketShareService, private webSocketAPI: SocketService,
              private breakpointObserver: BreakpointObserver, private router: Router, private _deliveryTrackingService: DeliveryTrackingService) {
  }


  ngOnInit() {
    this.webSocketAPI._connect();
    this.onNewValueReceive();

    const view = new View({
      center: [19.83517, 45.24365],
      zoom: 18,
    });

    const layer = new TileLayer({
      source: new OSM(),
    });

    this.map = new Map({
      target: 'map',
      layers: [layer],
      view: view,
      interactions: [],
      controls: []
    });

    // Style the point feature
    const pointStyle = new Style({
      image: new Circle({
        radius: 6,
        fill: new Fill({
          color: 'red'
        })
      })
    });

    this.point.setStyle(pointStyle);

    // Create a vector layer and add the point feature to it
    const vectorLayer = new VectorLayer({
      source: new VectorSource({
        features: [this.point]
      })
    });

    // Add the vector layer to the map
    this.map.addLayer(vectorLayer);
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
      if (resp !== undefined){
        this.displayValue = resp

        let coordStr = resp.split(",");

        const latitude = Number(coordStr[0]);
        const longitude = Number(coordStr[1]);
        console.log(latitude + ", " + longitude);
        
        const view = new View({
          center: [latitude, longitude],
          zoom: 19,
        });

        const size = this.map?.getSize();
        this.map?.getView().setCenter([longitude, latitude]);
        this.point.getGeometry()?.setCoordinates([longitude, latitude]);
        console.log(this.map?.getView().getCenter());
      }
    });
  }

  sendCoordinates(): void {
    let coordinates = new DeliveryCoordinates(Number(this.startLat), Number(this.startLong), Number(this.endLat), Number(this.endLong));
    this._deliveryTrackingService.startDelivery(coordinates).subscribe(
      (response) => {
          //this.registrationCompleted = true;
          console.log(response);
      },
      (error) => {
          //this.responseMessage = error.error;
          console.log(error.error);
      });
  }

  isNumber(value?: string | number): boolean {
    return ((value != null) &&
            (value !== '') &&
            !isNaN(Number(value.toString())));
  }

  contentIsValid(): boolean {
    if (!this.isNumber(this.startLat))
      return false;
    if (!this.isNumber(this.startLong))
      return false;
    if (!this.isNumber(this.endLat))
      return false;
    if (!this.isNumber(this.endLong))
      return false;
    return true;
  }

}
