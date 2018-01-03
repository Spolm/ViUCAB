import { Component, ViewChild } from '@angular/core';
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

 
import { AngularFireAuth } from 'angularfire2/auth';
import { HomecablePage } from '../homecable/homecable';

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

@ViewChild('Usuario') usu;
@ViewChild('Contrasena') passw;


  constructor(private fire:AngularFireAuth, public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }
alert(message:string){
  this.alertCtrl.create({
    title: 'Info!',
    subTitle: message,
    buttons: ['OK']

  }).present();
}


IniciarS(){
this.fire.auth.signInWithEmailAndPassword(this.usu.value, this.passw.value)
.then ( data =>{
  console.log('agarra la data ', this.fire.auth.currentUser)
  this.alert('Exito! tu te logeaste');
  this.navCtrl.setRoot( HomecablePage);
  
  //el usuario es logeado
})
.catch(error =>{
console.log('encontramos error', error );
this.alert(error.message);
})
  console.log('Iniciar sesion con', this.usu.value, this.passw.value);
  

 // console.log(this.usu.value, this.passw.value)


  // -------codigo para validacion-----
  /*
if(this.usu.value == "luis" && this.passw.value == "admin"){
  let alert = this.alertCtrl.create({

    title: 'Logeaste correctamentes',
    subTitle: 'Excelente!',
    buttons: ['OK']
   
  });
  alert.present();
  this.navCtrl.push(HomecablePage);
}else{

  let alert = this.alertCtrl.create({
    
        title: 'ERROR!!!',
        subTitle: 'Usuario o contraseña incorrectas!',
        buttons: ['OK']
       
      });
      alert.present();

}*/
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

