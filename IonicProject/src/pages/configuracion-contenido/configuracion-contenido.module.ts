import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ConfiguracionContenidoPage } from './configuracion-contenido';

@NgModule({
  declarations: [
    ConfiguracionContenidoPage,
  ],
  imports: [
    IonicPageModule.forChild(ConfiguracionContenidoPage),
  ],
})
export class ConfiguracionContenidoPageModule {}
