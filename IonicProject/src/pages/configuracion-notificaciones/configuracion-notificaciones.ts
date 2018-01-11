import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Toast } from '@ionic-native/toast';
import { RestApiService } from '../../app/rest-api.service';

const URL = 'Notificaciones/configuracion';

@IonicPage()
@Component({
  selector: 'page-configuracion-notificaciones',
  templateUrl: 'configuracion-notificaciones.html',
  providers: [RestApiService],
})

export class ConfiguracionNotificacionesPage {

  private configuracion: {
    id: number,
    notificaciones: boolean,
    boletin: boolean,
    recomendados: boolean,
    etiquetados: boolean,
    subscripciones: boolean,
    estadisticas: boolean,
  };
  private toast: Toast;
  private response: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public restApi: RestApiService) {
    this.configuracion = {
      id: 0,
      notificaciones: true,
      boletin: true,
      recomendados: true,
      etiquetados: true,
      subscripciones: true,
      estadisticas: true,
    };
    this.restApi.getTodo(URL).subscribe( (data) => {
      this.response = data[0];
      this.configuracion = {
        id: this.response.id,
        notificaciones: this.response.activado,
        boletin: this.response.boletin,
        recomendados: this.response.preferencias,
        etiquetados: this.response.etiquetados,
        subscripciones: this.response.subscripciones,
        estadisticas: this.response.estadisticas,
      };
    });
  }

  public enableToggle(condition) {
     this.configuracion.recomendados = condition;
     this.configuracion.etiquetados = condition;
     this.configuracion.subscripciones = condition;
     this.configuracion.estadisticas = condition;
  }

  public cambiarNotificaciones() {
    this.configuracion.notificaciones = ! this.configuracion.notificaciones;
    this.enableToggle( this.configuracion.notificaciones);
  }

  public guardar() {
    this.restApi.postUno(URL, 1, JSON.stringify(this.configuracion), 1).subscribe( (data) => {
      this.response = data;
      console.log(this.response);
      },
    );
  // this.toast.show(`Guardado con Exito`, '5000', 'bottom').subscribe(
  //   (toast) => {
  //    console.log(toast);
  //    },
  //  );
  }

}
