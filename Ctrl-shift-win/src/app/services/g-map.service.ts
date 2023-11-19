import { Injectable } from '@angular/core';
import {resolve} from "@angular/compiler-cli";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class GMapService {

  constructor() { }
  loadGoogleMaps():Promise<any>{
    const win=window as any;
    const gModule=win.google;
    if(gModule && gModule.maps){
      return Promise.resolve(gModule.maps)
    }
    return  new Promise((resolve,reject)=>{
      const script=document.createElement('script');
      script.src='https://maps.googleapis.com/maps/api/js?key='+environment.GOOGLE_MAP+
        '&libraries=places';
      script.async=true;
      script.defer=true;
      document.body.appendChild(script);
      script.onload=()=>{
        const loadGoogleModule=win.google;
        if(loadGoogleModule&&loadGoogleModule.maps){
          resolve(loadGoogleModule.maps)
        }else{
          reject("Google Map Sdk is not available")
        }
      }
    })
  }
}
