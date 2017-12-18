import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ConfiguracionNotificacionesPage } from '../configuracion-notificaciones/configuracion-notificaciones';
import { RestApiService } from '../../app/rest-api.service';

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

  goToConfiguracionNotificaciones(){
    this.navCtrl.push(ConfiguracionNotificacionesPage);
  }

}
