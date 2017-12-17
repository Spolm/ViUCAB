import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Facebook, FacebookLoginResponse } from '@ionic-native/facebook';
import { HomecablePage } from '../homecable/homecable';
import { FormBuilder, FormGroup, Validators, AbstractControl} from '@angular/forms';
@IonicPage()
@Component({
  selector: 'page-regristrarse',
  templateUrl: 'regristrarse.html',
})
export class RegristrarsePage {
  userData=null;
  formgroup:FormGroup;
  Usuario:AbstractControl;
  email:AbstractControl;
  Contraseña:AbstractControl;
  RepetirContraseña:AbstractControl;

  constructor( public navCtrl: NavController, public navParams: NavParams,private facebook: Facebook,
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
//public navCtrl: NavController, public navParams: NavParams,
 // ionViewDidLoad() {
   // console.log('ionViewDidLoad RegristrarsePage');
  //}
  //PARA EL WS
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
