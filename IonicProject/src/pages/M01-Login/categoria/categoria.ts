import { Component } from '@angular/core';
import { AlertController } from 'ionic-angular';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { SugerenciaPage} from '../sugerencia/sugerencia';
/**
 * Generated class for the CategoriaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-categoria',
  templateUrl: 'categoria.html',
})
export class CategoriaPage {

  public isToggled: boolean;
  public isTecnologia: boolean;

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams,
    public alertCtrl: AlertController,
    ) {
      this.isToggled = false;
      this.isTecnologia = false;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CategoriaPage');
  }

  public notify() {
    if(this.isToggled == true){
      this.navCtrl.push(SugerenciaPage)
    }else{
      let alert = this.alertCtrl.create({
        title: 'Datos incorrectos',
        subTitle: 'Las contraseñas no coinciden',
        buttons: ['OK']
      });
      alert.present();
    }
  }

  public notify1() {
    if(this.isTecnologia == true){
      this.navCtrl.push(SugerenciaPage)
    }else{
      let alert = this.alertCtrl.create({
        title: 'Tecnologia',
        subTitle: 'No esta seleccionada',
        buttons: ['OK']
      });
      alert.present();
    }
  }

  categoria(){
      let alert = this.alertCtrl.create({
        title: 'Datos incorrectos',
        subTitle: 'Las contraseñas no coinciden',
        buttons: ['OK']
      });
      alert.present();
  };

  goPaginaSugerencia():void {
    this.navCtrl.push(SugerenciaPage);
      }
  
}