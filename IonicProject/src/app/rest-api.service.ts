//Clase que se encarga de enviar las solicitudes al servidor Rest Java
//En periodo de prueba, no se ha validado que funciona, pero es la estructura basica. 

import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { Http } from '@angular/http';

//Direccion del servidor donde esta la BDD
const URL = 'http://localhost:8080/viucab/hola';

@Injectable()
export class RestApiService {

  constructor(
    private http: Http
  ) { }

  //Metodo GET: /listaObjetos
  //Devuelve todos los objetos
  public getTodo(objetos){
    console.log(URL+'/'+objetos);
    return this.http
      .get(URL+'/'+objetos)
  }

  //Metodo GET: /listaObjetos/id_objeto
  //Devuelve un objeto, es necesario el id
  public getUno(objetos, id) {
    return this.http
    .get(URL+'/'+objetos+'/'+id)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo POST: /listaObjetos
  //Actualiza varios datos de un tipo objeto
  public postTodo(objetos, datos) {
    return this.http
    .post(URL+'/'+objetos, datos)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo POST: /listaObjetos/id_objeto
  //Actualiza un dato de tipo objeto. Es necesario el id
  public postUno(objetos, id, dato) {
    return this.http
    .post(URL+'/'+objetos+"/"+id, dato)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo PUT: /listaObjetos
  //Agrega varios datos de tipo objetos
  public putTodo(objetos, datos) {
    return this.http
    .put(URL+'/'+objetos, datos)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }
   //Metodo PUT: /listaObjetos/id_objeto
   //Agrega un dato de tipo objetos
  public putUno(objetos, dato) {
    return this.http
    .put(URL+'/'+objetos, dato)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }
   //Metodo DELETE: /listaObjetos
   //Elimina todos los objetos
   public deleteTodo(objetos){
    return this.http
    .delete(URL+'/'+objetos)
    .map((data: any) => data.json())
    .catch(this.handleError);
   }

  //Metodo DELETE: /listaObjetos/id_objeto
  //Elimina un dato de un objeto, es necesario el id
   public deleteUno(objetos, id){
    return this.http
    .delete(URL+'/'+objetos+"/"+id)
    .map((data: any) => data.json())
    .catch(this.handleError);
   }

   //Manejo de erorres

   private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
