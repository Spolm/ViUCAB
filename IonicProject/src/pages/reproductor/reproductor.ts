import {Component, ViewChild, OnInit} from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {AlertController} from 'ionic-angular';
import {RestApiService} from '../../app/rest-api.service';
import {Subscription} from 'rxjs/Subscription';

/**
 * Generated class for the ListasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
@IonicPage()
@Component({
    selector: 'page-reproductor',
    templateUrl: 'reproductor.html',
    providers: [RestApiService]
})
export class ReproductorPage implements OnInit {
    public video: any[]
    subscription: Subscription;
    public comentario = '';
    private path = 'Modulo2';
    public usuario = 'erbintune@gmail.com';
    //    public response: any[];
    public color = 'black';
    //    public video =                //PRUEBA CON DATOS ESTATICOS
    //    {
    //        title: 'Subiendo a Galipan',
    //        url: 'http://localhost:2018/video.mp4',
    //        visitas: '58',
    //        likes: '23',
    //        dislikes: '54',
    //        owner: 'Cher',
    //        imgowner: '../../assets/imgs/advance-card-bttf.png',
    //        subscripciones: '100',
    //        relacionados: [
    //            {
    //                id: '34',
    //                urlimg: 'http://localhost:2018/foto.jpeg',
    //                nombre: 'La Bebe de Erbin junto a la gorda del Negro',
    //                canal: 'meruvzla4wd'
    //            },
    //            {
    //                id: '34',
    //                urlimg: 'http://localhost:2018/foto.jpeg',
    //                nombre: 'La Bebe de Erbin junto a la gorda del Negro',
    //                canal: 'meruvzla4wd'
    //            },
    //            {
    //                id: '34',
    //                urlimg: 'http://localhost:2018/foto.jpeg',
    //                nombre: 'La Bebe de Erbin junto a la gorda del Negro',
    //                canal: 'meruvzla4wd'
    //            }
    //        ],
    //        comentarios: [
    //            {
    //                iduser: '25',
    //                correo: 'aledavid21@gmail.com'
    //                urlimg: 'http://localhost:2018/foto2.jpg',
    //                nombre: 'Coquetos',
    //                idcomentario: '1'
    //                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
    //            },
    //            {
    //                iduser: '25',
    //                correo: 'aledavid21@gmail.com'
    //                urlimg: 'http://localhost:2018/foto2.jpg',
    //                nombre: 'Coquetos',
    //                idcomentario: '1'
    //                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
    //            },
    //            {
    //                iduser: '25',
    //                correo: 'aledavid21@gmail.com'
    //                urlimg: 'http://localhost:2018/foto2.jpg',
    //                nombre: 'Coquetos',
    //                idcomentario: '1'
    //                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
    //            },
    //            {
    //                iduser: '25',
    //                correo: 'aledavid21@gmail.com'
    //                urlimg: 'http://localhost:2018/foto2.jpg',
    //                nombre: 'Coquetos',
    //                idcomentario: '1'
    //                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
    //            },
    //            {
    //                iduser: '25',
    //                correo: 'aledavid21@gmail.com'
    //                urlimg: 'http://localhost:2018/foto2.jpg',
    //                nombre: 'Coquetos',
    //                idcomentario: '1'
    //                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
    //            },
    //            {
    //                iduser: '25',
    //                correo: 'aledavid21@gmail.com'
    //                urlimg: 'http://localhost:2018/foto2.jpg',
    //                nombre: 'Coquetos',
    //                idcomentario: '1'
    //                comentario: 'The Loading component is an overlay that prevents user interaction while indicating activity. By default, it shows a spinner based on the mode. Dynamic content can be passed and displayed with the spinner. The spinner can be hidden or customized to use several predefined options. The loading indicator is presented on top of other content even during navigation.'
    //            }
    //        ],
    //        listas: [
    //            {
    //                id: '25',
    //                nombre: 'Lista rustica'
    //            },
    //            {
    //                id: '25',
    //                nombre: 'Lista rustica'
    //            },
    //            {
    //                id: '25',
    //                nombre: 'Lista rustica'
    //            }
    //        ]
    //    };

    constructor(public navCtrl: NavController, public navParams: NavParams,
        public alertCtrl: AlertController, public api: RestApiService) {
    }

    ngOnInit() {
        this.api.getReproduccion(this.path + '/addVisita?idvideo=' + this.navParams.data).subscribe();
        this.api.getReproduccion(this.path + '/getVideoInfo?idvideo=' + this.navParams.data).subscribe((data) => { // Success
            this.video = data.json();

        },
            (error) => {
                console.error(error);
            });

        if (this.usuario) {
            this.api.getReproduccion(this.path + '/getIfLike?idvideo=' + this.navParams.data + '&usuario=' + this.usuario).subscribe((data) => {
                if (data.json().result != '0') {
                    this.color = 'primary';
                }
            }

            )
        }

    }

    openVideo(id) {
        this.navCtrl.setRoot(ReproductorPage, id);
    }

    @ViewChild('myNav') nav: NavController;


    sentComment() {
        this.api.getReproduccion(this.path + '/addComentario?idvideo=' + this.navParams.data + '&usuario=' + this.usuario + '&comentario=' + this.comentario).subscribe((data) => {
            if (data.json().result != '0') {
                this.showAlert('Comentario agregado exitosamente!');
                this.openVideo(this.navParams.data);
            }
            else {
                this.showAlert('Hubo un error enviando tu comentario :(. Intentelo de nuevo');
            }
        });
    }


    showAlert(title) {
        let alert = this.alertCtrl.create({
            title: title,
            buttons: ['OK']
        });
        alert.present();
    }


    updateLike() {
        this.api.getReproduccion(this.path + '/updateLike?idvideo=' + this.navParams.data + '&usuario=' + this.usuario).subscribe();
        this.openVideo(this.navParams.data);
    }

    deleteComentario(idcom, com) {
        let confirm = this.alertCtrl.create({
            title: '¿Seguro que desea eliminar este comentario?',
            message: com,
            buttons: [
                {
                    text: 'Eliminar',
                    handler: () => {
                        this.api.getReproduccion(this.path + '/deleteComentario?idcomentario=' + idcom).subscribe((data) => {
                            if (data.json().result == '0') {
                                this.showAlert('Comentario eliminado exitosamente!');
                                this.openVideo(this.navParams.data);
                            }
                            else {
                                this.showAlert('Hubo un error intentando eliminar su comentario :(. Intentelo de nuevo');
                            }
                        });
                    }
                },
                {
                    text: 'Cancelar',
                    handler: () => {
                    }
                }
            ]
        });
        confirm.present();
    }

}