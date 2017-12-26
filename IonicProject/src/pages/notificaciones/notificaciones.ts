import { Component } from '@angular/core';
import { IonicPage, NavController, Nav, NavParams } from 'ionic-angular';
import { Toast } from '@ionic-native/toast';
import { ConfiguracionNotificacionesPage } from '../configuracion-notificaciones/configuracion-notificaciones';
import { RestApiService } from '../../app/rest-api.service';
import { CanalPage } from'../Modulo 2/canal/canal';
const URL = 'Notificaciones/notificacion';
@IonicPage()

@Component({
  selector: 'page-notificaciones',
  templateUrl: 'notificaciones.html',
  providers: [RestApiService],
})

export class NotificacionesPage {

  private notificacion: {
    id: number,
    fecha: Date,
    desechado: boolean ,
    video: {
      id: number,
      nombre: string,
      url: string,
      imagen:string,
      descripcion: string  
    },
    usuario: {
      _name_user: string
    }
    };
  private notificacionList = Array<{
    id: number,
    fecha: Date,
    desechado: boolean ,
    video: {
      id: number,
      nombre:string,
      url: string,
      imagen: string,
      descripcion: string
    },
    usuario: {
      _name_user: string
    }
     }>();
  private toast: Toast;
  private response: any;
  constructor(public navCtrl: NavController, public navParams: NavParams, public restApi: RestApiService) {
    this.notificacion = {
      id: 0,
      fecha: null,
      desechado: false,
      video: {
        id: 0,
        nombre: '',
        url: '',
        imagen: '',
        descripcion: ''
      },
      usuario: {
        _name_user: ''
      }
    };
    
    this.notificacionList.push(this.notificacion);
    this.restApi.getTodo(URL).subscribe( (data) => {
      this.notificacionList = data;
      console.log(this.notificacionList);
    });
  }
  
  goToConfiguracionNotificaciones(){
    this.navCtrl.push(ConfiguracionNotificacionesPage);
  }
public goToVideo() {
    this.navCtrl.push(CanalPage);
}

}
