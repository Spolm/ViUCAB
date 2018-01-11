import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
   import { LoginPage } from '../login/login';
   import  { InvitacionTwitterPage } from '../invitacion-twitter/invitacion-twitter';
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {

  }
goPaginaLogin():void {
  this.navCtrl.push(LoginPage);
    }

goPaginaPrueba():void {
      this.navCtrl.push(InvitacionTwitterPage);
        }
}
