import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { OlvidarContraseñaPage }from '../olvidar-contraseña/olvidar-contraseña';
import { RegristrarsePage } from '../regristrarse/regristrarse';
import { AlertController } from 'ionic-angular';
/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  constructor(public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

  goPaginaOlvidarcontra():void {
    this.navCtrl.push(OlvidarContraseñaPage);
      }

      goPaginaRegistrar():void {
        this.navCtrl.push(RegristrarsePage); {
        
          } 
        }

//Funcion mostrar confirmacion
  showConfirm() {
    let confirm = this.alertCtrl.create({
      title: 'Use this lightsaber?',
      message: 'Do you agree to use this lightsaber to do good across the intergalactic galaxy?',
      buttons: [
        {
          text: 'Disagree',
          handler: () => {
            console.log('Disagree clicked');
          }
        },
        {
          text: 'Agree',
          handler: () => {
            console.log('Agree clicked');
          }
        }
      ]
    });
    confirm.present();
  }
}

