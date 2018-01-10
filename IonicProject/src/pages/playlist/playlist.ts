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
  public userid = 4;
  public ListasDeReproduccion = [
    { title: 'Lista numero 1', amount: '13', duration: '30:00 min', img:'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg'},
    { title: 'Lista numero 2', amount: '3', duration: '3:00 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
    { title: 'Lista numero 3', amount: '1', duration: '39:05 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
  ];


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

    this.api.geta('playlist/getAllPlaylist?id_usu='+ this.userid)

      .subscribe((data) => { // Success
          console.log (data);
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

  public goToViewList(){
    this.navCtrl.push(ViewListPage);
  }

  public goToAddList(){
    this.navCtrl.push(AddListPage);
  }

}
