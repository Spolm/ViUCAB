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
// analizar donde se va a colocar

  buscarQuery : string ='';

  items: any[];
  botones: any[];
  color: string ='primary';
  estadoSus:string ='Suscrito';
  suscrito:boolean = true;


  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
      this.initializeItems();

  }
// pendiente arreglar el metodo buscar lun 18/ dic/2017


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
           estado: this.estadoSus,
           flag: this.suscrito,
           img:'https://www.cstatic-images.com/car-pictures/xl/USC60CHT279E021001.png'
        },
           {
          nombre: 'Andy Gomez',
          suscritos: '133',
          color: this.color,
          estado: this.estadoSus,
          flag: this.suscrito,
          img:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeK0JpMddFw6P1hVBdjiQQuw7MpFnGza014TUmxfGfy4B9uYpa'
         },
        {
          nombre: 'Johan de Freitas',
          suscritos: '11212',
          color:this.color,
          estado: this.estadoSus,
          flag: this.suscrito,
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

showConfirm(usuarioSelected : any, idx : number){

      if(this.items[idx].flag)
      {
        let confirm = this.alertCtrl.create(
          {
            title: 'Cancelar suscripcion ?',
            message: 'Deseas cancelar la suscripcion a ' + usuarioSelected,
            buttons:
              [
                {
                  text: 'Cancelar',
                  handler: () => {
                    console.log('presiono no');
                    this.items[idx].color = 'primary';
                    this.estadoSus = 'Suscrito';
                    this.items[idx].estado = this.estadoSus
                  }

                },
                {    //this.verificarEstado(false,usuarioSelected);
                  text: 'Eliminar Suscripcion', // llamar a los metodos necesarios
                  handler: () => {
                    console.log('presiono si');
                    this.items[idx].color = 'claro';
                    this.estadoSus = 'Suscribirse';
                    this.items[idx].estado = this.estadoSus;

                  }
                }

              ]
          });
        confirm.present();
        // this.estadoNombre='Suscrito';
        this.items[idx].flag=false;
      }
      else
      {
        this.items[idx].color = 'primary';
        this.estadoSus = 'Suscrito';
        this.items[idx].estado = this.estadoSus;
        this.items[idx].flag=true;
      }
  }


  /**
   * Modulo 08 Suscripciones
   * @author Jesus Yepes
   * @date: 17/dic/2017 Domingo
   * @param {boolean} es: false= no elimina suscripcion; true = elimina suscripcion
   * @param {string} usuarioSeleccionado= canal del usuario seleccionado
   */
  verificarEstado(es :boolean, usuarioSeleccionado :string){

    if (es ==false)
    {
      console.log('probando  ' +es + usuarioSeleccionado.bold());


    }
    else if (es ==true)
    {
      console.log('probando ' +es + usuarioSeleccionado.bold());


//this.items.splice(idx,1);this.items[1]
    }
  }
}
