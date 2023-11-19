import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path:'',
    redirectTo:'/tabs/home',
    pathMatch:'full'
  },
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'home',
        loadChildren:()=>import('../home/home.module').then(m=>m.HomePageModule)
      },
      {
        path: 'profile',
        loadChildren:()=>import('../profile/profile.module').then(m=>m.ProfilePageModule)
      },
      {
        path: 'receipt',
        loadChildren:()=>import('../receipt/receipt.module').then(m=>m.ReceiptPageModule)
      }


    ]
  },
  {
    path: '',
    redirectTo: '/tabs',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule {}
