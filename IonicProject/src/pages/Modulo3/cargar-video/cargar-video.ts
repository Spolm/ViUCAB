import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Platform, ActionSheetController, Loading } from 'ionic-angular';
import { LoadingController, ToastController } from 'ionic-angular';
import { FileTransfer, FileUploadOptions, FileTransferObject } from '@ionic-native/file-transfer';
import { FileChooser } from '@ionic-native/file-chooser';
import { File } from '@ionic-native/file';
import { Camera, CameraOptions } from '@ionic-native/camera';
import { RestApiService } from '../../../app/rest-api.service';
import { Headers } from '@angular/http/src/headers';
import { FilePath } from '@ionic-native/file-path';

/**
 * Generated class for the CargarVideoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-cargar-video',
  templateUrl: 'cargar-video.html',
  providers: [RestApiService]
})
export class CargarVideoPage {


  imageURL: any;
  myInput: string;
  cameraUrl: string;


  imageURI: any;
  imageFileName: any;

  constructor(public navCtrl: NavController,
    private transfer: FileTransfer,
    private file: File,
    private filePath: FilePath,
    private camera: Camera,
    private fileChooser: FileChooser,
    public platform: Platform,
    public actionSheetCtrl: ActionSheetController,
    public loadingCtrl: LoadingController,
    public toastCtrl: ToastController) { }

  takePhoto() {
    this.camera.getPicture().then((imageData) => {
      this.imageURL = imageData;
    }, (err) => {
      console.log(err);
    });
  }
  upload() {
    const fileTransfer: FileTransferObject = this.transfer.create();
    var options = {
      fileKey: 'file',
      fileName: 'filename.jpg',
      params: {}
    }
    fileTransfer.upload(this.imageURL, encodeURI("http://192.168.1.116:8080/viucab/Resources/uploadImage"), options)
      .then((data) => {
        // success
        alert("Image send:" + this.imageURL);
      }, (err) => {
        // error
        alert("err: " + JSON.stringify(err));
      })
  }


  /*image: string = null;
  cordova: any;
  lastImage: string = null;
  loading: Loading;

  nativepath: any;

  uploadfn() {
    this.fileChooser.open().then((url) => {
      (<any>window).FilePath.resolveNativePath(url, (result) => {
        this.nativepath = result;
        this.presentToast(this.nativepath);
        this.readimage();
      }
      )
    })
  }  

  readimage() {
    (<any>window).resolveLocalFileSystemURL(this.nativepath, (res) => {
      res.file((resFile) => {
        var reader = new FileReader();
        reader.readAsArrayBuffer(resFile);
        reader.onloadend = (evt: any) => {
          var imgBlob = new Blob([evt.target.result], { type: 'image/jpeg' });
          //do what you want to do with the file
        }
      })
    })
  }*/

/*public takePicture(sourceType){
  let options = {
    // Some common settings are 20, 50, and 100
    quality: 50,
    destinationType: this.camera.DestinationType.NATIVE_URI,
    // In this app, dynamically set the picture source, Camera or photo gallery
    sourceType: this.camera.PictureSourceType.SAVEDPHOTOALBUM,
    encodingType: this.camera.EncodingType.JPEG,
    mediaType: this.camera.MediaType.PICTURE,
    allowEdit: false,
    correctOrientation: false  //Corrects Android orientation quirks
  }*/

  /*this.camera.getPicture(options).then((imageData) => {
    // imageData is either a base64 encoded string or a file URI
    // If it's base64:
    this.image = imageData;
    this.presentToast(imageData);
  }, (err) => {
    // Handle error
    this.presentToast(err);
  });
}*/

  /*presentToast(msg) {
    let toast = this.toastCtrl.create({
      message: msg,
      duration: 2000,
      position: 'bottom'
    });

    toast.onDidDismiss(() => {
      console.log('Dismissed toast');
    });

    toast.present();
  }

  uploadFile() {
    const fileTransfer: FileTransferObject = this.transfer.create();

    let options: FileUploadOptions = {
      fileKey: 'ionicfile',
      fileName: 'ionicfile',
      httpMethod: "POST",
      chunkedMode: false,
      mimeType: "multipart/form-data",
      headers: {}
    }
    try {
      
    
    this.presentToast(this.nativepath);
    fileTransfer.upload(this.nativepath, 'http://192.168.1.116:8080/viucab/Resources/uploadImage', options)
      .then((data) => {
        console.log(data + " Uploaded Successfully");
        this.imageFileName = "foo"
        this.presentToast("Image uploaded successfully");
      }, (err) => {
        console.log(err);
        this.presentToast(err);
      });
    } catch (error) {
      this.presentToast(error);
    }
    //this.presentToast("despues de upload");
  }*/

