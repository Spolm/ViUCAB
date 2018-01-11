webpackJsonp([1],{

/***/ 458:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SugerenciaPageModule", function() { return SugerenciaPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__sugerencia__ = __webpack_require__(459);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var SugerenciaPageModule = (function () {
    function SugerenciaPageModule() {
    }
    return SugerenciaPageModule;
}());
SugerenciaPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__sugerencia__["a" /* SugerenciaPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__sugerencia__["a" /* SugerenciaPage */]),
        ],
    })
], SugerenciaPageModule);

//# sourceMappingURL=sugerencia.module.js.map

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

/***/ })

});
//# sourceMappingURL=1.js.map