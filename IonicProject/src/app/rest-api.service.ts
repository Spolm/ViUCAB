//Clase que se encarga de enviar las solicitudes al servidor Rest Java
//En periodo de prueba, no se ha validado que funciona, pero es la estructura basica. 

import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { Http } from '@angular/http';

//Direccion del servidor donde esta la BDD
const URL = 'http://localhost:8080/viucab';

@Injectable()
export class RestApiService {

  constructor(
    private http: Http
  ) { }

  //Metodo GET: /direccion
  //Accede al metodo que se encuentra en direccion y devuelve la respuesta
  public getTodo(direccion){
    console.log(URL+'/'+direccion);
    return this.http
      .get(URL+'/'+direccion)
      .map((data: any) => data.json())
      .subscribe();
  }

  //Metodo GET: /direccion/id_objeto
  //Accede al metodo que se encuentra en direccion, enviando un id y devuelve la respuesta
  public getUno(direccion, idObjeto) {
    return this.http
    .get(URL+'/'+direccion+'/'+idObjeto)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo GET: /direccion + (param)
  //Accede al metodo que se encuentra en direccion, enviando parametros y devuelve la respuesta
  public getTodoParam(direccion, param){
    return this.http
      .get(URL+'/'+direccion, param)
      .map((data: any) => data.json())
      .subscribe();
  }

  //Metodo GET: /direccion + (param)
  //Accede al metodo que se encuentra en direccion, enviando un id y parametros y devuelve la respuesta
  public getUnoParam(direccion, idObjeto, param){
    return this.http
      .get(URL+'/'+direccion+'/'+idObjeto, param)
      .map((data: any) => data.json())
      .subscribe();
  }


  //Metodo POST: /direccion
  //Actualiza o envia datos mas parametros a una direccion
  public postTodo(direccion, datos, param) {
    return this.http
    .post(URL+'/'+direccion, datos, param)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo POST: /direccion/id_objeto
  //Actualiza el objeto id en una direccion. Es necesario el enviar el dato nuevo y los parametros
  public postUno(direccion, idObjeto, dato, param) {
    return this.http
    .post(URL+'/'+direccion+"/"+idObjeto, dato, param)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo PUT: /direccion
  //Agrega en una direccion, envia los datos y el parametro
  public putTodo(direccion, datos, param) {
    return this.http
    .put(URL+'/'+direccion, datos, param)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

  //Metodo PUT: /direccion/id_objeto
  //Agrega el objeto id en una direccion, envia los datos y el parametro
  public putUno(direccion, idObjeto, dato, param) {
    return this.http
    .put(URL+'/'+direccion+'/'+idObjeto, dato, param)
    .map((data: any) => data.json())
    .catch(this.handleError);
  }

   //Metodo DELETE: /direccion
   //Elimina en una direccion, enviando parametros
   public deleteTodo(direccion, param){
    return this.http
    .delete(URL+'/'+direccion, param)
    .map((data: any) => data.json())
    .catch(this.handleError);
   }

  //Metodo DELETE: /direccion/id_objeto
  //Elimina un objeto en una direccion, es necesario el id y los parametros
   public deleteUno(direccion, idObjeto, param){
    return this.http
    .delete(URL+'/'+direccion+"/"+idObjeto, param)
    .map((data: any) => data.json())
    .catch(this.handleError);
   }

  //Metodo DELETE: /direccion
  //Elimina varios objetos en una direccion, es necesario la lista de objetos a eliminar y los parametros
   public deleteVarios(direccion, dato, param){
    return this.http
    .delete(URL+'/'+direccion, dato)
    .map((data: any) => data.json())
    .catch(this.handleError);
   }

   //Manejo de erorres

   private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
