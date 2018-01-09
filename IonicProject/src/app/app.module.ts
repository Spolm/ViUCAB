import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';
import { ChartsModule } from 'ng2-charts';

// Modificado Grupo 10
import { HttpModule } from '@angular/http';
import { NotificacionesPage } from '../pages/notificaciones/notificaciones';
import { ConfiguracionNotificacionesPage } from '../pages/configuracion-notificaciones/configuracion-notificaciones';
// Fin Modificado

// Modificado Grupo 8
import { ChannelsPage } from '../pages/Modulo 8/channels/channels';
// Fin modificado

@NgModule({
  declarations: [
    MyApp,
    NotificacionesPage,
    ConfiguracionNotificacionesPage,
    ChannelsPage,

  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpModule,
    ChartsModule,
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    NotificacionesPage,
    ConfiguracionNotificacionesPage,
    ChannelsPage,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ],
})
export class AppModule {}
