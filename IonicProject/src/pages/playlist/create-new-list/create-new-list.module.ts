import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CreateNewListPage } from './create-new-list';

@NgModule({
  declarations: [
    CreateNewListPage,
  ],
  imports: [
    IonicPageModule.forChild(CreateNewListPage),
  ],
})
export class CreateNewListPageModule {}
