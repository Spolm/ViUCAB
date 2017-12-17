import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPageModule } from '../pages/login/login.module';
import { OlvidarContraseñaPageModule } from '../pages/olvidar-contraseña/olvidar-contraseña.module';
import { RegristrarsePageModule} from '../pages/regristrarse/regristrarse.module';
import { InvitacionTwitterPageModule} from '../pages/invitacion-twitter/invitacion-twitter.module';
import {HomecablePageModule } from '../pages/homecable/homecable.module';

import  {Facebook} from '@ionic-native/facebook';

@NgModule({
  declarations: [
    MyApp,
    HomePage
  ],
  imports: [
    BrowserModule,
    LoginPageModule,
    OlvidarContraseñaPageModule,
    RegristrarsePageModule,
     InvitacionTwitterPageModule,
     HomecablePageModule,

    
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
  
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Facebook
  ]
})
export class AppModule {}
