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
           nombre: "Jesus Yepes",
           suscritos: "12",
           color: this.color,
           estado: "Suscrito",
           img:'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg'
        },
        {
          nombre: "Andy Gomez",
          suscritos: "133",
          color: this.color,
          estado: "Suscrito",
          img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'
         },
        {
          nombre: "Johan de Freitas",
          suscritos: "11212",
          color:this.color,
          estado: "Suscrito",
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
