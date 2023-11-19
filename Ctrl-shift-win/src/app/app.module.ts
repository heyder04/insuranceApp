import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {SuggestionService} from "./services/suggestion.service";
import {HttpClientModule} from "@angular/common/http";
import {PdfViewerModule} from "ng2-pdf-viewer";

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot({backButtonText: ''}), AppRoutingModule,HttpClientModule,PdfViewerModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy },SuggestionService],
  bootstrap: [AppComponent],
})
export class AppModule {}
