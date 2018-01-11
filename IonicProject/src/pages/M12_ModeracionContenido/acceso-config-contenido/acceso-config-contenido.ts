import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';
import {Http} from "@angular/http";

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
  constructor(public navCtrl: NavController, public navParams: NavParams,public s: RestApiService,public http: Http) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AccesoConfigContenidoPage');

  }

  continuar(){
    console.log('Contraseña: '+this.password);
    /*this.s.getData();*/
    //this.navCtrl.push('ConfigContenidoPage');

    return new Promise ((resolve, reject) => {

      //this.http.post("http://localhost:8080/WS_mejorado_war_exploded//guardarFiltrosDeUsuario", postParams, options)
      this.http.get("http://localhost:8080/viucab/ModeracionContenido/validarAcceso?id=1&claveApp="+this.password)
        .subscribe(data => {
          if(data["_body"]==="true"){
            this.navCtrl.push('ConfigContenidoPage');
          }else{
            alert("Clave Invalida");
          }
        }, error => {
          console.log(error);// Error getting the data
        });
    });
  }
}
