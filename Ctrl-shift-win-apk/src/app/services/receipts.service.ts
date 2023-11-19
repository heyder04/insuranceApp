import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EndpointsConstant} from "../constants/Endpoints";

@Injectable({
  providedIn: 'root'
})
export class ReceiptsService {

  constructor(private http:HttpClient) { }
  getPdf(){
    return this.http.get(EndpointsConstant.receipt)
  }
}
