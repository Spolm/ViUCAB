import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ConfiguracionNotificacionesPage } from './configuracion-notificaciones';

@NgModule({
  declarations: [
    ConfiguracionNotificacionesPage,
  ],
  imports: [
    IonicPageModule.forChild(ConfiguracionNotificacionesPage),
  ],
})
export class ConfiguracionNotificacionesPageModule {}
