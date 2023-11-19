import { Component, OnInit } from '@angular/core';
import {TranslationService} from "../../services/translation.service";
import {ChatGptService} from "../../services/chat-gpt.service";

@Component({
  selector: 'app-medical-assistance',
  templateUrl: './medical-assistance.page.html',
  styleUrls: ['./medical-assistance.page.scss'],
})
export class MedicalAssistancePage {
  completion!:string;
  prompt!:string
  data:any=[]
  loading=false
  constructor(private translation:TranslationService,private gpt:ChatGptService) { }

    call(){
    this.loading=true
   this.translate("en",this.prompt)
      this.data.push({'type':'question','text':this.prompt})
      this.prompt=""

  }
  translate(lang:string,text:string){
    this.translation.translate(text,lang).subscribe((x:any)=>{
     const response= x.data.translations[0].translatedText
      this.getChatCompletion(response)
    })
  }
  async getChatCompletion(prompt:string) {
    try {
      const response = await this.gpt.getChatCompletion(prompt);
      this.completion = response.choices[0]?.message?.content || 'No response';
      this.translate2("az",this.completion)
    } catch (error) {
      this.completion = 'Error getting response';
    }

  }

  translate2(lang:string,text:string){
    this.translation.translate(text,lang).subscribe((x:any)=>{
      const response= x.data.translations[0].translatedText
      this.data.push({'type':'answer','text':response})
      this.loading=false
    })
  }
  handleClick(event: Event) {
    event.stopPropagation();
    // Rest of your click handler logic for the div
  }


}
