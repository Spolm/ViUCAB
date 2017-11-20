import {Component, ViewChild} from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {EditListPage} from "./edit-list/edit-list";

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

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  @ViewChild('myNav') nav: NavController
  ionViewDidLoad() {
    console.log('ionViewDidLoad ListasPage');
  }

  public goToEditList(){
    this.navCtrl.push(EditListPage);
  }

}
