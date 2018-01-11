import { Http, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';

/*
  Generated class for the ServicioProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ServicioProvider {


  constructor(public http: Http) {
    console.log('Hello ServicioProvider Provider');
  }


    postRequest(datos) {
      var headers = new Headers();
      headers.append('Access-Control-Allow-Origin' , '*');
      headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
      headers.append('Accept','application/json');
      headers.append('content-type','application/json');

      let options = new RequestOptions({ headers: headers });

     let postParams = {"id":1,"listaFiltros":datos};
     console.log(postParams);
     alert("");
      return new Promise ((resolve, reject) => {
        alert("enviado filtros...");
      this.http.post("http://localhost:8080/WS_mejorado_war_exploded//guardarFiltrosDeUsuario", postParams, options)
        .subscribe(data => {
          console.log(data);
         }, error => {
          console.log(error);// Error getting the data
        });
      });
    }



  getData(){
    this.http.get('https://api.myjson.com/bins/mcjcb')
    .map(res => res.json())
    .subscribe(data => {
      console.log(data);
    });

  }
}
