import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TendenciasPage } from './tendencias';

@NgModule({
  declarations: [
    TendenciasPage,
  ],
  imports: [
    IonicPageModule.forChild(TendenciasPage),
  ],
})
export class TendenciasPageModule {}