/*
  public presentActionSheet() {
    let actionSheet = this.actionSheetCtrl.create({
      title: 'Select Image Source',
      buttons: [
        {
          text: 'Load from Library',
          handler: () => {
            this.takePicture(this.camera.PictureSourceType.PHOTOLIBRARY);
          }
        },
        {
          text: 'Use Camera',
          handler: () => {
            this.takePicture(this.camera.PictureSourceType.CAMERA);
          }
        },
        {
          text: 'Cancel',
          role: 'cancel'
        }
      ]
    });
    actionSheet.present();
  }

  public takePicture(sourceType) {
    // Create options for the Camera Dialog
    var options = {
      quality: 100,
      sourceType: sourceType,
      saveToPhotoAlbum: false,
      correctOrientation: true
    };

    // Get the data of an image
    this.camera.getPicture(options).then((imagePath) => {
      // Special handling for Android library
      if (this.platform.is('android') && sourceType === this.camera.PictureSourceType.PHOTOLIBRARY) {
        this.filePath.resolveNativePath(imagePath)
          .then(filePath => {
            let correctPath = filePath.substr(0, filePath.lastIndexOf('/') + 1);
            let currentName = imagePath.substring(imagePath.lastIndexOf('/') + 1, imagePath.lastIndexOf('?'));
            this.copyFileToLocalDir(correctPath, currentName, this.createFileName());
          });
      } else {
        var currentName = imagePath.substr(imagePath.lastIndexOf('/') + 1);
        var correctPath = imagePath.substr(0, imagePath.lastIndexOf('/') + 1);
        this.copyFileToLocalDir(correctPath, currentName, this.createFileName());
      }
    }, (err) => {
      this.presentToast('Error while selecting image.');
    });
  }

  private createFileName() {
    var d = new Date(),
      n = d.getTime(),
      newFileName = n + ".jpg";
    return newFileName;
  }

  // Copy the image to a local folder
  private copyFileToLocalDir(namePath, currentName, newFileName) {
    this.file.copyFile(namePath, currentName, this.cordova.file.dataDirectory, newFileName).then(success => {
      this.lastImage = newFileName;
    }, error => {
      this.presentToast('Error while storing file.');
    });
  }

  private presentToast(text) {
    let toast = this.toastCtrl.create({
      message: text,
      duration: 3000,
      position: 'top'
    });
    toast.present();
  }

  // Always get the accurate path to your apps folder
  public pathForImage(img) {
    if (img === null) {
      return '';
    } else {
      return this.cordova.file.dataDirectory + img;
    }
  }

  public uploadImage() {
    // Destination URL
    var url = "http://192.168.1.116:8080/viucab/Resources/uploadImage";

    // File for Upload
    var targetPath = this.pathForImage(this.lastImage);

    // File name only
    var filename = this.lastImage;

    var options = {
      fileKey: "file",
      fileName: filename,
      chunkedMode: false,
      httpMethod: "POST",
      mimeType: "multipart/form-data",
      params: { 'fileName': filename }
    };

    const fileTransfer: FileTransferObject = this.transfer.create();

    this.loading = this.loadingCtrl.create({
      content: 'Uploading...',
    });
    this.loading.present();

    // Use the FileTransfer to upload the image
    fileTransfer.upload(targetPath, url, options).then(data => {
      this.loading.dismissAll()
      this.presentToast('Image succesful uploaded.');
    }, err => {
      this.loading.dismissAll()
      this.presentToast('Error while uploading file.');
    });
  }*/


  /*ionViewDidLoad() {
    console.log('ionViewDidLoad InfovideoPage');
  }

  getPicture() {
    let options: CameraOptions = {
      destinationType: this.camera.DestinationType.DATA_URL,
      targetWidth: 1000,
      targetHeight: 1000,
      quality: 100
    }
    this.camera.getPicture(options)
      .then(imageData => {
        this.image = `data:image/jpeg;base64,${imageData}`;
      })
      .catch(error => {
        console.error(error);
      });
    
  }*/


  /*getImage() {
    const options: CameraOptions = {
      quality: 100,
      destinationType: this.camera.DestinationType.FILE_URI,
      sourceType: this.camera.PictureSourceType.PHOTOLIBRARY
    }

    this.camera.getPicture(options).then((imageData) => {
      this.imageURI = imageData;
      this.presentToast(imageData);
    }, (err) => {
      console.log(err);
      this.presentToast(err);
    });
  }*/

  /*uploadFile() {
    let loader = this.loadingCtrl.create({
      content: "Uploading..."
    });
    loader.present();
    const fileTransfer: FileTransferObject = this.transfer.create();

    let options: FileUploadOptions = {
      fileKey: 'ionicfile',
      fileName: 'ionicfile',
      chunkedMode: false,
      mimeType: "image/jpeg",
      headers: {}
    }
    this.presentToast(this.image);
    fileTransfer.upload(this.image, 'http://192.168.1.116:8080/viucab/Resources/uploadImage', options)
      .then((data) => {
        console.log(data + " Uploaded Successfully");
        this.imageFileName = "foo"
        loader.dismiss();
        this.presentToast("Image uploaded successfully");
      }, (err) => {
        console.log(err);
        loader.dismiss();
        this.presentToast(err);
      });
  }

  presentToast(msg) {
    let toast = this.toastCtrl.create({
      message: msg,
      duration: 10000,
      position: 'bottom'
    });

    toast.onDidDismiss(() => {
      console.log('Dismissed toast');
    });

    toast.present();
  }*/


