import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ActionSheetController, ToastController } from 'ionic-angular';
import { Camera, CameraOptions } from '@ionic-native/camera';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

/**
 * Generated class for the InfovideoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-infovideo',
  templateUrl: 'infovideo.html',
})
export class InfovideoPage {

  URL = 'http://192.168.1.116:8080/';
  items: any[];
  image: string = null;

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              private camera: Camera,
              public actionSheetCtrl: ActionSheetController,
              public httpClient: HttpClient,
              public toastCtrl: ToastController) {
  }

  obs: Observable<any>;
  id: string;
  titulo: string;
  descripcion: string;
  imagen: string;
  update = {
    titulo: '',
    descripcion: ''
  };
  ngOnInit(): void {
    this.initializeItems();
  }

  initializeItems(){
    this.items = [{
      _id: this.navParams.get('_id'),
      _titulo: this.navParams.get('_titulo'),
      _descripcion: this.navParams.get('_descripcion'),
      _imagen: this.navParams.get('_imagen'),
    }];  
    this.update.titulo = this.navParams.get('_titulo');
    this.update.descripcion = this.navParams.get('_descripcion');
  }

  updateVideo(){
    this.id = this.items[0]._id;
    this.titulo = this.update.titulo;
    this.descripcion = this.descripcion;
    this.imagen = this.items[0]._imagen;
    this.obs = this.httpClient.get('http://192.168.1.116:8080/viucab/Video/update?titulo=' + this.update.titulo + '&descripcion=' + this.update.descripcion + '&videoId=' + this.id);
    this.obs
      .subscribe(data => {
        if (data = 1) {
          this.presentToast("Video modificado exitosamente");
          this.navCtrl.pop();
        }else
          this.presentToast("Error al modificar video");
        console.log('my data: ', data);
      })
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InfovideoPage');
  }

  presentToast(msg) {
    let toast = this.toastCtrl.create({
      message: msg,
      duration: 3000,
      position: 'bottom'
    });

    toast.onDidDismiss(() => {
      console.log('Dismissed toast');
    });

    toast.present();
  }
  

}
