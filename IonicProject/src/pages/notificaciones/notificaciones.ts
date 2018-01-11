import { Component } from '@angular/core';
import { IonicPage, NavController, Nav, NavParams } from 'ionic-angular';
import { Toast } from '@ionic-native/toast';
import { ConfiguracionNotificacionesPage } from '../configuracion-notificaciones/configuracion-notificaciones';
import { RestApiService } from '../../app/rest-api.service';
import { CanalPage } from '../Modulo 2/canal/canal';
import { Notificacion } from '../../model/notificacionModel';

const URL = 'Notificaciones/notificacion';
const URLdes = 'Notificaciones/notificacionDes';

@IonicPage()

@Component({
  selector: 'page-notificaciones',
  templateUrl: 'notificaciones.html',
  providers: [RestApiService],
})

export class NotificacionesPage {

  private notificacionList = Array<Notificacion>();
  private toast: Toast;
  private response: any;
  private vacio: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restApi: RestApiService) {
    this.vacio = true;
    this.restApi.getTodo(URL).subscribe((data) => {
      this.notificacionList = data;
      if (this.notificacionList.length > 0) {
        this.vacio = false;
      }
    });
  }

  public goToConfiguracionNotificaciones() {
    this.navCtrl.push(ConfiguracionNotificacionesPage);
  }

  public goToVideo(n: Notificacion) {
    // console.log(n);
    // this.restApi.getUno(URLdes, n.id).subscribe((data) => {
    //  console.log(n.id);
    //  console.log(data);
    // });
    this.navCtrl.push(CanalPage);
  }

}
