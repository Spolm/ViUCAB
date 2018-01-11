import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController} from 'ionic-angular';
import {EditListPage} from "../edit-list/edit-list";
import { RestApiService } from "../../../app/rest-api.service";

/**
 * Generated class for the ViewListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-view-list',
  templateUrl: 'view-list.html',
  providers: [RestApiService]
})
export class ViewListPage {

  public VideosDeLista:any = [];
  public NombreLista:any;
  public idLista:any;
  public idVideo:any;

  constructor(public alertCtrl: AlertController,public api: RestApiService,public navCtrl: NavController, public navParams: NavParams) {
    this.VideosDeLista = this.navParams.get('VideosDeLista');
    this.NombreLista = this.navParams.get('NombreLista');
    this.idLista = this.navParams.get('IdLista');
    console.log(this.VideosDeLista,this.VideosDeLista);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ViewListPage');
  }

  public goToEditList(){
    this.navCtrl.push(EditListPage);
  }

  presentAlert(title,subTitle) {
    let alert = this.alertCtrl.create({
      title: title,
      subTitle: subTitle
    });
    alert.present();
  }

  presentConfirm(title,message) {
    let alert = this.alertCtrl.create({
      title: title,
      message: message,
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Confirmar',
          handler: () => {
            console.log('delete clicked');
            this.confirmdeleteVideo();
          }
        }
      ]
    });
    alert.present();
  }

  public getAllVideos(){
    this.api.geta('playlist/getVideosFromPlaylist?lis_rep_id='+ this.idLista).subscribe((data) => { // Success
      console.log (data.json());

      if(data.json() == true){
        this.VideosDeLista = data.json();
      }
     
     
     },
     (error) =>{
       console.error(error);
     });
  }

  public confirmdeleteVideo(){

    this.api.geta('playlist/deleteVideoFromPlaylist?vid_id='+ this.idVideo
  +'&?lis_rep_id='+ this.idLista).subscribe((data) => { // Success
      console.log (data.json());
      if(data.json() == true){
        this.getAllVideos();
      }else if(data.json() == false){
        this.presentAlert("Ups","El video no pudo ser agregado a la lista");
       
      }
      
     },
     (error) =>{
       console.error(error);
     });

  }

  public deleteVideo(idVideo){
    console.log(idVideo);

    this.idVideo = idVideo;

    this.presentConfirm("Hey","Estas seguro de querer eliminar este video?");
  

    
  }

}
