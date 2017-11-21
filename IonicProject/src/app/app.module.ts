import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';
import {EditListPage} from "../pages/Modulo 2/listas/edit-list/edit-list";
import {ViewListPage} from "../pages/Modulo 2/listas/view-list/view-list";
import {AddListPage} from "../pages/Modulo 2/listas/add-list/add-list";

import { PopOverListasReproduccionPage} from '../pages/Modulo 2/listas/pop-over-listas-reproduccion/pop-over-listas-reproduccion';


@NgModule({
  declarations: [
    MyApp,
    EditListPage,
    PopOverListasReproduccionPage,
    ViewListPage,
    AddListPage

  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    EditListPage,
    PopOverListasReproduccionPage,
    ViewListPage,
    AddListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
