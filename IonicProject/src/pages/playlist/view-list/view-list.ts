import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

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
})
export class ViewListPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  public ListaDeVideos = [
    { title: 'Video numero 1', plays: '133', duration: '30:00 min', img:'https://birdinflight.imgix.net/wp-content/uploads/2016/07/cassius-interactive-music-video_cover.jpg?auto=format&q=80&fit=crop&crop=faces&w=632'},
    { title: 'Video numero 2', plays: '32', duration: '3:00 min' , img:'http://assets7.capitalxtra.com/2017/42/krept-and-konan-ask-flipz-video-1508500206-list-handheld-0.png'},
    { title: 'Video numero 3', plays: '12', duration: '39:05 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRESg8T4eeKccQZTSsGLyFT7DZzWASx8TXiJzRLVtoxojdWB-Rb'},
  ];

  ionViewDidLoad() {
    console.log('ionViewDidLoad ViewListPage');
  }

}
