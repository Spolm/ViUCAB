## boton
primero se crea un nuevo metodo (desde la ventana a donde va) en este caso de home a bienvenidos
abrimos home.ts
creamos el metodo llamado gopaginabienvenidos()
sin que devuelva nada y contiene lo siguiente
this -para llamar al controlador de navegacion this.navCtrl
luego llama a la funcion push this.navCtrl.push()
luego se le pasa la clase del componente de paginadebienvenidos que se encuentra en bienvenidos.ts
y se importa el componente 
quedaria algo como (el BienvenidosPage se encuentra en bienvenidos.ts y es el export de la clase)
goPaginaBienvenidos()void{
    This.navCtrl.push(BienvenidosPage),
}
el import quedaria de la siguente forma
import { BienvenidosPage } from '../bienvenidos/bienvenidos';


por ultimo se creal el boton en home.html
recuerda dentro de la etiqueta butom colocamos ion-buttom para que hereda las clases especificas para las demas plataformas
se le agrega el evento click y llamamos a la funcion que creamos que era gopaginabienvendios
##Agregando la nueva pagina al modulo de la app
primero vamos al bienvenidos.module.ts
copiamos el modulo (lo que se encuentra al lado de export class...)
vamos a app.module.ts
y en el array de import 
lo pegamos
y hacemos la llamada arriba import de nuestro modulo

