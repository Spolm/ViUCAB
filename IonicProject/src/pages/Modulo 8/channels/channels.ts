import { Component , ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams , AlertController} from 'ionic-angular';
import { RestApiService } from '../../../app/rest-api.service';


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

  buscarQuery : string ='';
  listaSuscripcion: Array<{}>;
  
  items: any[];
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
      //this.initializeItems();
      this.prue();
  }
// pendiente arreglar el metodo buscar lun 18/ dic/2017


// realizacion de busqueda mediante arreglos
  ionViewDidLoad() {
    console.log('ionViewDidLoad ChannelsPage');
    this.prue();
   // this.arreglo = this.prue1();
   // this.initializeItems();
  // this.items;
  }
/**
 *  metodo que carga a lista de usuarios suscritos
 *
 */
  public prue ()
  {
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

  initializeItems(){
     // this.items = this.listaSuscripcion;
     // this.items = [];
/*
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

      */

  }

  getItems(ev: any){
    //Reset items back to all of the items
   // this.initializeItems();
   
   this.items = this.listaSuscripcion;
   // this.prue();
   
    let i :number;
    console.log('hola');
    console.log(this.listaSuscripcion);
        // set val to the value of the searchbar
        let val = ev.target.value;
        console.log(val);
     
          if (val && val.trim() != '') {
            this.items = this.items.filter((item) => {
              return (item._name_user.toLowerCase().indexOf(val.toLowerCase()) > -1);
            })
          this.listaSuscripcion = this.items;
          console.log('chao ');
          console.log(this.listaSuscripcion);
          
        }
        else {this.prue();}
  }

// Realizacion del mensaje de confirmacion

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
                    //this.borrar(idSuscriptor);
                    console.log('presiono si suscripcion cancelada');
                   // console.log(idx);
                   // this.items[idx].color = 'claro';
                    this.estadoSus = 'Suscribirse';
                   // this.items[idx].estado = this.estadoSus;

                  }
                }

              ]
          });
        confirm.present();
        // this.estadoNombre='Suscrito';
       // this.items[idx].flag=false;
     // }
     // else
    //  {
   //     this.items[idx].color = 'primary';
   //     this.estadoSus = 'Suscrito';
    //    this.items[idx].estado = this.estadoSus;
   //     this.items[idx].flag=true;
    //  }

    console.log(idx);
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

 //public lineChartColors:Array<any>
  public  prue1(): Array<{_id_user: number,_name_user:string,_user_token:boolean}> 
  {
    let arregloLista : Array<{_id_user: number,_name_user:string,_user_token:boolean}>;
      this.api.geta('Suscripcion/GetSuscripcion?id='+ this.idUser)
     /* .subscribe( response => {
        this.listaSuscripcion = response;
        console.log(this.listaSuscripcion);
    })*/
    //comparar(item._id_user)

      .subscribe((data) => { // Success
          arregloLista = data.json()
          console.log (arregloLista)
         },
         (error) =>{
           console.error(error);
         });
   return arregloLista;    
  }

  //
  public comparar (idSuscriptorAux: number , idx : number) : string
  {
      
      let i :number;
      this.botones = this.prue1();
     // while ( i < 3 )
     // {
       console.log(this.botones);
        if(this.botones[i]._id_user == idSuscriptorAux)
             return 'suscrito';
              console.log(this.botones[i]._id_user + 'hh' +idSuscriptorAux);
           //   i++;
      //}
      return 'suscribirse';
  }
  
  //Array<{id: number, titulo: string, descripion: string, img:string, instructor:string, fecha: string, duracion: number, hora:string, capacidad:number, disponibilidad:number}>;


}
