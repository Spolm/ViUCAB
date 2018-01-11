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
  mostrarUsuarios : boolean; // bandera que muestra o no en el html la lista de usuarios
  mostrarSuscripciones : boolean;  // bandera que muestra o no en el html la lista de suscripciones
  items: any[];
  botones: any[];
  color: string ='primary';
  estadoSus:string ='Suscrito';
  suscrito:boolean = true;
  respu : any;
  idUser : number = 1; // usuario cableado con id =1

  //arreglo :Array<{_id_user: number,_name_user:string,_user_token:boolean}>;

  @ViewChild('NAV')nav : NavController;
  constructor(public navCtrl: NavController, 
              public navParams: NavParams, 
              public alertCtrl: AlertController,
              public api : RestApiService) {

      this.cargarSuscripciones(); // metodo que llena la lista de suscripciones 
      
    //  this.cargarUsuarios(); //---------------------------probando
  }

/**
 * Metodo que inicializa las dos listas de usuarios 
 * @author : Modulo 08
 * modificado el dia 8/enne/2018
 */
  ionViewDidLoad() {
    console.log('ionViewDidLoad ChannelsPage');
    this.cargarSuscripciones();
    this.cargarUsuarios();
 
  }
/**
 *  metodo que carga a lista de usuarios suscritos
 *
 */
  public cargarSuscripciones ()
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
  /**
   * 
   * @param idSuscriptor : recibe el idi del usuario del acan en la cual se quiere desuscribir
   * @author Modulo 08
   */
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
/**
 * Llena la lista de usuario para mostrarlos en la lista
 * solo muestra los usuarios registrados en el sistema
 * con la condicion que aparece solo los usuarios no suscritos al usuario logueado
 * ni el usuario logueado
 * @author : Jesus Yepes
 */
  public cargarUsuarios ()
  {
    
    this.mostrarSuscripciones=true;
    this.mostrarUsuarios =false;
    this.api.geta('Suscripcion/GetUsuarios?id='+this.idUser)

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
  *  Actualiza la vista
  */
 doRefresh(refresher) {
  console.log('Begin async operation', refresher);
    setTimeout(() => {
    console.log('Async operation has ended');
    refresher.complete();
    this.cargarSuscripciones();
  }, 1500); // tarda en actualizar 1.5 segundos
}


  //-------------------------------------------------------------------------------------------------
/**
 * @author Modulo 08
 * metodo que es llamado por el buscador a traves del evento de entrada
 * que busca los usuarios en el sistema, por medio de la lista de usuarios
 */

  getItems1(ev: any){
    this.estadoSus ='Suscribirse';
    //Reset items back to all of the items
   // this.initializeItems();
   this.mostrarSuscripciones=false;
    this.mostrarUsuarios =true;
   this.items = this.listaUsuarios;
   // this.cargarSuscripciones();
   
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


 /**
  * @author  modulo 08
  * @param nombreSelected : nombre del canal seleccionaddo 
  * @param idSuscriptor :  id del usuario canal del usuario seleccionado
  * @param idx : indice que indica la posicion de la lista en la que se encuentra
    el elemento seleccionado
    
  */
  showConfirm(nombreSelected : string, idSuscriptor :number , idx : number){
   
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
                    this.estadoSus = 'Suscrito';

                  }

                },
                {    
                  text: 'Eliminar Suscripcion', // llamar a los metodos necesarios
                  handler: () => {
                  this.borrar(idSuscriptor);
                  console.log('presiono si suscripcion cancelada');
                  this.listaSuscripcion.splice(idx,1);
                  
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
 * @param nombreSelected nombre del usuario seleccionado para mostrarlo en pantalla
 * @param idSuscriptor : id del usuario selecccionado a suscribir
 * @param idx : indice que indica la posiicion del usuario en la lista para borrarlo de la lista de usuarios
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
 * @author Modulo 08
 * @param usuarioLogueado 
 * @param usuarioCanal : id del usuario a suscribir
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
