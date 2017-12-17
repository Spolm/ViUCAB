import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';


@IonicPage()
@Component({
  selector: 'page-homecable',
  templateUrl: 'homecable.html',
})
export class HomecablePage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public app: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HomecablePage');
  }

  /**
Se usa para devolverte a una pagina
 */
logout() {  
const root = this.app.getRootNav();
root.popToRoot();

}
}
