import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, ActionSheetController, ToastController } from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';
import { Subscription } from 'rxjs/Subscription';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Http, Headers, Response } from '@angular/http';
import { RequestOptions } from '@angular/http/src/base_request_options';
import { HTTP } from '@ionic-native/http';


/**
 * Generated class for the MisVideosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-mis-videos',
    templateUrl: 'mis-videos.html',
    providers: [RestApiService]
})
export class MisVideosPage {

  apix: RestApiService;
  form: FormData;
  films: Observable<any>;
  json: any;
  data: any;
  buscarQuery: string = '';
  items: any[];
  color: 'light';
  estadoNombre: string;
  errorMessage = '';
  subscription: Subscription;

  @ViewChild('myNav') nav: NavController
  constructor(public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public actionSheetCtrl: ActionSheetController,
    public api: RestApiService,
    public toastCtrl: ToastController,
    public httpClient: HttpClient,
    public http: Http) {
    //this.presentToast("antes llamada");
    /*this.subscription = this.api.getVideos('Video/getAll?userId=1')
      .subscribe(this.data,
      error => this.errorMessage = error);
    this.errorMessage = '';
    this.presentToast(this.data);*/
    /*this.api.getVideos('Video/getAll?userId=1').subscribe((data) => {
    
    this.items.push(data);
    });*/
    //this.presentToast("Depsues llamada"+this.items[0]);
    //this.initializeItems();
  }

  ngOnInit(): void {
    this.initializeItems();
  }

  /*
      _titulo: '',
        _descripcion: '',
        _id: '0',
        _imagen: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa',
        _url: '',
        _fecha: '',
        _visitas: ''
  */

  presionado(){
    this.films = this.httpClient.get('http://192.168.1.116:8080/viucab/Video/getAll?userId=1');
    this.films
      .subscribe(data => {
        console.log('my data: ', data);
        this.items = data;
        this.presentToast(this.items[0]['_id']);
      })
  }

  updateImagen(){
    
    let headers = new Headers(); 
    headers.append("Accept", 'application/json');
    headers.append('content-type', 'application/json');
    let data = {
      titulo: "la senora verga de triana",
      descripcion: "penetones",
      oldImgUrl: "ooolaksjdo",
      videoId: "42",
       };
    this.presentToast("antes");
    this.http.post("http://192.168.1.116:8080/viucab/Video", JSON.stringify(data)).subscribe(data => {
      console.log(JSON.stringify(data.json()));
      this.presentToast(JSON.stringify(data.json()));
    }, error => {
      console.log(JSON.stringify(error.json()));
      this.presentToast(JSON.stringify(error.json()));
    });
  }
    
    
    /*this.presentToast("entro");
    let data = {
        "titulo": "la senora verga de triana",
        "descripcion": "penetones",
        "oldImgUrl":"ooolaksjdo",
        "videoId": "42",
    }
    this.json = this.apix.postTodovid('http://192.168.1.116:8080/viucab/Video',data,'');
    this.presentToast(this.json);
    //let files = event.srcElement.files;
    //this.form.append("0",files,"imagen.jpg");
    //this.form.append("data", JSON.stringify(data));
    /*this.form.append('titulo',"la senora verga de triana");
    this.form.append('descripcion',"penetones");
    this.form.append('oldImgUrl',"ooolaksjdo");
    this.form.append('videoId',"42");*/
    //this.form.append('data', JSON.stringify(data));
    //this.presentToast("prepeticion");
    //this.httpClient.post('http://192.168.1.116:8080/viucab/Video', JSON.stringify(data)).map(res => res).subscribe(data => {
      //this.presentToast("respuesta" + data);
    //});
    //this.httpClient.post("http://192.168.1.116:8080/viucab/Video", this.form).subscribe(
      //(r) => { this.presentToast("respuesta"+r) }
    //)*/
  

  initializeItems() {
    {
      this.items = [{
        nombre: 'Marty',
        suscritos: '133',
        color: this.color,
        estado: 'Suscrito',
        img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'
      },
      {
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
          text: 'idVideo',
          role: 'destructive',
          handler: () => {
            //Llamada al ws para eliminar el videin
            console.log('Archive clicked');
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

  ionViewDidLoad() {
    console.log('ionViewDidLoad MisVideosPage');
  }

}
