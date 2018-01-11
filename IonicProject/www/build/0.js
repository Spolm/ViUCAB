webpackJsonp([0],{

/***/ 455:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CategoriaPageModule", function() { return CategoriaPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__categoria__ = __webpack_require__(460);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var CategoriaPageModule = (function () {
    function CategoriaPageModule() {
    }
    return CategoriaPageModule;
}());
CategoriaPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__categoria__["a" /* CategoriaPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__categoria__["a" /* CategoriaPage */]),
        ],
    })
], CategoriaPageModule);

//# sourceMappingURL=categoria.module.js.map

/***/ }),

/***/ 459:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SugerenciaPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/**
 * Generated class for the CategoriaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
//
var SugerenciaPage = (function () {
    function SugerenciaPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    SugerenciaPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad SugerenciaPage');
    };
    return SugerenciaPage;
}());
SugerenciaPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-sugerencia',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\sugerencia\sugerencia.html"*/'<!--\n\n  Generated template for the LoginPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header >\n\n        \n\n          <ion-navbar color="primary">\n\n            <ion-title>Sugerencia</ion-title>\n\n          </ion-navbar>\n\n        \n\n        </ion-header>\n\n            \n\n<ion-content padding >\n\n    \n\n            <ion-list>\n\n                <h4 style="color:#000000;font-weight:600;text-align:center;">Canales recomendados </h4>                         \n\n            </ion-list>\n\n     \n\n        \n\n        <ion-card>\n\n        \n\n                <img width="200" height="200" src="assets/imgs/paisaje.png"/>\n\n            <ion-item>\n\n                <ion-avatar item-start>\n\n                    <img src="assets/imgs/fernando-avatar.jpg">\n\n                </ion-avatar>\n\n                <h2>Fernando Obregon</h2>\n\n            </ion-item>\n\n    \n\n            <ion-card-content>\n\n                <p>Fernando Obregon · 1.2 vistas · <ion-col align-self-center text-center>\n\n                    <ion-note>\n\n                        30yr ago\n\n                    </ion-note>\n\n                    </ion-col>\n\n                </p>\n\n\n\n                    <button style="color:#000000; font-weight:900;" ion-button  block outline icon-end>\n\n                        <ion-icon style="color:#000000;" ios="logo-youtube" md="logo-youtube"  ></ion-icon>\n\n                        Suscribirse\n\n                    </button> \n\n\n\n            </ion-card-content>      \n\n        </ion-card>\n\n\n\n\n\n        <ion-card>              \n\n            <img src="assets/imgs/P10_Paisaje.png">\n\n            <ion-item>\n\n                <ion-avatar item-start>\n\n                    <img src="assets/imgs/Logo1.png">\n\n                </ion-avatar>\n\n                <h2>Luiz Diaz</h2>\n\n            </ion-item>\n\n    \n\n            <ion-card-content>\n\n                <p>Luis Diaz · 1.2 vistas\n\n                    <ion-col align-self-center text-center>\n\n                    <ion-note>\n\n                        30yr ago\n\n                    </ion-note>\n\n                    </ion-col>\n\n                </p>\n\n                \n\n                <button class="button icon icon-right ion-home">\n\n                        Suscribirse\n\n                </button>           \n\n            </ion-card-content>\n\n                        \n\n        </ion-card>\n\n\n\n            <div padding>\n\n                <button ion-button block clear (click)=\'goPaginaCategoria()\' icon-end>Continuar</button>\n\n            </div>  \n\n</ion-content>\n\n        '/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\sugerencia\sugerencia.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], SugerenciaPage);

//# sourceMappingURL=sugerencia.js.map

/***/ }),

/***/ 460:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CategoriaPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__sugerencia_sugerencia__ = __webpack_require__(459);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




/**
 * Generated class for the CategoriaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var CategoriaPage = (function () {
    function CategoriaPage(navCtrl, navParams, alertCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
        this.isToggled = false;
        this.isTecnologia = false;
    }
    CategoriaPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad CategoriaPage');
    };
    CategoriaPage.prototype.notify = function () {
        if (this.isToggled == true) {
            this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__sugerencia_sugerencia__["a" /* SugerenciaPage */]);
        }
        else {
            var alert_1 = this.alertCtrl.create({
                title: 'Datos incorrectos',
                subTitle: 'Las contraseñas no coinciden',
                buttons: ['OK']
            });
            alert_1.present();
        }
    };
    CategoriaPage.prototype.notify1 = function () {
        if (this.isTecnologia == true) {
            this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__sugerencia_sugerencia__["a" /* SugerenciaPage */]);
        }
        else {
            var alert_2 = this.alertCtrl.create({
                title: 'Tecnologia',
                subTitle: 'No esta seleccionada',
                buttons: ['OK']
            });
            alert_2.present();
        }
    };
    CategoriaPage.prototype.categoria = function () {
        var alert = this.alertCtrl.create({
            title: 'Datos incorrectos',
            subTitle: 'Las contraseñas no coinciden',
            buttons: ['OK']
        });
        alert.present();
    };
    ;
    CategoriaPage.prototype.goPaginaSugerencia = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__sugerencia_sugerencia__["a" /* SugerenciaPage */]);
    };
    return CategoriaPage;
}());
CategoriaPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-categoria',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\categoria\categoria.html"*/'<!--\n\n  Generated template for the LoginPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header >\n\n        \n\n          <ion-navbar color="primary">\n\n            <ion-title>Categoria</ion-title>\n\n          </ion-navbar>\n\n        \n\n        </ion-header>\n\n        \n\n        \n\n        <ion-content padding >\n\n    \n\n            <ion-list>\n\n                <h4 style="color:#000000;font-weight:600;text-align:center;">Seleccione las categorias de su preferencia </h4>       \n\n          \n\n                <ion-item>\n\n                    <ion-label> Música </ion-label>\n\n                    <ion-toggle [(ngModel)]="isToggled" (ionChange)="notify()" > </ion-toggle >\n\n                \n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Tecnología </ion-label>\n\n                    <ion-toggle [(ngModel)]="isTecnologia" (ionChange)="notify1()"  > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Deporte </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Cine y entretenimiento </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Comedia </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Belleza y moda </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Noticias y política </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Juegos </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n                <ion-item>\n\n                    <ion-label> Cocina y salud </ion-label>\n\n                    <ion-toggle  value = " foo "  checked = " false " > </ion-toggle >\n\n                </ion-item >\n\n            </ion-list>\n\n    \n\n            <div padding>\n\n                    <button ion-button block clear (click)=\'notify1()\' icon-end>Continuar</button>\n\n            </div>\n\n    </ion-content>\n\n        '/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\categoria\categoria.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]])
], CategoriaPage);

//# sourceMappingURL=categoria.js.map

/***/ })

});
//# sourceMappingURL=0.js.map