import { Component } from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {RestApiService} from "../../../app/rest-api.service";

/**
 * Generated class for the EditListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-edit-list',
  templateUrl: 'edit-list.html',
  providers:[RestApiService]
})

export class EditListPage {


  respu : any

  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public api : RestApiService) {


  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EditListPage');
    this.obtener()
  }

  public obtener ()
  {
    this.api.geta('playlist/editPlaylist').subscribe((data) => { // Success
        this.respu = data.json()
        console.log (this.respu)
      },
      (error) =>{
        console.error(error);
      });

  }

}
