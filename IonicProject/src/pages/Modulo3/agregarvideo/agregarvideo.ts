import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { MediaCapture, MediaFile, CaptureError, CaptureImageOptions, CaptureVideoOptions } from '@ionic-native/media-capture';
import { InfocargarvideoPage } from '../infocargarvideo/infocargarvideo';
import { Camera, CameraOptions } from '@ionic-native/camera';

/**
 * Generated class for the AgregarvideoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-agregarvideo',
  templateUrl: 'agregarvideo.html',
})
export class AgregarvideoPage {

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              private camera: Camera,
              private mediaCapture: MediaCapture) {
  
  }

  imageUrl: string = '';
  cameraData: string;
  photoTaken: boolean;
  cameraUrl: string;
  photoSelected: boolean;

  startrecording() {
    let options: CaptureVideoOptions = { limit: 1 };
    this.mediaCapture.captureVideo(options).then(
      (data:MediaFile[]) => this.cargarVideo(),
      (err: CaptureError) => console.error(err)
    )
  }

    selectFromGallery() {
      var options = {
        sourceType: this.camera.PictureSourceType.PHOTOLIBRARY,
        destinationType: this.camera.DestinationType.DATA_URL,
        mediaType: this.camera.MediaType.VIDEO
      };
      this.camera.getPicture(options).then((imageData) => {
        this.cameraUrl = 'data:image/jpeg;base64,' + imageData;
        this.photoSelected = true;
        this.photoTaken = false;
        this.cargarVideo();
      }, (err) => {
        // Handle error
      });
    }
  

  cargarVideo(){
    this.navCtrl.push('InfocargarvideoPage');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AgregarvideoPage');
  }

  

}
