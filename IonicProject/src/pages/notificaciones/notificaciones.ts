import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ConfiguracionNotificacionesPage } from '../configuracion-notificaciones/configuracion-notificaciones';
import { RestApiService } from '../../app/rest-api.service';
import { last } from 'rxjs/operator/last';

@IonicPage()
@Component({
  selector: 'page-notificaciones',
  templateUrl: 'notificaciones.html',
  providers: [RestApiService]
})
export class NotificacionesPage {

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams,
    public api : RestApiService){
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad NotificacionesPage');
  }

  // goToConfiguracionNotificacion(params){
  //   if (!params) params = {};
  //   this.navCtrl.push(ConfiguracionNotificacionesPage);
  // }

  goToConfiguracionNotificaciones(params){
    console.log('entro aqui');
    var data=(this.api.getTodo('holamundo'));
    console.log(data);
  }

}
