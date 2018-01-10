import {Component, ViewChild} from '@angular/core';
import { IonicPage, NavController, NavParams ,AlertController} from 'ionic-angular';
import {EditListPage} from "./edit-list/edit-list";
import { PopoverController } from 'ionic-angular';
import {ViewListPage} from "./view-list/view-list";
import { RestApiService } from "../../app/rest-api.service";
import { Content } from 'ionic-angular';
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
  public VideosDeLista:any = []


  constructor(public api: RestApiService, public navCtrl: NavController, public navParams: NavParams,public popoverCtrl: PopoverController,public alertCtrl: AlertController) {
  }

  

  @ViewChild('myNav') nav: NavController
  ionViewDidLoad() {
    console.log('ionViewDidLoad ListasPage');
    this.tab = 'mias';
    console.log("ENtre a playlist");
    this.getPlaylists();
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

  

  presentPopover(myEvent) {
    let popover = this.popoverCtrl.create(PopOverListasReproduccionPage);
    popover.present({
      ev: myEvent
    });
  }

  public goToEditList(){
    this.navCtrl.push(EditListPage);
  }

  public goToViewList(id,name){
    console.log("Lista que vere", id, name);

    this.api.geta('playlist/getVideosFromPlaylist?lis_rep_id='+ id).subscribe((data) => { // Success
      console.log (data.json());
      this.VideosDeLista = data.json();
      this.navCtrl.push(ViewListPage,{VideosDeLista : this.VideosDeLista, NombreLista : name});
     },
     (error) =>{
       console.error(error);
     });

    
  }

  public goToAddList(){
    this.navCtrl.push(AddListPage);
  }

}
