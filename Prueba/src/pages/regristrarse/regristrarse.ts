import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Facebook, FacebookLoginResponse } from '@ionic-native/facebook';
import { HomecablePage } from '../homecable/homecable';

@IonicPage()
@Component({
  selector: 'page-regristrarse',
  templateUrl: 'regristrarse.html',
})
export class RegristrarsePage {
  userData=null;
  constructor( public navCtrl: NavController, public navParams: NavParams,private facebook: Facebook) {
  }
//public navCtrl: NavController, public navParams: NavParams,
 // ionViewDidLoad() {
   // console.log('ionViewDidLoad RegristrarsePage');
  //}
  //PARA EL WS
  loginWithFB() {
  
   this.facebook.login(['email', 'public_profile']).then((Response: FacebookLoginResponse)=>	 {
    this.facebook.api('me?fields=id,name,email,first_name,picture.width(120).height(120).as(picture_large)',[]).then(profile =>{
    
    this.userData ={email: profile['email'], first_name: profile['first_name'],picture: profile['picture_large']['data']['url'], username:profile['name'] };
    }  )
  } )

}
 }