/*

  datos: any;
  respu: any;
  imageURI: any;
  imageFileName: any;

  constructor(public navCtrl: NavController,
    private transfer: FileTransfer,
    private file: File,
    private camera: Camera,
    public loadingCtrl: LoadingController,
    public toastCtrl: ToastController,
    public api: RestApiService) { }

  fileTransfer: FileTransferObject = this.transfer.create();

  getImage() {
    const options: CameraOptions = {
      quality: 100,
      destinationType: this.camera.DestinationType.FILE_URI,
      sourceType: this.camera.PictureSourceType.PHOTOLIBRARY
    }

    this.camera.getPicture(options).then((imageData) => {
      this.imageURI = imageData;
    }, (err) => {
      console.log(err);
      this.presentToast(err);
    });
  }
  

  uploadFile() {

    /*let headers = new Headers({ 'Content-Type': 'multipart/form-data' });
    let param: FileUploadOptions = {
      fileKey: 'ionicfile',
      fileName: 'ionicfile',
      httpMethod: "PUT",
      chunkedMode: false,
      mimeType: "multipart/form-data",
      headers: {}
    }
    this.api.putTodo('Resources/uploadImage',this.imageURI, param).subscribe((data) => { // Success
      this.respu = data.json()
      this.presentToast(this.respu);
      console.log(this.respu)
    },
      (error) => {
        this.presentToast(error);
        console.error(error);
      });*/

    /*let loader = this.loadingCtrl.create({
      content: "Uploading..."
    });
    loader.present();
    
    let options: FileUploadOptions = {
      fileKey: 'ionicfile',
      fileName: 'ionicfile',
      httpMethod: "GET",
      chunkedMode: false,
      mimeType: "multipart/form-data",
      headers: {}
    }

    //this.presentToast("Antes de upload");
    fileTransfer.upload(this.imageURI, 'http://192.168.1.116:8080/viucab/Resources/uploadImage', options)
      .then((data) => {
        console.log(data + " Uploaded Successfully");
        this.imageFileName = "foo"
        //loader.dismiss();
        this.presentToast("Image uploaded successfully");
      }, (err) => {
        console.log(err);
        //loader.dismiss();
        this.presentToast(err);
      });
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

  ionViewDidLoad() {
    console.log('ionViewDidLoad CargarVideoPage');
  }
*/
}
