import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController, ActionSheetController} from 'ionic-angular';
import { HTTP } from '@ionic-native/http';

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
              public actionSheetCtrl: ActionSheetController,) {
  }
  idVideo0: string;
  idVideo1: string;
  items: any[];
  color: 'light';
  
  ngOnInit(): void {
    this.initializeItems();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListarmisvideosPage');
  }

  

  initializeItems() {
    {
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
    }
  }

  presentActionSheet() {
    let actionSheet = this.actionSheetCtrl.create({
      title: '',
      buttons: [
        {
          text: 'Editar',
          handler: () => {
            console.log('Destructive clicked');
          }
        },
        {
          text: this.idVideo1,
          role: 'destructive',
          handler: () => {
            //Llamada al ws para eliminar el videin
            console.log(this.idVideo1+' clicked');
          }
        },
        {
          text: 'Cancel',
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
      duration: 15000,
      position: 'bottom'
    });

    toast.onDidDismiss(() => {
      console.log('Dismissed toast');
    });

    toast.present();
  }

}
