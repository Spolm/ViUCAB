import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';

import {EditListPage} from "../pages/playlist/edit-list/edit-list";
import {ViewListPage} from "../pages/playlist/view-list/view-list";
import {CreateNewListPage} from "../pages/playlist/create-new-list/create-new-list";
import {AddListPage} from "../pages/playlist/add-list/add-list";
import { PopOverListasReproduccionPage} from '../pages/playlist/pop-over-listas-reproduccion/pop-over-listas-reproduccion';
//Modificado Grupo 10
import { HttpModule } from '@angular/http';
import { NotificacionesPage } from '../pages/notificaciones/notificaciones';
import { ConfiguracionNotificacionesPage } from '../pages/configuracion-notificaciones/configuracion-notificaciones';
//Fin Modificado

@NgModule({
  declarations: [
    MyApp,
    EditListPage,
    PopOverListasReproduccionPage,
    ViewListPage,
    AddListPage,
    CreateNewListPage,
    NotificacionesPage,
    ConfiguracionNotificacionesPage

  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    EditListPage,
    PopOverListasReproduccionPage,
    ViewListPage,
    AddListPage,
    CreateNewListPage,
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
