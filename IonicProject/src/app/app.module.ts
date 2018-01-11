import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';
import { HomePage } from '../pages/M01-Login/home/home';
import { LoginPageModule } from '../pages/M01-Login/login/login.module';
import { OlvidarContraseñaPageModule } from '../pages/M01-Login/olvidar-contraseña/olvidar-contraseña.module';
import { RegistrarsePageModule} from '../pages/M01-Login/registrarse/registrarse.module';
import { InvitacionTwitterPageModule} from '../pages/M01-Login/invitacion-twitter/invitacion-twitter.module';
import {HomecablePageModule } from '../pages/M01-Login/homecable/homecable.module';




import { AngularFireModule } from 'angularfire2';
import  {Facebook} from '@ionic-native/facebook';
import { AngularFireAuthModule } from 'angularfire2/auth';


import { AngularFireAuth } from 'angularfire2/auth'


const firebaseAuth = {
  apiKey: "AIzaSyD5QOpTS7_8zgRSu3dBaG-V6B9QmQpD_Uc",
  authDomain: "test-project-9ca72.firebaseapp.com",
  databaseURL: "https://test-project-9ca72.firebaseio.com",
  projectId: "test-project-9ca72",
  storageBucket: "test-project-9ca72.appspot.com",
  messagingSenderId: "438129532489"
};

@NgModule({
  declarations: [
    MyApp,
    HomePage
  ],
  imports: [
    BrowserModule,
    LoginPageModule,
    OlvidarContraseñaPageModule,
    RegistrarsePageModule,
     InvitacionTwitterPageModule,
     HomecablePageModule,
    
     AngularFireModule.initializeApp(firebaseAuth) ,
     AngularFireAuthModule,
    
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
   AngularFireAuth,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Facebook
    
  ]
})
export class AppModule {}
