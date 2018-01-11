import { Component } from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {RestApiService} from "../../../app/rest-api.service";
import { AlertController } from 'ionic-angular';
import { Events } from 'ionic-angular';

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


  respu : any;
  public Lista:any;
  public nombreLista:any;
  public descripcionLista:any;

  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public api : RestApiService,
              private alertCtrl: AlertController,
            public events: Events) {
                this.Lista = this.navParams.get('ListaEdit');
              console.log(this.Lista);
                this.nombreLista = this.Lista.nombre;
                this.descripcionLista = this.Lista.descripcion;

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EditListPage');
    
  }
/*
  presentAlert(title,subTitle) {
    let alert = this.alertCtrl.create({
      title: title,
      subTitle: subTitle
    });
    alert.present();
  }*/

  guardarLista(){

    this.api.geta('playlist/editPlaylist?lis_rep_id='+ this.Lista.idLista+'&lis_rep_nombre='+this.nombreLista+
    '&lis_rep_descripcion='+this.descripcionLista+'&list_rep_img='+this.Lista.urlImg).subscribe((data) => { // Success
      console.log (data.json());

      if(data.json() == true){
       // this.presentAlert("Exito","Lista editada");
       this.events.publish('reloadPlaylists');
       this.navCtrl.pop();

      }
     },
     (error) =>{
       console.error(error);
     });

  }

  

}
