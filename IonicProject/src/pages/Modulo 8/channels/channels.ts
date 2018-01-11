import { Component , ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams , AlertController} from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';
import { Refresher } from 'ionic-angular/components/refresher/refresher';
import { Content } from 'ionic-angular';
import { NullAstVisitor } from '@angular/compiler';

/**
 * Generated class for the ChannelsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
export interface SusAuxInterface {
  idUsuario: number;
  nombreUsuario: number;
  estado: string;
  cantidadSus: number;
}

  
  
  

@IonicPage()
@Component({
  selector: 'page-channels',
  templateUrl: 'channels.html',
  providers: [RestApiService]
})
export class ChannelsPage {
// analizar donde se va a colocar
@ViewChild(Content) content: Content;
  buscarQuery : string ='';
  listaSuscripcion: Array<{}>;
  listaUsuarios : Array<{}>;
  mostrarUsuarios : boolean;
  mostrarSuscripciones : boolean;  
  items: any[];
  itemsAux : SusAuxInterface [];
  botones: any[];
  color: string ='primary';
  estadoSus:string ='Suscrito';
  suscrito:boolean = true;
  respu : any;
  idUser : number = 1;

  //arreglo :Array<{_id_user: number,_name_user:string,_user_token:boolean}>;

  @ViewChild('NAV')nav : NavController;
  constructor(public navCtrl: NavController, 
              public navParams: NavParams, 
              public alertCtrl: AlertController,
              public api : RestApiService) {

      this.prue();
      
    //  this.cargarUsuarios(); //---------------------------probando
  }
// pendiente arreglar el metodo buscar lun 18/ dic/2017


// realizacion de busqueda mediante arreglos
  ionViewDidLoad() {
    console.log('ionViewDidLoad ChannelsPage');
    this.prue();
    this.cargarUsuarios();
 
  }
/**
 *  metodo que carga a lista de usuarios suscritos
 *
 */
  public prue ()
  {
      this.estadoSus ='Suscrito';
      this.mostrarSuscripciones=true;
      this.mostrarUsuarios =false;
      this.api.geta('Suscripcion/GetSuscripcion?id='+ this.idUser)
     /* .subscribe( response => {
        this.listaSuscripcion = response;
        console.log(this.listaSuscripcion);
    })*/

      .subscribe((data) => { // Success
          this.listaSuscripcion = data.json()
          console.log (this.listaSuscripcion)
         },
         (error) =>{
           console.error(error);
         });

  }
  public borrar (idSuscriptor: number)
  {
      this.api.deleteSus('Suscripcion/UpdateSuscripcion?idLogueado='+this.idUser+'&idSuscriptor='+idSuscriptor)
  
      .subscribe((data) => { // Success
              
         },
         (error) =>{
           console.error(error);
         });

  }

  //---------------------------- 4/ 01/2018 -----------

  public cargarUsuarios ()
  {
    
    this.mostrarSuscripciones=true;
    this.mostrarUsuarios =false;
    this.api.geta('Suscripcion/GetUsuarios')

      .subscribe((data) => { // Success
          this.listaUsuarios = data.json()
          console.log (this.listaUsuarios)
         },
         (error) =>{
           console.error(error);
         });
         this.estadoSus ='Suscrito';
  }
 //---------------------------------------------------------------
 /**
  * @author Modulo 08
  * @param refresher :
  *  8/ene/2018
  */
 doRefresh(refresher) {
  console.log('Begin async operation', refresher);
  

  setTimeout(() => {
    console.log('Async operation has ended');
    refresher.complete();
    this.prue();
  }, 1500);
}


  
  //-------------------------------------------------------------------------------------------------

  // pendiente por arreglar
  getItems1(ev: any){
    this.estadoSus ='Suscribirse';
    //Reset items back to all of the items
   // this.initializeItems();
   this.mostrarSuscripciones=false;
    this.mostrarUsuarios =true;
   this.items = this.listaUsuarios;
   // this.prue();
   
    let i :number;
    console.log('hola');
    console.log(this.listaUsuarios);
        // set val to the value of the searchbar
        let val = ev.target.value;
        console.log(val);
     
          if (val && val.trim() != '') {
            this.items = this.items.filter((item) => {
              return (item._name_user.toLowerCase().indexOf(val.toLowerCase()) > -1);
            })
          this.listaUsuarios = this.items;
          console.log('chao ');
          console.log(this.listaUsuarios);
          
        }
        else {this.cargarUsuarios();}
        
  }

  //------------------------------------------------------------------------------------------------


// Realizacion del mensaje de confirmacion 19/dic/2017

//showConfirm(usuarioSelected : any,idx : number){
  /**
   * 
   * @param nombreSelected 
   * @param idSuscriptor 
   */
  showConfirm(nombreSelected : string, idSuscriptor :number , idx : number){
     // if(this.items[idx].flag)
     // {
        let confirm = this.alertCtrl.create(
          {
            title: 'Cancelar suscripcion ?',
            message: 'Deseas cancelar la suscripcion a ' + nombreSelected,
            buttons:
              [
                {
                  text: 'Cancelar',
                  handler: () => {
                    console.log('presiono no');
                   // console.log(idx);
                    //this.items[idx].color = 'primary';
                  
                    this.estadoSus = 'Suscrito';
                    //this.items[idx].estado = this.estadoSus
                  }

                },
                {    //this.verificarEstado(false,usuarioSelected);
                  text: 'Eliminar Suscripcion', // llamar a los metodos necesarios
                  handler: () => {
                  this.borrar(idSuscriptor);
                  console.log('presiono si suscripcion cancelada');
                  this.listaSuscripcion.splice(idx,1);
                   // console.log(idx);
                   // this.items[idx].color = 'claro';
                    //this.estadoSus = 'Suscribirse';
                   // this.items[idx].estado = this.estadoSus;

                  }
                }

              ]
          });
        confirm.present();

    console.log(idx);
   
  }

//--------------------------------------------------------------------------
/**
 * 
 * @param nombreSelected 
 * @param idSuscriptor 
 * @param idx 
 */
showAlert(nombreSelected : string, idSuscriptor :number , idx : number){
    let alert = this.alertCtrl.create({
    title: 'Suscripcion Realizada! ',
    subTitle: 'Usted se ha suscrito al canal de '+ nombreSelected + '. Presione OK para Continuar',
    buttons: ['OK']
  });
  this.suscribirUsuario(this.idUser,idSuscriptor);
  this.listaUsuarios.splice(idx,1); //elimina el usuario de la lista
  alert.present();
}
// ---------------------------------------------------------------------------
/**
 * Pendiente cambiar get por put o post ---------------******** en la ws tambn
 * @param usuarioLogueado 
 * @param usuarioCanal 
 */
suscribirUsuario(usuarioLogueado : number, usuarioCanal :number){
      this.api.geta('Suscripcion/SetSuscripcion?idLogueado='+usuarioLogueado+'&idSuscriptor='+usuarioCanal)     
     //this.api.putUno('Suscripcion','SetSuscripcion?idLogueado='+usuarioLogueado+'&idSuscriptor='+usuarioCanal,null,NullAstVisitor)  
     .subscribe((data) => { // Success
              
      },
      (error) =>{
        console.error(error);
      });
        
}


}
