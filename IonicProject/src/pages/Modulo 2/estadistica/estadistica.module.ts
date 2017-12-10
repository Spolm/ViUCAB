import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EstadisticaPage } from './estadistica';
import { Chart } from 'chart.js';

@NgModule({
  declarations: [
    EstadisticaPage,
  ],
  imports: [
    IonicPageModule.forChild(EstadisticaPage),
  ],
})
export class EstadisticaPageModule {}
