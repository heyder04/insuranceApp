import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ReceiptPageRoutingModule } from './receipt-routing.module';

import { ReceiptPage } from './receipt.page';
import {PdfViewerModule} from "ng2-pdf-viewer";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        ReceiptPageRoutingModule,
        PdfViewerModule
    ],
  declarations: [ReceiptPage]
})
export class ReceiptPageModule {}
