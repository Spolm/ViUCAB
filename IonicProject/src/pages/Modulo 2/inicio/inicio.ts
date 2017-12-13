import {Component, ViewChild} from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';
import { Subscription } from 'rxjs/Subscription';


/**
 * Generated class for the InicioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-inicio',
  templateUrl: 'inicio.html',
  providers: [RestApiService]
})
export class InicioPage {
  /*data = [{                       //DATA DE PRUEBA LOCAL
      id: 1,
      title: 'Video 1',
      user: 'Barbara Fernández',
      date: 'November 5, 1955'
  }, {
      id: 2,
      title: 'Video 2',
      user: 'Barbara Fernández',
      date: 'November 6, 1955'
  }, {
      id: 3,
      title: 'Video 3',
      user: 'Barbara Fernández',
      date: 'November 7, 1955'
  }, {
      id: 4,
      title: 'Video 4',
      user: 'Barbara Fernández',
      date: 'November 8, 1955'
  }, {
      id: 5,
      title: 'Video 5',
      user: 'Barbara Fernández',
      date: 'November 9, 1955'
  }, {
      id: 6,
      title: 'Video 6',
      user: 'Barbara Fernández',
      date: 'November 5, 1955'
  }];*/
  data: any[];
  buscarQuery : string ='';
  items: any[];
  color: 'light';
  estadoNombre:string;
  subscription: Subscription;
  errorMessage = '';
  

//Metodo para llenar el listado de videos inicial
  ngOnInit(): void {
    this.subscription = this.api.getVideosPrueba('Home/cargarTodo')
        .subscribe(items => this.items = items,
        error => this.errorMessage = error);
    this.errorMessage = '';
  }


  @ViewChild('myNav') nav: NavController
  constructor(public navCtrl: NavController,
              public navParams: NavParams, 
              public alertCtrl: AlertController,
              public api : RestApiService) {
    this.initializeItems();
    this.api.getTodo('Home/MasVistos');
    
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InicioPage');
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
    
        // if the value is an empty string don't filter the items
        if (val && val.trim() != '') {
          this.items = this.items.filter((item) => {
            return (item.nombre.toLowerCase().indexOf(val.toLowerCase()) > -1);
          })
        }
  }

}
