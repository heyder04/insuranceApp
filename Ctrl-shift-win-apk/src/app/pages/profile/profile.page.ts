import { Component, OnInit } from '@angular/core';
import {NavController} from "@ionic/angular";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.page.html',
  styleUrls: ['./profile.page.scss'],
})
export class ProfilePage  {

  constructor(private navctrl:NavController) { }


  sendHelp(){
    this.navctrl.navigateForward('profile/contact-us')
  }
  sendMedical(){
    this.navctrl.navigateForward('profile/medical-assistance')
  }
  sendFaq(){
    this.navctrl.navigateForward('profile/faq')
  }
}
