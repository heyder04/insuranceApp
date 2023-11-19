import { Component, OnInit } from '@angular/core';
import {SuggestionService} from "../../services/suggestion.service";

@Component({
  selector: 'app-suggestion',
  templateUrl: './suggestion.page.html',
  styleUrls: ['./suggestion.page.scss'],
})
export class SuggestionPage {
 type:number=0
  isAlertOpen=false
  suggestion!:string
  constructor(private suggestionService:SuggestionService) { }

  submit(){
   this.suggestionService.sendSuggestion(this.type,this.suggestion).subscribe((x:any)=>{
   if(x){
   this.isAlertOpen=true
     setTimeout(()=>this.isAlertOpen=false,2000)
   }
   })
  }


}
