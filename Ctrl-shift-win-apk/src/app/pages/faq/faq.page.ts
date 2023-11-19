import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.page.html',
  styleUrls: ['./faq.page.scss'],
})
export class FaqPage implements OnInit {
 faq=[{question:"What types of insurance do I need?",answer:"The types of insurance you need depend on your individual circumstances. Common types include health insurance for medical expenses, auto insurance for vehicle coverage, homeowners or renters insurance for property protection, life insurance for financial security, and liability insurance for legal protection."},
   {
     question:  'How is insurance premium calculated?',answer: 'Insurance premiums are determined based on various factors such as age, health status, driving record, coverage amount, and the type of insurance. Insurers use statistical models to assess risk and calculate a premium that reflects the likelihood of a claim.'},
   {question: ' What is a deductible?',answer: 'A deductible is the amount you must pay out of pocket before your insurance coverage kicks in. For example, if you have a $500 deductible on auto insurance and incur $1,000 in damages, you pay the first $500, and the insurance covers the remaining $500.'},{
   question: 'How does a claims process work?',answer: 'To file a claim, contact your insurance provider promptly after an incident. Provide necessary details and documentation. The insurer assesses the claim, determines coverage, and processes payment. It\'s crucial to follow the claims process outlined by your specific insurance company.'},{
   question: 'Is it necessary to review and update insurance policies regularly?',answer: ' Yes, it\'s essential to review and update insurance policies regularly. Life changes, such as marriage, having children, or buying a new home, can impact your insurance needs. Regular reviews help ensure that your coverage aligns with your current circumstances and provides adequate protection.'
   }]
  constructor() { }

  ngOnInit() {
  }

}
