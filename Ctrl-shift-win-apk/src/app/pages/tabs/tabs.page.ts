import {Component, ViewChild} from '@angular/core';
import {IonTabs} from "@ionic/angular";

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})
export class TabsPage {
  selectedTab='home';
  @ViewChild('tabs',{static:true}) tabs!:IonTabs

  constructor() {}
  tabChanged(){
    this.selectedTab=this.tabs.getSelected()!;
  }

}
