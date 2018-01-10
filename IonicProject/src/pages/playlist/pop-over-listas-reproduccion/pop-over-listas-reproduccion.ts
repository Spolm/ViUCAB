import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Events } from 'ionic-angular';
import {EditListPage} from "../edit-list/edit-list";

/**
 * Generated class for the PopOverListasReproduccionPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-pop-over-listas-reproduccion',
  templateUrl: 'pop-over-listas-reproduccion.html',
})
export class PopOverListasReproduccionPage {

  public Lista:any;

  constructor(public events:Events, public navCtrl: NavController, public navParams: NavParams) {
    this.Lista = this.navParams.get('listapopover');
    console.log("Mi lista aqui:", this.Lista);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PopOverListasReproduccionPage');
  }

  public goToEditList(){
    this.navCtrl.pop();
    this.navCtrl.push(EditListPage,{ListaEdit: this.Lista});

  }

  public goToDeleteList(){
    this.navCtrl.pop();
    setTimeout(function() {
      
    }, 1000);
    
    this.events.publish('deletePlaylist',{id: this.Lista.idLista});
    
    

  }


}
