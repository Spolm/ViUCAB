
import { Component } from '@angular/core';

import { IonicPage, NavController, NavParams } from 'ionic-angular';

import {RestApiService} from '../../app/rest-api.service';


/**
 * Generated class for the Modulo9Page page.
 *
 
* See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */


@IonicPage()

@Component({
  selector: 'page-modulo9',
  templateUrl: 'modulo9.html',
  providers: [RestApiService]
})

export class Modulo9Page 
{
 usuario : String;
 
categoria : String;
 
listaVideo: Array<{}>;
listaVideoArte: Array<{}>;
listaVideoJuegos: Array<{}>;
listaVideoComedia: Array<{}>;
listaVideoMusica: Array<{}>;
  
constructor(public navCtrl: NavController, public navParams: NavParams, public api: RestApiService ) {

  this.getVideosLikeArte();   
this.getVideosLike();

this.getVideosLikeComedia();
this.getVideosLikeJuegos();
this.getVideosLikeMusica();
//this.listaVideo;
  }

  
public getVideosLike(){
//dEPORTE: 1    
this.usuario = "3";
    
this.categoria = "Deporte";
    
const url = "Sugerencias/get_sugerencias-likes?id="+this.usuario+"&categoria="+this.categoria;

  
this.api.geta(url).subscribe((data)=>{this.listaVideo = data.json()
                                          
                                      console.log(this.listaVideo)},
                                        
                                   (error)=>{console.error(error)});
                                        
   
 //console.log(this.api.getTodo(url));
   
    //this.api.getTodo(url)
  }

  public getVideosLikeArte(){
    //Arte: 5
    this.usuario = "1";
        
    this.categoria = "Arte";
        
    const url = "Sugerencias/get_sugerencias-likes?id="+this.usuario+"&categoria="+this.categoria;
    
      
    this.api.geta(url).subscribe((data)=>{this.listaVideoArte = data.json()
                                              
                                          console.log(this.listaVideoArte)},
                                            
                                       (error)=>{console.error(error)});
                                            
       
     //console.log(this.api.getTodo(url));
       
        //this.api.getTodo(url)
      }

      public getVideosLikeMusica(){
      //Musica: 3
        this.usuario = "3";
            
        this.categoria = "Musica";
            
        const url = "Sugerencias/get_sugerencias-likes?id="+this.usuario+"&categoria="+this.categoria;
        
          
        this.api.geta(url).subscribe((data)=>{this.listaVideoMusica = data.json()
                                                  
                                              console.log(this.listaVideoMusica)},
                                                
                                           (error)=>{console.error(error)});
                                                
           
         //console.log(this.api.getTodo(url));
           
            //this.api.getTodo(url)
          }

          public getVideosLikeJuegos(){
          //Videojuego: 2
            this.usuario = "3";
                
            this.categoria = "Videojuego";
                
            const url = "Sugerencias/get_sugerencias-likes?id="+this.usuario+"&categoria="+this.categoria;
            
              
            this.api.geta(url).subscribe((data)=>{this.listaVideoJuegos = data.json()
                                                      
                                                  console.log(this.listaVideoJuegos)},
                                                    
                                               (error)=>{console.error(error)});
                                                    
               
             //console.log(this.api.getTodo(url));
               
                //this.api.getTodo(url)
              }
  
              public getVideosLikeComedia(){
              //Comedia: 4
                this.usuario = "3";
                    
                this.categoria = "Comedia";
                    
                const url = "Sugerencias/get_sugerencias-likes?id="+this.usuario+"&categoria="+this.categoria;
                
                  
                this.api.geta(url).subscribe((data)=>{this.listaVideoComedia = data.json()
                                                          
                                                      console.log(this.listaVideoComedia)},
                                                        
                                                   (error)=>{console.error(error)});
                                                        
                   
                 //console.log(this.api.getTodo(url));
                   
                    //this.api.getTodo(url)
                  }
  
  
ionViewDidLoad() {
    
console.log('ionViewDidLoad Modulo9Page');
    
console.log(this.listaVideo);
  }

}
