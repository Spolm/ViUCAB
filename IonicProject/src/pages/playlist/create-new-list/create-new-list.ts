import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, Events } from 'ionic-angular';
import { RestApiService } from "../../../app/rest-api.service";
/**
 * Generated class for the CreateNewListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-create-new-list',
  templateUrl: 'create-new-list.html',
  providers: [RestApiService]
})
export class CreateNewListPage {

  public nombreLista:any;
  public descripcionLista:any;

  constructor(public events:Events, public navCtrl: NavController,public api: RestApiService, public navParams: NavParams, public alertCtrl: AlertController) {
  }
  
  guardarListaNueva(){
    this.api.geta('playlist/createPlaylist?id_usu='+ 4 +'&lis_rep_nombre='+ this.nombreLista +'&lis_rep_descripcion='+ this.descripcionLista).subscribe((data) => { // Success
      console.log (data.json());
      if(data.json() == true){
        this.events.publish('reloadPlaylists');
        this.navCtrl.pop();
      }else if(data.json() == false){
        
      }
      
     },
     (error) =>{
       console.error(error);
     });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CreateNewListPage');
  }

}
