import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ConfiguracionNotificacionesPage } from '../configuracion-notificaciones/configuracion-notificaciones';
import { RestApiService } from '../../app/rest-api.service';

const URL = "Notificaciones/NotificacionesCorreo";

@IonicPage()

@Component({
  selector: 'page-notificaciones',
  templateUrl: 'notificaciones.html',
  providers: [RestApiService]
})
export class NotificacionesPage {

  public isToggled: boolean;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public api: RestApiService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad NotificacionesPage');

  }

  goToConfiguracionNotificaciones() {
    //this.navCtrl.push(ConfiguracionNotificacionesPage);
    //Prueba de servicio de correo
    var usuario = "2";
    var respuesta = this.api.getTodoParam(URL, usuario);
    if (respuesta) {
      console.log(respuesta);
    }
  }

}
