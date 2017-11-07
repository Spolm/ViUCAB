import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';
import {NotificacionesPage} from '../pages/notificaciones/notificaciones';
import {ConfiguracionNotificacionesPage} from '../pages/configuracion-notificaciones/configuracion-notificaciones';

@NgModule({
  declarations: [
    MyApp,
    NotificacionesPage,
    ConfiguracionNotificacionesPage
 
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
     NotificacionesPage,
    ConfiguracionNotificacionesPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
