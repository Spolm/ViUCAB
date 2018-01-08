import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertController } from 'ionic-angular';
import { AngularFireAuth } from 'angularfire2/auth';
import { LoginPage} from '../login/login';
/**
 * Generated class for the OlvidarContraseñaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-olvidar-contrasena',
  templateUrl: 'olvidar-contraseña.html',
})
export class OlvidarContraseñaPage {

  @ViewChild('email') email;
  myForm: FormGroup;

  constructor(
    private fire:AngularFireAuth, 
    public navCtrl: NavController, 
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public formBuilder: FormBuilder
  )  {
    this.myForm = this.formBuilder.group({
      email: ['',[ Validators.required,Validators.email]]
    });
  }

  saveData(){
    console.log(this.myForm.value);
  }

  alert(info:string, message:string){
    this.alertCtrl.create({
      title: info,
      subTitle: message,
      buttons: ['OK']
  
    }).present();
  }

  verificacion(){
    if(this.email.value == "fer@gmail.com"){
      this.alert('Recuperacion de contraseña','Hemos enviado tu contraseña a tu correo');
      this.navCtrl.push(LoginPage)
    }else{
      this.alert('Datos incorrectos','El correo no esta registrado');
    }
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad OlvidarContraseñaPage');
  }

}
