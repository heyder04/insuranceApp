import { Component, OnInit } from '@angular/core';
import {ReceiptsService} from "../../services/receipts.service";

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.page.html',
  styleUrls: ['./receipt.page.scss'],
})
export class ReceiptPage implements OnInit {
  show=false
  pdfSrc:string=''
  receipt:any
  constructor(private receipts:ReceiptsService) { }

  ngOnInit() {
    this.receipts.getPdf().subscribe((x:any)=>{
      this.receipt=x
    })
  }
  openPdf(x:string){
    this.show=true
    this.pdfSrc=x
  }
  close(){
    this.show=false
  }

}
