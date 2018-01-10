import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { MisVideosPage } from './mis-videos';

@NgModule({
  declarations: [
    MisVideosPage,
  ],
  imports: [
    IonicPageModule.forChild(MisVideosPage),
  ],
})
export class MisVideosPageModule {}
