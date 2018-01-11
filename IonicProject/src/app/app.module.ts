import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { FileTransfer, FileUploadOptions, FileTransferObject } from '@ionic-native/file-transfer';
import { FilePath } from '@ionic-native/file-path';
import { File } from '@ionic-native/file';
import { Camera } from '@ionic-native/camera';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { MyApp } from './app.component';
import { ChartsModule } from 'ng2-charts';
import { FileChooser } from '@ionic-native/file-chooser';
import {EditListPage} from "../pages/playlist/edit-list/edit-list";
import {ViewListPage} from "../pages/playlist/view-list/view-list";
import {CreateNewListPage} from "../pages/playlist/create-new-list/create-new-list";
import {AddListPage} from "../pages/playlist/add-list/add-list";
import { PopOverListasReproduccionPage} from '../pages/playlist/pop-over-listas-reproduccion/pop-over-listas-reproduccion';
import { HTTP } from '@ionic-native/http';
import { HttpClientModule } from '@angular/common/http';
//Modificado Grupo 3
import { CargarVideoPage } from '../pages/Modulo3/cargar-video/cargar-video';
import { InfovideoPage } from '../pages/Modulo3/infovideo/infovideo';
import { MisVideosPage } from '../pages/Modulo3/mis-videos/mis-videos';
import { ListarmisvideosPage } from '../pages/Modulo3/listarmisvideos/listarmisvideos';
//Fin Modificado

//Modificado Grupo 10
import { HttpModule } from '@angular/http';
import { NotificacionesPage } from '../pages/notificaciones/notificaciones';
import { ConfiguracionNotificacionesPage } from '../pages/configuracion-notificaciones/configuracion-notificaciones';
//Fin Modificado

//Modificado Grupo 8
import { ChannelsPage } from '../pages/Modulo 8/channels/channels';
//Fin modificado

import {ReproductorPage} from "../pages/reproductor/reproductor"

//Modificado por Grupo 12
import { AccesoConfigContenidoPage } from '../pages/M12_ModeracionContenido/acceso-config-contenido/acceso-config-contenido';
import { ServicioProvider } from '../providers/servicio/servicio';
//Fin modificación

@NgModule({
  declarations: [
    MyApp,
    EditListPage,
    PopOverListasReproduccionPage,
    ViewListPage,
    AddListPage,
    CreateNewListPage,
    NotificacionesPage,
    ConfiguracionNotificacionesPage,
    ChannelsPage,
    ReproductorPage,
    AccesoConfigContenidoPage

  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpModule,
    HttpClientModule,
    ChartsModule
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
    ConfiguracionNotificacionesPage,
    ChannelsPage,
    ReproductorPage,
    AccesoConfigContenidoPage
  ],
  providers: [
    StatusBar,
    FileTransfer,
    FileTransferObject,
    File,
    Camera,
    FileChooser,
    FilePath,
    HTTP,
    SplashScreen,
    ServicioProvider,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
