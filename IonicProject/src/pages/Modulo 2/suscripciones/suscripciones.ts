import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, PopoverController,AlertController } from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';

/**
 * Generated class for the SuscripcionesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-suscripciones',
  templateUrl: 'suscripciones.html',
  providers: [RestApiService]
})
export class SuscripcionesPage {
  buscarQuery : string ='';
  
  items: any[];
  color: 'light';
  estadoNombre:string;
  

  
  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public popoverCtrl: PopoverController,
              public alertCtrl: AlertController,
              public api : RestApiService) {
    this.initializeItems();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SuscripcionesPage');
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
