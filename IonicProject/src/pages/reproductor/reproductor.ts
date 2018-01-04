import {Component, ViewChild} from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {AlertController} from 'ionic-angular';

/**
 * Generated class for the ListasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
    selector: 'page-reproductor',
    templateUrl: 'reproductor.html',
})
export class ReproductorPage {

    public tab: string;
    public video =
    {
        title: 'Subiendo a Galipan',
        url: 'http://localhost:2018/video.mp4',
        visitas: '58',
        likes: '23',
        dislikes: '54',
        owner: 'Cher',
        subscripciones: '100',
        relacionados: [
            {
                id: '34',
                urlimg: 'http://localhost:2018/foto.jpeg',
                nombre: 'La Bebe de Erbin junto a la gorda del Negro',
                canal: 'meruvzla4wd'
            },
            {
                id: '34',
                urlimg: 'http://localhost:2018/foto.jpeg',
                nombre: 'La Bebe de Erbin junto a la gorda del Negro',
                canal: 'meruvzla4wd'
            },
            {
                id: '34',
                urlimg: 'http://localhost:2018/foto.jpeg',
                nombre: 'La Bebe de Erbin junto a la gorda del Negro',
                canal: 'meruvzla4wd'
            }
        ],
        comentarios: [
            {
                iduser: '25',
                urlimg: 'http://localhost:2018/foto2.jpg',
                nombre: 'Coquetos',
                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
            },
            {
                iduser: '25',
                urlimg: 'http://localhost:2018/foto2.jpg',
                nombre: 'Coquetos',
                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
            },
            {
                iduser: '25',
                urlimg: 'http://localhost:2018/foto2.jpg',
                nombre: 'Coquetos',
                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
            },
            {
                iduser: '25',
                urlimg: 'http://localhost:2018/foto2.jpg',
                nombre: 'Coquetos',
                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
            },
            {
                iduser: '25',
                urlimg: 'http://localhost:2018/foto2.jpg',
                nombre: 'Coquetos',
                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
            }
        ],
        listas: [
            {
                id: '25',
                nombre: 'Lista rustica'
            },
            {
                id: '25',
                nombre: 'Lista rustica'
            },
            {
                id: '25',
                nombre: 'Lista rustica'
            }
        ]
    };


    constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    }

    @ViewChild('myNav') nav: NavController;


    showLists() {
        let alert = this.alertCtrl.create();
        alert.setTitle('Seleccione las listas a agregar');

        for (let lista of this.video.listas) {

            alert.addInput({
                type: 'checkbox',
                label: lista.nombre,
                value: lista.id,
                checked: false
            });
        }


        alert.addButton('Cancel');
        alert.addButton({
            text: 'Guardar',
            handler: data => {
//                console.log('Checkbox data:', data);
//                this.testCheckboxOpen = false;
//                this.testCheckboxResult = data;
            }
        });
        alert.present();
    }

    showAlert() {
        let alert = this.alertCtrl.create({
            title: 'Comentario agregado exitosamente!',
            buttons: ['OK']
        });
        alert.present();
    }

}
