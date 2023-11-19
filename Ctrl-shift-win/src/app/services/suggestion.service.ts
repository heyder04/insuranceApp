import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EndpointsConstant} from "../constants/Endpoints";

@Injectable({
  providedIn: 'root'
})
export class SuggestionService {

  constructor(private http:HttpClient) { }
  sendSuggestion(type:number ,text2:string){
    const body={
      "rating":type,
      "text":text2
    }
    return this.http.post(EndpointsConstant.suggestions,body)
  }
}
