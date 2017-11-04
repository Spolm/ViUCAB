import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ListaVideosPage } from './lista-videos';

@NgModule({
  declarations: [
    ListaVideosPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaVideosPage),
  ],
})
export class ListaVideosPageModule {}
