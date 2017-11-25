import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams , AlertController} from 'ionic-angular';
/**
 * Generated class for the ChannelsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-channels',
  templateUrl: 'channels.html',
})
export class ChannelsPage {

  buscarQuery : string ='';
  
  items: any[];
  color: 'secondary';
  estadoNombre:string;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
      this.initializeItems();
    
  }



// realizacion de busqueda mediante arreglos
  ionViewDidLoad() {
    console.log('ionViewDidLoad ChannelsPage');
  }

  initializeItems(){
     // this.items = [
      
       this.items =[
        {
           nombre: 'Jesus Yepes',
           suscritos: '12',
           color: this.color,
           estado: 'Suscrito',
           img:'data:image/jpeg;base64,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'
        },
           {
          nombre: 'Andy Gomez',
          suscritos: '133',
          color: this.color,
          estado: 'Suscrito',
          img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'
         },
        {
          nombre: 'Johan de Freitas',
          suscritos: '11212',
          color:this.color,
          estado: 'Suscrito',
          img:'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg'
        },
      ]
  }

  getItems(ev: any){
    //Reset items back to all of the items
    this.initializeItems();
    
        // set val to the value of the searchbar
        let val = ev.target.value;
    
        // if the value is an empty string don't filter the items
        if (val && val.trim() != '') {
          this.items = this.items.filter((item) => {
            return (item.nombre.toLowerCase().indexOf(val.toLowerCase()) > -1);
          })
        }
  }

// Realizacion del mensaje de confirmacion

showConfirm(){
     
      let confirm = this.alertCtrl.create(
        {
            title: 'Cancelar suscripcion ?',
            message: 'Esta seguro de cancelar la suscripcion ',
            buttons: 
            [
                {
                    text: 'Cancelar',
                    handler: () => {console.log('presiono si');  }
                    
                },
                {
                    text: 'Cancelar Suscripcion',
                    handler: () => {console.log('presiono no'); }
                }

            ]
        });
      confirm.present();
      this.estadoNombre='Suscrito';
  }
  activarColor(color:string){
    return color;
  }
}
