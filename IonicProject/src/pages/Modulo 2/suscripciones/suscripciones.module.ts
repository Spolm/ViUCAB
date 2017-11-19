import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { SuscripcionesPage } from './suscripciones';

@NgModule({
  declarations: [
    SuscripcionesPage,
  ],
  imports: [
    IonicPageModule.forChild(SuscripcionesPage),
  ],
})
export class SuscripcionesPageModule {}
