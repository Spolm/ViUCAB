import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CargarVideoPage } from './cargar-video';

@NgModule({
  declarations: [
    CargarVideoPage,
  ],
  imports: [
    IonicPageModule.forChild(CargarVideoPage),
  ],
})
export class CargarVideoPageModule {}
