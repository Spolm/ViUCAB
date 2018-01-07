import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {RestApiService} from '../../app/rest-api.service';

/**
 * Generated class for the Modulo9Page page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-modulo9',
  templateUrl: 'modulo9.html',
  providers: [RestApiService]
})
export class Modulo9Page {
 usuario : String;
 categoria : String;
 listaVideo: Array<{}>;
  constructor(public navCtrl: NavController, public navParams: NavParams, public api: RestApiService ) {

    this.getVideosLike();
  }

  public getVideosLike(){
    this.usuario = "3";
    this.categoria = "Deporte";
    const url = "Sugerencias/get_sugerencias-likes?id="+this.usuario+"&categoria="+this.categoria;

    this.api.geta(url).subscribe((data)=>{this.listaVideo = data.json()
                                          console.log(this.listaVideo)},
                                        (error)=>{console.error(error)});
                                        
    //console.log(this.api.getTodo(url));

    //this.api.getTodo(url)
  }
  
  
  ionViewDidLoad() {
    console.log('ionViewDidLoad Modulo9Page');
    console.log(this.listaVideo);
  }

}
