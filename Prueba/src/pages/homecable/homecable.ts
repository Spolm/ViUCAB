import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';

import { AngularFireAuth } from 'angularfire2/auth';

@IonicPage()
@Component({
  selector: 'page-homecable',
  templateUrl: 'homecable.html',
})
export class HomecablePage {
//declarando el srting pra recibir
email:string;

  constructor(private fire: AngularFireAuth, public navCtrl: NavController, public navParams: NavParams, public app: App) {
  //
  this.email = fire.auth.currentUser.email;
  
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HomecablePage');
  }
//
  /**
Se usa para devolverte a una pagina
 */
logout() {  
const root = this.app.getRootNav();
root.popToRoot();

}
}
