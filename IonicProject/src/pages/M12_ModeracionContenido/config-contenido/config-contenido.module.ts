import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ConfigContenidoPage } from './config-contenido';

@NgModule({
  declarations: [
    ConfigContenidoPage,
  ],
  imports: [
    IonicPageModule.forChild(ConfigContenidoPage),
  ],
})
export class ConfigContenidoPageModule {}
