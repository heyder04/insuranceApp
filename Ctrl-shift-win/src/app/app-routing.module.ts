import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./pages/tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'channels',
    loadChildren: () => import('./pages/profile/profile.module').then( m => m.ProfilePageModule)
  },
  {
    path: 'profile/contact-us',
    loadChildren: () => import('./pages/contact-us/contact-us.module').then(m => m.HelpPageModule)
  },
  {
    path: 'profile/contact-us/suggestion',
    loadChildren: () => import('./pages/suggestion/suggestion.module').then( m => m.SuggestionPageModule)
  },
  {
    path: 'profile/medical-assistance',
    loadChildren: () => import('./pages/medical-assistance/medical-assistance.module').then( m => m.MedicalAssistancePageModule)
  },
  {
    path: 'profile/contact-us/accident',
    loadChildren: () => import('./pages/accident/accident.module').then( m => m.AccidentPageModule)
  },
  {
    path: 'receipt',
    loadChildren: () => import('./pages/receipt/receipt.module').then( m => m.ReceiptPageModule)
  },
  {
    path: 'profile/faq',
    loadChildren: () => import('./pages/faq/faq.module').then( m => m.FaqPageModule)
  },

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
