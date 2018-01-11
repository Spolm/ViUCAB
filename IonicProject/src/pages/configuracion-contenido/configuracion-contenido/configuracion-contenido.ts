import { Component } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ServicioProvider } from '../../../providers/servicio/servicio';

/**
 * Generated class for the ConfigContenidoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-config-contenido',
  templateUrl: 'config-contenido.html',
})
export class ConfigContenidoPage {

  filtrosIndividuales: boolean=false;
  estructurasFiltros: boolean = false;
  contenidoReggaeton: boolean = false;
  contenidoTerrorismo: boolean =false;
  contenidoTerror: boolean = false;
  contenidoSexo: boolean = false;
  contenidoPornografico: boolean = false;
  contenidoSangriento: boolean = false;
  controlParental: boolean=false;
  violencia: boolean = false;
  perfilAdulto: boolean=false;
  variable:boolean=false;
  discrimina:boolean=false;
  religio:boolean=false;
  politicab:boolean=false;
  maqui:boolean=false;
  infa:boolean=false;

  reggae ={id:1,tipo:"filtro-simple",descripcion:"Contenido Musical - Reggaeton",valor:this.contenidoReggaeton};
  terrorismo ={id:2,tipo:"filtro-simple",descripcion:"Contenido Terrorismo",valor:this.contenidoTerrorismo};
  terror ={id:3,tipo:"filtro-simple",descripcion:"Contenido Terror",valor:this.contenidoTerror};
  sexo ={id:4,tipo:"filtro-simple",descripcion:"Contenido Sexo",valor:this.contenidoSexo};
  porno ={id:5,tipo:"filtro-simple",descripcion:"Contenido Pornografico",valor:this.contenidoPornografico};
  sangriento ={id:6,tipo:"filtro-simple",descripcion:"Contenido Sangriento",valor:this.contenidoSangriento};

  parental ={id:7,tipo:"estructura",descripcion:"Control Parental",valor:this.controlParental};
  violenciaa ={id:8,tipo:"filtro-simple",descripcion:"Violencia",valor:this.violencia};

  perfil ={id:9,tipo:"estructura",descripcion:"Perfil",valor:this.perfilAdulto};
  discriminacion ={id:10,tipo:"filtro-simple",descripcion:"discriminacion",valor:this.discrimina};



  politica ={id:11,tipo:"filtro-simple",descripcion:"politica",valor:this.politicab};
  infantil ={id:12,tipo:"estructura",descripcion:"perfil infantil",valor:this.infa};
  maquillaje={id:13,tipo:"filtro-simple",descripcion:"maquillaje",valor:this.maqui};

    filtros =[];


    constructor(public navCtrl: NavController, public navParams: NavParams,public http: Http, public servicio:ServicioProvider) {

    }




    public guardarConfiguracion() {
     // this.guardarConfig();
      //console.log("Se ejecutó Guardar Configuración... ");
    this.filtros= [this.reggae,this.terrorismo,this.terror,this.sexo,this.porno,this.sangriento,this.parental,this.violenciaa,this.perfil,
    this.discriminacion,this.maquillaje,this.politica,this.infantil];
    console.log(this.filtros);
    this.guardarConfig();
    }

    guardarConfig() {
        this.servicio.postRequest(this.filtros).then((result) => {
          console.log(result);
        }, (err) =>{
          console.log(err);
        });
    }

  }



