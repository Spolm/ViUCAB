import { Component,ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Facebook, FacebookLoginResponse } from '@ionic-native/facebook';
import { HomecablePage } from '../homecable/homecable';
import { FormBuilder, FormGroup, Validators, AbstractControl} from '@angular/forms';
import { AlertController } from 'ionic-angular';

import { AngularFireAuth } from 'angularfire2/auth';
@IonicPage()
@Component({
  selector: 'page-regristrarse',
  templateUrl: 'regristrarse.html',
})
export class RegristrarsePage {
  @ViewChild('Usuario') usu;
@ViewChild('Contrasena') passw;

  userData=null;
  formgroup:FormGroup;
  Usuario:AbstractControl;
  email:AbstractControl;
  Contraseña:AbstractControl;
  RepetirContraseña:AbstractControl;

  constructor(public alertCtrl: AlertController, private fire: AngularFireAuth,  public navCtrl: NavController, public navParams: NavParams,private facebook: Facebook,
  public formbuilder: FormBuilder) {
this.formgroup = formbuilder.group({
  Usuario:['',Validators.required],
  email:['',Validators.required],
  Contraseña:['',Validators.required],
  RepetirContraseña:['',Validators.required],

});

this.Usuario = this.formgroup.controls['Usuario'];

this.email = this.formgroup.controls['email'];
this.Contraseña = this.formgroup.controls['Contraseña'];
this.RepetirContraseña = this.formgroup.controls['RepetirContraseña'];




  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad RegristrarsePage');
  }

 
  //PARA EL WS
  alert(message:string){
  this.alertCtrl.create({
    title: 'Info!',
    subTitle: message,
    buttons: ['OK']

  }).present();
}

   registerUser(){
     
     this.fire.auth.createUserWithEmailAndPassword(this.usu.value, this.passw.value)
     .then(data=>{
      console.log('agarre  data ',data);
      this.alert('Registrado!');
     })
.catch(error =>{
console.log('got error', error);
this.alert(error.message);
});


console.log('registrar con',this.usu.value, this.passw.value);

  }
loginWithFB() {
  
   this.facebook.login(['email', 'public_profile','user_friends']).then((Response: FacebookLoginResponse)=>	 {
    this.facebook.api('me?fields=id,name,email,first_name,picture.width(720).height(720).as(picture_large)',[]).then(profile =>{
    
    this.userData ={email: profile['email'], first_name: profile['first_name'],picture: profile['picture_large']['data']['url'], username:profile['name'] };
    }  )
  } )


 
  

}

/*
loginWithFB() {
  
  this.facebook.login(['public_profile', 'user_friends', 'email'])
  .then((res: FacebookLoginResponse) => console.log('Logged into Facebook!', res))
  .catch(e => console.log('Error logging into Facebook', e));


this.facebook.logEvent(this.facebook.EVENTS.EVENT_NAME_ADDED_TO_CART);

}

*/
signup() {
 this.navCtrl.push(HomecablePage); 
}
 }
