import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { PersonelListesiComponent } from './personel-listesi/personel-listesi.component';

const routes: Routes = [
  {
    path: 'menu', component: MenuComponent
  },
  {
    path: 'personel-listesi', component: PersonelListesiComponent
  },
  {
    path: '', pathMatch: 'full', redirectTo: 'menu'
  },
//  {
//    path: '*', component: HataComponent
//  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
