import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { HomecablePage } from './homecable';

@NgModule({
  declarations: [
    HomecablePage,
  ],
  imports: [
    IonicPageModule.forChild(HomecablePage),
  ],
})
export class HomecablePageModule {}
