import {Component, ViewChild} from '@angular/core';
import { IonicPage, NavController, NavParams ,AlertController} from 'ionic-angular';
import {EditListPage} from "./edit-list/edit-list";
import { PopoverController } from 'ionic-angular';
import {ViewListPage} from "./view-list/view-list";
import { RestApiService } from "../../app/rest-api.service";
import { Content, Events } from 'ionic-angular';
import { NullAstVisitor } from '@angular/compiler';

import {PopOverListasReproduccionPage} from '../playlist/pop-over-listas-reproduccion/pop-over-listas-reproduccion';
import {AddListPage} from "./add-list/add-list";

/**
 * Generated class for the ListasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-playlist',
  templateUrl: 'playlist.html',
  providers: [RestApiService]
})
export class PlaylistPage {

  public tab: string;
  public respu:any;
  public userid:any = 4;
  public ListasDeReproduccion:any = [];
  public VideosDeLista:any = [];
  public IdListaBorrar:any;


  constructor(public events:Events, public api: RestApiService, public navCtrl: NavController, public navParams: NavParams,public popoverCtrl: PopoverController,public alertCtrl: AlertController) {
  
    this.events.subscribe('reloadPlaylists',() => {
      //call methods to refresh content
      console.log("RELOADEA");
      this.getPlaylists();
  });

  this.events.subscribe('deletePlaylist',(data) => {
    //call methods to refresh content
    console.log("BORRAR LISTA",data);
    this.IdListaBorrar = data.id;
    this.presentConfirm("Hey","Estas seguro de querer eliminar esta lista?");

    
});

  }

  

  @ViewChild('myNav') nav: NavController
  ionViewDidLoad() {
    console.log('ionViewDidLoad ListasPage');
    this.tab = 'mias';
    console.log("ENtre a playlist");
    this.getPlaylists();
  }

  
  presentAlert(title,subTitle) {
    let alert = this.alertCtrl.create({
      title: title,
      subTitle: subTitle
    });
    alert.present();
  }

  presentConfirm(title,message) {
    let alert = this.alertCtrl.create({
      title: title,
      message: message,
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Confirmar',
          handler: () => {
            console.log('delete clicked');
            this.deletePlayList();
          }
        }
      ]
    });
    alert.present();
  }

  deletePlayList(){
    this.api.geta('playlist/deletePlaylist?lis_rep_id='+ this.IdListaBorrar).subscribe((data) => { // Success
      console.log (data.json());
      if(data.json() == true){
        this.getPlaylists();
      }else if(data.json() == false){
        this.presentAlert("Ups","La lista no puedo ser eliminada");
        console.log("Lista no puede ser eliminada");
      }
      
     },
     (error) =>{
       console.error(error);
     });
  }

  getPlaylists(){

    this.api.geta('playlist/getAllPlaylist?id_usu='+ this.userid).subscribe((data) => { // Success
          console.log (data.json());
          this.ListasDeReproduccion = data.json();
         },
         (error) =>{
           console.error(error);
         });
  }


  presentPopover(myEvent,lista) {
    let popover = this.popoverCtrl.create(PopOverListasReproduccionPage,{listapopover:lista});
    popover.present({
      ev: myEvent
    });
  }


  public goToViewList(id,name){
    console.log("Lista que vere", id, name);

    this.api.geta('playlist/getVideosFromPlaylist?lis_rep_id='+ id).subscribe((data) => { // Success
      console.log (data.json());
      this.VideosDeLista = data.json();
      this.navCtrl.push(ViewListPage,{VideosDeLista : this.VideosDeLista, NombreLista : name,IdLista:id});
     },
     (error) =>{
       console.error(error);
     });

    
  }

  public goToAddList(){
    this.navCtrl.push(AddListPage,{listasAdd: this.ListasDeReproduccion});
  }

}
