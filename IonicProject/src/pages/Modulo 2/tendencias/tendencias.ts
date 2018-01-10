import { Component, } from '@angular/core';
import { IonicPage, NavController, NavParams,  AlertController} from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';
import { Subscription } from 'rxjs/Subscription';

/**
 * Generated class for the TendenciasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-tendencias',
  templateUrl: 'tendencias.html',
  providers: [RestApiService]
})
export class TendenciasPage {
  data = [{                       //DATA DE PRUEBA LOCAL
      id: 1,
      nombre: 'Kryptonite: Superman odia esto',
      usuario: 'Barbara Fernández',
      fecha: 'Noviembre 5, 2017',
      imagen: 'assets/imgs/kryptonite.png',
      visitas: 8
  }, {
      id: 2,
      nombre: 'Cantando sobre piedras',
      usuario: 'José Dos Ramos',
      fecha: 'Noviembre 6, 2017',
      imagen: 'assets/imgs/likeastone.png',
      visitas: 8
  }, {
      id: 3,
      nombre: 'Hombre con pelo largo ',
      usuario: 'María Estefania Pérez',
      fecha: 'Noviembre 7, 2017',
      imagen: 'assets/imgs/reptilia.png',
      visitas: 8
  }, {
      id: 4,
      nombre: 'Ondas de sonido',
      usuario: 'Barbara Fernández',
      fecha: 'Noviembre 8, 2017',
      imagen: 'assets/imgs/doiwannaknow.png',
      visitas: 8
  }, {
      id: 5,
      nombre: 'Cazador cantando',
      usuario: 'José Dos Ramos',
      fecha: 'Noviembre 9, 2017',
      imagen: 'assets/imgs/africa.png',
      visitas: 8
  }, {
      id: 6,
      nombre: 'Hombre con pasamontañas',
      usuario: 'María Estefania Pérez',
      fecha: 'Noviembre 10, 2017',
      imagen: 'assets/imgs/shapeofyou.png',
      visitas: 8
  }];
  //data: any[];
  buscarQuery : string ='';
  
  items: any[];
  color: 'light';
  estadoNombre:string;
  subscription: Subscription;
  errorMessage = '';
  

//Metodo para llenar el listado de videos
  ngOnInit(): void {
    /*this.subscription = this.api.getVideos('Home/MasVistos')
        .subscribe(data => this.data = data,
        error => this.errorMessage = error);
    this.errorMessage = '';*/
  }

  

  constructor(public navCtrl: NavController,
              public navParams: NavParams, 
              public alertCtrl: AlertController,
              public api : RestApiService) {
    this.initializeItems();
  }

 

  ionViewDidLoad() {
    console.log('ionViewDidLoad TendenciasPage');
  }
  initializeItems(){
    {
      this.items =[{
      nombre: 'Marty',
      suscritos: '133',
      color: this.color,
      estado: 'Suscrito',
      img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'},
      {
        nombre: 'Martin',
        suscritos: '133',
        color: this.color,
        estado: 'Suscrito',
        img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'}]
     }
  }

  getItems(ev: any){
    //Reset items back to all of the items
    this.initializeItems();
    
        // set val to the value of the searchbar
        let val = ev.target.value;
        console.log(val + " value");
    
        if (val === undefined){
            console.log("valor vacio");
            this.data = [{                       //DATA DE PRUEBA LOCAL
                id: 1,
                nombre: 'Kryptonite: Superman odia esto',
                usuario: 'Barbara Fernández',
                fecha: 'Noviembre 5, 2017',
                imagen: 'assets/imgs/kryptonite.png',
                visitas: 8
            }, {
                id: 2,
                nombre: 'Cantando sobre piedras',
                usuario: 'José Dos Ramos',
                fecha: 'Noviembre 6, 2017',
                imagen: 'assets/imgs/likeastone.png',
                visitas: 8
            }, {
                id: 3,
                nombre: 'Hombre con pelo largo ',
                usuario: 'María Estefania Pérez',
                fecha: 'Noviembre 7, 2017',
                imagen: 'assets/imgs/reptilia.png',
                visitas: 8
            }, {
                id: 4,
                nombre: 'Ondas de sonido',
                usuario: 'Barbara Fernández',
                fecha: 'Noviembre 8, 2017',
                imagen: 'assets/imgs/doiwannaknow.png',
                visitas: 8
            }, {
                id: 5,
                nombre: 'Cazador cantando',
                usuario: 'José Dos Ramos',
                fecha: 'Noviembre 9, 2017',
                imagen: 'assets/imgs/africa.png',
                visitas: 8
            }, {
                id: 6,
                nombre: 'Hombre con pasamontañas',
                usuario: 'María Estefania Pérez',
                fecha: 'Noviembre 10, 2017',
                imagen: 'assets/imgs/shapeofyou.png',
                visitas: 8
            }];
            //this.subscription = this.api.getVideos('Home/cargarTodo')              //LLAMADA DE PRUEBAS
            //                    .subscribe(data => this.data = data,
            //                    error => this.errorMessage = error);
            //                    this.errorMessage = '';
        }else if (val != '') {
            this.data = [{                       //DATA DE PRUEBA LOCAL
                id: 1,
                nombre: '3 Doors Down - Kryptonite',
                usuario: 'Barbara Fernández',
                fecha: 'Noviembre 5, 2017',
                imagen: 'assets/imgs/kryptonite.png',
                visitas: 8
            }];
            //this.subscription = this.api.getVideos('Home/cargarTodo')              //LLAMADA DE PRUEBAS
            //                    .subscribe(data => this.data = data,
            //                    error => this.errorMessage = error);
            //                    this.errorMessage = '';
        }else if ((val == '')){
            console.log("valor vacio");
            this.data = [{                       //DATA DE PRUEBA LOCAL
                id: 1,
                nombre: 'Kryptonite: Superman odia esto',
                usuario: 'Barbara Fernández',
                fecha: 'Noviembre 5, 2017',
                imagen: 'assets/imgs/kryptonite.png',
                visitas: 8
            }, {
                id: 2,
                nombre: 'Cantando sobre piedras',
                usuario: 'José Dos Ramos',
                fecha: 'Noviembre 6, 2017',
                imagen: 'assets/imgs/likeastone.png',
                visitas: 8
            }, {
                id: 3,
                nombre: 'Hombre con pelo largo ',
                usuario: 'María Estefania Pérez',
                fecha: 'Noviembre 7, 2017',
                imagen: 'assets/imgs/reptilia.png',
                visitas: 8
            }, {
                id: 4,
                nombre: 'Ondas de sonido',
                usuario: 'Barbara Fernández',
                fecha: 'Noviembre 8, 2017',
                imagen: 'assets/imgs/doiwannaknow.png',
                visitas: 8
            }, {
                id: 5,
                nombre: 'Cazador cantando',
                usuario: 'José Dos Ramos',
                fecha: 'Noviembre 9, 2017',
                imagen: 'assets/imgs/africa.png',
                visitas: 8
            }, {
                id: 6,
                nombre: 'Hombre con pasamontañas',
                usuario: 'María Estefania Pérez',
                fecha: 'Noviembre 10, 2017',
                imagen: 'assets/imgs/shapeofyou.png',
                visitas: 8
            }];
            //this.subscription = this.api.getVideos('Home/cargarTodo')              //LLAMADA DE PRUEBAS
            //                    .subscribe(data => this.data = data,
            //                    error => this.errorMessage = error);
            //                    this.errorMessage = '';
        }
  }
}
