import {AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';
import { Geolocation } from '@capacitor/geolocation';
import {GMapService} from "../../services/g-map.service";
@Component({
  selector: 'app-accident',
  templateUrl: './accident.page.html',
  styleUrls: ['./accident.page.scss'],
})
export class AccidentPage implements OnInit,AfterViewInit {
googleMaps:any
  map:any
  des:any={lat:40.337812,lng:49.733847}
  loading=false
  step:number=1
  directionService:any
  directionDisplay:any
  cordinates:any
  constructor(private gmap:GMapService,private renderer:Renderer2) { }
@ViewChild('map',{static:true}) mapElementRef!:ElementRef;
  ngOnInit() {
  }
  ngAfterViewInit() {

  }

  search1(){
    this.loading=true
    setTimeout(()=>{
      this.loading=false
      this.step=2
      this.search()
    },5000)
    console.log('a')
  }
  async  search(){
      const coordinates = await Geolocation.getCurrentPosition(
        {
          enableHighAccuracy: true,
          timeout: 5000, // 5 seconds timeout
          maximumAge: 0, // Force the device to get a new location
        }
      );
    this.cordinates={'lat':coordinates.coords.latitude,"lng":coordinates.coords.longitude}
      console.log('Current position:', coordinates.coords.latitude,coordinates.coords.longitude);
  try{
    let googleMaps:any=await this.gmap.loadGoogleMaps();
    this.googleMaps=googleMaps
    const mapEl=this.mapElementRef.nativeElement;
    const location=new googleMaps.LatLng(this.cordinates.lat,this.cordinates.lng)
     this.map=new googleMaps.Map(mapEl,{
       center:location,
       zoom:10,
     })
    const dest=new googleMaps.LatLng(this.des)
    // this.directionService=new googleMaps.DirectionService;
    // this.directionDisplay=new googleMaps.DirectionRenderer;
    // this.directionDisplay=new googleMaps.DirectionRenderer();
    this.renderer.addClass(mapEl,'visible');
    this.addMarker(location,'black')
    this.addMarker(dest,'red')
  }catch (e){
    console.log(e)
  }
    };

  addMarker(location:string,color:string){
    let googleMaps:any=this.googleMaps;
    if (!googleMaps) {
      console.error('Google Maps is not initialized.');
      return;
    }

    if(color=='red'){
      const icon={
        url:'assets/icon/expert2.png',
        scaledSize:new googleMaps.Size(50,50),
      }
      const marker=new googleMaps.Marker({
        position:location,
        map:this.map,
        icon:icon,
        animation:googleMaps.Animation.DROP
      })
    }else{
      const icon={
        url:'assets/icon/black-marker.png',
        scaledSize:new googleMaps.Size(50,50),
      }
      const marker=new googleMaps.Marker({
        position:location,
        map:this.map,
        icon:icon,
        animation:googleMaps.Animation.DROP
      })
    }



  }



}
