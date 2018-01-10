import { Component,ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { FormBuilder, FormGroup, Validators, AbstractControl} from '@angular/forms';
import { AlertController } from 'ionic-angular';
import { AngularFireAuth } from 'angularfire2/auth';
import { CategoriaPage} from '../categoria/categoria';
import { HomecablePage } from '../homecable/homecable';
import firebase from 'firebase';

@IonicPage()
@Component({
  selector: 'page-registrarse',
  templateUrl: 'registrarse.html',
})
export class RegistrarsePage {
//objeto para facebook
//
//
//
//
provider = {   
    name: '',
    profilePicture: '',
    email: '',
    loggedin: false
  }

  @ViewChild('email') usu;
  @ViewChild('Contraseña') passw;
  @ViewChild('RepetirContraseña') passw2;
  userData=null;
  myForm:FormGroup;
  Usuario:AbstractControl;
  email:AbstractControl;
  Contraseña:AbstractControl;
  RepetirContraseña:AbstractControl;

  constructor(
    public alertCtrl: AlertController, 
    private fire: AngularFireAuth,  
    public navCtrl: NavController, 
    public navParams: NavParams,
    public formbuilder: FormBuilder
  ) {
    this.myForm = this.formbuilder.group({
      email:['',[Validators.required, Validators.email]],
      Contraseña:['',[Validators.required,Validators.pattern(/^[a-z0-9_-]{6,18}$/)]],
      RepetirContraseña:['',[Validators.required,Validators.pattern(/^[a-z0-9_-]{6,18}$/)]],
    });

    this.email = this.myForm.controls['email'];
    this.Contraseña = this.myForm.controls['Contraseña'];
    this.RepetirContraseña = this.myForm.controls['RepetirContraseña'];
  }

  saveData(){
    console.log(this.myForm.value);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RegistrarsePage');
  }

 //
  //PARA EL WS
  //----para los mensajes de alerta
  alert(message:string){
  this.alertCtrl.create({
    title: 'Info!',
    subTitle: message,
    buttons: ['OK']

  }).present();
}
//--Registrar usuario normal
   registerUser(){
     
     this.fire.auth.createUserWithEmailAndPassword(this.usu.value, this.passw.value)
     .then(data=>{
      console.log('agarre  data ',data);
      this.alert('Registrado!');
      this.navCtrl.setRoot(HomecablePage);
     })
    .catch(error =>{
    console.log('got error', error);
    this.alert(error.message);
    });


    console.log('registrar con',this.usu.value, this.passw.value);

  }
//--Registrar por facebook google twitter
    loginWithFacebook(){
        this.fire.auth.signInWithPopup(new firebase.auth.FacebookAuthProvider())
        .then( res =>{
         this.provider.loggedin = true;
         this.provider.name= res.user.displayName;
         this.provider.email = res.user.email;
         this.provider.profilePicture = res.user.photoURL;
          console.log(res);
          this.navCtrl.setRoot(HomecablePage);
          this.alert('Exito! tu te logeaste');
        })
        .catch(error =>{
          console.log('encontramos error', error );
          this.alert(error.message);
          })
}



loginWithGoogle(){
this.fire.auth.signInWithPopup (new firebase.auth.GoogleAuthProvider())
.then( res=>{
  console.log('fdesde --google--');
console.log(res);
this.provider.loggedin = true;
this.provider.name= res.user.displayName;
this.provider.email = res.user.email;
this.provider.profilePicture = res.user.photoURL;
 console.log(res);
 
 this.navCtrl.setRoot( HomecablePage);
 this.alert('Exito! tu te logeaste');
})
.catch(error =>{
  console.log('encontramos error', error );
  this.alert(error.message);
  })
}

loginWithTwitter(){
  this.fire.auth.signInWithPopup (new firebase.auth.TwitterAuthProvider())
  .then( res=>{
    console.log('fdesde --twitter--');
  console.log(res);
  this.provider.loggedin = true;
  this.provider.name= res.user.displayName;
  this.provider.email = res.user.email;
  this.provider.profilePicture = res.user.photoURL;
 
   this.navCtrl.setRoot( HomecablePage);
   this.alert('Exito! tu te logeaste');
  })
  .catch(error =>{
    console.log('encontramos error', error );
    this.alert(error.message);
    })
  }



//--deslogear desde fb twtter y google

    

    logout(){
        this.fire.auth.signOut();

        this.provider.loggedin = false;
    }






  //-Primer login de fb sin firebase---------------
//loginWithFB() {
  
  // this.facebook.login(['email', 'public_profile','user_friends']).then((Response: FacebookLoginResponse)=>	 {
  //  this.facebook.api('me?fields=id,name,email,first_name,picture.width(720).height(720).as(picture_large)',[]).then(profile =>{
    
  //  this.userData ={email: profile['email'], first_name: profile['first_name'],picture: profile['picture_large']['data']['url'], username:profile['name'] };
  //  }  )
 // } )


 
  

//}

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
