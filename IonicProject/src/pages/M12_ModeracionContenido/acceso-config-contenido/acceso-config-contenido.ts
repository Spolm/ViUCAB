import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ServicioProvider } from '../../../providers/servicio/servicio';

/**
 * Generated class for the AccesoConfigContenidoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-acceso-config-contenido',
  templateUrl: 'acceso-config-contenido.html',
  
})
export class AccesoConfigContenidoPage {
  private id: number =1;
  private password: string;
  constructor(public navCtrl: NavController, public navParams: NavParams,public s: ServicioProvider) {
    
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AccesoConfigContenidoPage');
    
  }

  continuar(){
    console.log('Contraseña: '+this.password);
    /*this.s.getData();*/
    this.navCtrl.push('ConfigContenidoPage');
  }
}
