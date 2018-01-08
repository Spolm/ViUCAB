import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { RestApiService } from '../../app/rest-api.service';
/**
 * Generated class for the ConfiguracionContenidoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-configuracion-contenido',
  templateUrl: 'configuracion-contenido.html',
})
export class ConfiguracionContenidoPage {
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


    reggae ={id:1,tipo:'filtro-simple',descripcion:'reggeton',valor:this.contenidoReggaeton};
    terrorismo ={id:2,tipo:'filtro-simple',descripcion:'terrorismo',valor:this.contenidoTerrorismo};
    terror ={id:3,tipo:'filtro-simple',descripcion:'terror',valor:this.contenidoTerror};
    sexo ={id:4,tipo:'filtro-simple',descripcion:'sexo',valor:this.contenidoSexo};
    porno ={id:5,tipo:'filtro-simple',descripcion:'porno',valor:this.contenidoPornografico};
    sangriento ={id:6,tipo:'filtro-simple',descripcion:'sangriento',valor:this.contenidoSangriento};
    discriminacion ={id:10,tipo:'filtro-simple',descripcion:'descriminacion',valor:this.discrimina};
    religion ={id:11,tipo:'filtro-simple',descripcion:'religion',valor:this.religio};
    politica ={id:12,tipo:'filtro-simple',descripcion:'politica',valor:this.politicab};

    parental ={id:7,tipo:'estructura',descripcion:'control - parental',valor:this.controlParental};
    perfil ={id:9,tipo:'estructura',descripcion:'perfil adulto',valor:this.perfilAdulto};
    infantil ={id:13,tipo:'estructura',descripcion:'perfil infantil',valor:this.infa};

    violenciaa ={id:8,tipo:'filtro-simple',descripcion:'Violencia',valor:this.violencia};
    maquillaje={id:13,tipo:'filtro-simple',descripcion:'maquillaje',valor:this.maqui};

    filtros =[];

  constructor(public navCtrl: NavController, public navParams: NavParams, public servicio: RestApiService) {
  }


  public guardarConfiguracion() {
     // this.guardarConfig();
      //console.log("Se ejecutó Guardar Configuración... ");
    this.filtros= [this.reggae,this.terrorismo,this.terror,this.sexo,this.porno,this.sangriento,this.parental,this.violenciaa,this.perfil,
    this.discriminacion,this.maquillaje,this.politica,this.religion,this.infantil];
    console.log(this.filtros);
    this.guardarConfig();
  }

   guardarConfig() {
      console.log("llamando al wss");

      this.servicio.m12prueba().then((result) => {
       console.log(result);
     }, (err) =>{
       console.log(err);
     });

    }



}
