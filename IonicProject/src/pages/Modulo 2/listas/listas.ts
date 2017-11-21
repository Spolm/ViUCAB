import {Component, ViewChild} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {EditListPage} from "./edit-list/edit-list";
import { PopoverController } from 'ionic-angular';
import {ViewListPage} from "./view-list/view-list";
import {CreateNewListPage} from "./create-new-list/create-new-list";

import {PopOverListasReproduccionPage} from '../listas/pop-over-listas-reproduccion/pop-over-listas-reproduccion';

/**
 * Generated class for the ListasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-listas',
  templateUrl: 'listas.html',
})
export class ListasPage {

  public tab: string;
  public ListasDeReproduccion = [
    { title: 'Lista numero 1', amount: '13', duration: '30:00 min', img:'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg'},
    { title: 'Lista numero 2', amount: '3', duration: '3:00 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
    { title: 'Lista numero 3', amount: '1', duration: '39:05 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
  ];

  constructor(public navCtrl: NavController, public navParams: NavParams,public popoverCtrl: PopoverController) {
  }

  @ViewChild('myNav') nav: NavController
  ionViewDidLoad() {
    console.log('ionViewDidLoad ListasPage');
    this.tab = 'mias';
  }

  presentPopover(myEvent) {
    let popover = this.popoverCtrl.create(PopOverListasReproduccionPage);
    popover.present({
      ev: myEvent
    });
  }

  public goToViewList(){
    this.navCtrl.push(ViewListPage);
  }

  public goToCreateNewList(){
    this.navCtrl.push(CreateNewListPage);
  }

}
