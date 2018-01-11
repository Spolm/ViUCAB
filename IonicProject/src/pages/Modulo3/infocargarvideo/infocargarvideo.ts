import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController, ActionSheetController } from 'ionic-angular';
import { Camera, CameraOptions } from '@ionic-native/camera';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
/**
 * Generated class for the InfocargarvideoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-infocargarvideo',
  templateUrl: 'infocargarvideo.html',
})
export class InfocargarvideoPage {

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              private camera: Camera,
              public toastCtrl: ToastController,
              public http: Http,
              public actionSheetCtrl: ActionSheetController) {
  }

  imageUrl: string='';
  cameraData: string;
  photoTaken: boolean;
  cameraUrl: string;
  photoSelected: boolean;

  /*tomarFoto(){
    this.camera.getPicture(this.options).then((imageData) => {
      // imageData is either a base64 encoded string or a file URI
      // If it's base64:
      this.imageUrl=imageData;
      this.presentToast(this.imageUrl);
      let base64Image = 'data:image/jpeg;base64,' + imageData;
    }, (err) => {
      // Handle error
    });
  }*/

  uploadImagen() {
    var fd = new FormData();
    fd.append('titulo', "titulo");
    fd.append('data',this.cameraData);
    let reqOpt;
    let headers = new Headers();
    headers.append('content-type', 'multipart/form-data');
    reqOpt = new RequestOptions({
      headers: headers
    });
    let data = {
      titulo: "la senora verga de triana",
      /*descripcion: "penetones",
      oldImgUrl: "ooolaksjdo",
      videoId: "42",
      file: null,*/
    };
    this.presentToast("antes");
    this.http.post("http://192.168.1.116:8080/viucab/Resources/test", fd, reqOpt).subscribe(data => {
      console.log(data);
      //this.presentToast(JSON.stringify(data.json()));
    }, error => {
      console.log(error);
      //this.presentToast(JSON.stringify(error.json()));
    });
  }

  openCamera(){
    var options: CameraOptions = {
      sourceType: this.camera.PictureSourceType.CAMERA,
      destinationType: this.camera.DestinationType.DATA_URL
    };
    this.camera.getPicture(options).then((imageData) => {
      this.cameraData = 'data:image/jpeg;base64,' + imageData;
      this.photoTaken = true;
      this.photoSelected = false;
    }, (err) => {
      // Handle error
    });
  }

  selectFromGallery() {
    var options = {
      sourceType: this.camera.PictureSourceType.PHOTOLIBRARY,
      destinationType: this.camera.DestinationType.DATA_URL
    };
    this.camera.getPicture(options).then((imageData) => {
      this.cameraUrl = 'data:image/jpeg;base64,' + imageData;
      this.photoSelected = true;
      this.photoTaken = false;
    }, (err) => {
      // Handle error
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InfocargarvideoPage');
  }

  presentActionSheet() {
    let actionSheet = this.actionSheetCtrl.create({
      title: '',
      buttons: [
        {
          text: 'Tomar Foto',
          handler: () => {
            //Editar el video
            this.openCamera();
            console.log('Destructive clicked');
          }
        },
        {
          text: 'Elegir Foto',
          handler: () => {
            this.selectFromGallery();
            console.log(' clicked');
          }
        },
        {
          text: 'Cancelar',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        }
      ]
    });

    actionSheet.present();
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
