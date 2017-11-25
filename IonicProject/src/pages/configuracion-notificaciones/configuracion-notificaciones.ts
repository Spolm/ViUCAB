import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-configuracion-notificaciones',
  templateUrl: 'configuracion-notificaciones.html',
})
export class ConfiguracionNotificacionesPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ConfiguracionNotificacionesPage');
  }

}
