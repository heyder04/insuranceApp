import { Component, OnInit } from '@angular/core';
import {NavController} from "@ionic/angular";

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.page.html',
  styleUrls: ['./contact-us.page.scss'],
})
export class ContactUsPage implements OnInit {

  constructor(private navctrl:NavController) { }

  ngOnInit() {
  }
suggest(){
    console.log('a')
    this.navctrl.navigateForward('profile/contact-us/suggestion')
}
searchExpert(){
  this.navctrl.navigateForward('profile/contact-us/accident')
}
}
