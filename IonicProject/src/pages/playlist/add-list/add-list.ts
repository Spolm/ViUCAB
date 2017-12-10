import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { CreateNewListPage } from '../create-new-list/create-new-list';
// import { AlertController } from 'ionic-angular';

/**
 * Generated class for the AddListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-add-list',
  templateUrl: 'add-list.html',
})
export class AddListPage {

  constructor(public navCtrl: NavController, public navParams: NavParams/*  , public alertCtrl: AlertController*/) {
  }


  ionViewDidLoad() {
    console.log('ionViewDidLoad AddListPage');
  }

  public ListasDeReproduccion = [
    { title: 'Lista numero 1', amount: '13', duration: '30:00 min', img:'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg'},
    { title: 'Lista numero 2', amount: '3', duration: '3:00 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
    { title: 'Lista numero 3', amount: '1', duration: '39:05 min' , img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
  ];


  /*  showAddListPrompt() {
    let prompt = this.alertCtrl.create({
      title: 'Crear Lista',
      message: "Introduzca datos de la Lista a crear",
      inputs: [
        {
          name: 'title',
          placeholder: 'Titulo'
        },
        {
          name: 'description',
          placeholder: 'Descripcion'
        }
      ],

      buttons: [
        {
          text: 'Cancel',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Save',
          handler: data => {
            console.log('Saved clicked');
          }
        }
      ]
    });
    prompt.present();
  }*/

  public goToCreateNewList(){
    this.navCtrl.push(CreateNewListPage);
  }

}
