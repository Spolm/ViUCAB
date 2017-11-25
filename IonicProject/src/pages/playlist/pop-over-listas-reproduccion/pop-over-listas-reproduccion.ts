import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
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

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PopOverListasReproduccionPage');
  }

  public goToEditList(){
    this.navCtrl.push(EditListPage);
  }

}
