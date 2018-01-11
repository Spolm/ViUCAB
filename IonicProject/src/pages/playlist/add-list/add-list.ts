import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController} from 'ionic-angular';
import { CreateNewListPage } from '../create-new-list/create-new-list';
// import { AlertController } from 'ionic-angular';
import { RestApiService } from "../../../app/rest-api.service";

/**
 * Generated class for the AddListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-add-list',
  templateUrl: 'add-list.html',
  providers: [RestApiService]
})
export class AddListPage {

  public ListasDeReproduccion:any =[];

  constructor(public api: RestApiService, public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    this.ListasDeReproduccion = this.navParams.get('listasAdd');
    console.log(this.ListasDeReproduccion);
  }


  ionViewDidLoad() {
    console.log('ionViewDidLoad AddListPage');
  }



  /*  showAddListPrompt() {
    let prompt = this.alertCtrl.create({
      title: 'Crear Lista',
      message: "Introduzca datos de la Lista a crear",
      inputs: [
        {
          name: 'title',
          placeholder: 'Titulo'
        },
        {
          name: 'description',
          placeholder: 'Descripcion'
        }
      ],

      buttons: [
        {
          text: 'Cancel',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Save',
          handler: data => {
            console.log('Saved clicked');
          }
        }
      ]
    });
    prompt.present();
  }*/

  public goToCreateNewList(){
    this.navCtrl.pop();
    this.navCtrl.push(CreateNewListPage);
  }

  presentAlert(title,subTitle) {
    let alert = this.alertCtrl.create({
      title: title,
      subTitle: subTitle
    });
    alert.present();
  }

  public addVideoToList(idLista){
    console.log("video agregado a esta lista",idLista);

 
    this.api.geta('playlist/addVideoToPlaylist?vid_id='+ 1
  +'&?lis_rep_id='+ idLista).subscribe((data) => { // Success
      console.log (data.json());
      if(data.json() == true){
        this.navCtrl.pop();
      }else if(data.json() == false){
        this.presentAlert("Ups","El video no pudo ser agregado a la lista");
       
      }
      
     },
     (error) =>{
       console.error(error);
     });

  }

}
