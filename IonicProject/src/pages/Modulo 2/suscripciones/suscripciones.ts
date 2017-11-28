import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, PopoverController } from 'ionic-angular';

/**
 * Generated class for the SuscripcionesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-suscripciones',
  templateUrl: 'suscripciones.html',
})
export class SuscripcionesPage {

  constructor(public navCtrl: NavController, public navParams: NavParams,public popoverCtrl: PopoverController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SuscripcionesPage');
  }
/*
  presentPopover(myEvent) {
    let popover = this.popoverCtrl.create(PopOverListasReproduccionPage);
    popover.present({
      ev: myEvent
    });
  }*/

  public ListasSuscripciones = [
    { title: 'Nombre del Canal 1', usuario: 'nombre usuario 1',  img:'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg'},
    { title: 'Nombre del Canal 2', usuario: 'nombre usuario 2',  img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho'},
    { title: 'Nombre del Canal 3', usuario: 'nombre usuario 3',  img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROn3JsAL3c9cfHJhmhtQ-rI4coQA2C26K8VdWK6zxI9b26IJlZ'},
  ];

}
