import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController, ActionSheetController} from 'ionic-angular';
import { HTTP } from '@ionic-native/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { InfovideoPage } from '../infovideo/infovideo';

/**
 * Generated class for the ListarmisvideosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-listarmisvideos',
  templateUrl: 'listarmisvideos.html',
})
export class ListarmisvideosPage {

  constructor(public navCtrl: NavController, 
              public toastCtrl: ToastController,
              public navParams: NavParams, 
              private http: HTTP,
              public actionSheetCtrl: ActionSheetController,
              public httpClient: HttpClient) {
  }
  URL = 'http://192.168.1.116:8080/';
  obs: Observable<any>;
  index: string;
  idVideo: string;
  items: any[];
  color: 'light';
  
  ngOnInit(): void {
    this.initializeItems();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListarmisvideosPage');
  }

  

  initializeItems() {
    this.obs = this.httpClient.get('http://192.168.1.116:8080/viucab/Video/getAll?userId=2');
    this.obs
      .subscribe(data => {
        console.log('my data: ', data);
        this.items = data;
      })

    //DATOS PRUEBA LOCAL
    /*{
      this.items = [{
        id: '0',
        nombre: 'Marty',
        suscritos: '133',
        color: this.color,
        estado: 'Suscrito',
        img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'
      },
      {
        id: '1',
        nombre: 'Martin',
        suscritos: '133',
        color: this.color,
        estado: 'Suscrito',
        img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'
      }]
    }*/
  }

  presentActionSheet(index) {
    let actionSheet = this.actionSheetCtrl.create({
      title: '',
      buttons: [
        {
          text: 'Editar',
          handler: () => {
            //Editar el video
            this.navCtrl.push('InfovideoPage',this.items[index]);
            console.log('Destructive clicked');
          }
        },
        {
          text: 'Eliminar',
          role: 'destructive',
          handler: () => {
            this.deleteVideo(this.items[index]._id);
            console.log(index+' clicked');
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


  deleteVideo(id){
    this.obs = this.httpClient.delete('http://192.168.1.116:8080/viucab/Video?videoId='+id);
    this.obs
      .subscribe(data => {
        if (data == 0) {
          this.presentToast("Video eliminado exitosamente");
          this.initializeItems();  
        }else{
          this.presentToast("Error eliminando video");
        }
        console.log('my data: ', data);
      })
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
