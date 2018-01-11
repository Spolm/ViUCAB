import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AccesoConfigContenidoPage } from './acceso-config-contenido';
//import { ServicioPeticionesProvider } from '../../../../providers/servicio-peticiones/servicio-peticiones';

@NgModule({
  declarations: [
    AccesoConfigContenidoPage, 
  ],
  imports: [
    IonicPageModule.forChild(AccesoConfigContenidoPage),
  ],
  providers: [
    //ServicioPeticionesProvider
  ]
})
export class AccesoConfigContenidoPageModule {}
