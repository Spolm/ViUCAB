webpackJsonp([17],{

/***/ 135:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ConfiguracionNotificacionesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ConfiguracionNotificacionesPage = (function () {
    function ConfiguracionNotificacionesPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    ConfiguracionNotificacionesPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ConfiguracionNotificacionesPage');
    };
    return ConfiguracionNotificacionesPage;
}());
ConfiguracionNotificacionesPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-configuracion-notificaciones',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\configuracion-notificaciones\configuracion-notificaciones.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n      <ion-icon name="menu"></ion-icon>\n\n    </button>\n\n  </ion-buttons>\n\n    <ion-title>\n\n      Configuración\n\n    </ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n<ion-content padding id="page3">\n\n  <div id="titulo" class="show-list-numbers-and-dots">\n\n      <strong>\n\n        Configuración de Notificaciones\n\n      </strong>\n\n  </div>\n\n  <form id="configuracion-form">\n\n    <ion-item id="notificaciones-toggle">\n\n      <ion-label>\n\n        Notificaciones\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="true"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="noletin-toggle">\n\n      <ion-label>\n\n        Boletín Semanal\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="true"></ion-toggle>\n\n    </ion-item>\n\n    <div id="mensaje" class="show-list-numbers-and-dots">\n\n        <strong>\n\n          Acepto recibir notificaciones a mi correo electrónico\n\n        </strong>\n\n    </div>\n\n    <ion-item id="videos-toggle">\n\n      <ion-label>\n\n        Videos Recomendados\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="subscripciones-toggle">\n\n      <ion-label>\n\n        Videos de Subscripciones\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="etiquetados-toggle">\n\n      <ion-label>\n\n        Videos Etiquetados\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="estadisticas-toggle">\n\n      <ion-label>\n\n        Estadísticas de Usuario\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n  </form>\n\n</ion-content>'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\configuracion-notificaciones\configuracion-notificaciones.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], ConfiguracionNotificacionesPage);

//# sourceMappingURL=configuracion-notificaciones.js.map

/***/ }),

/***/ 136:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CreateNewListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
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
 * Generated class for the CreateNewListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var CreateNewListPage = (function () {
    function CreateNewListPage(navCtrl, navParams, alertCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
    }
    CreateNewListPage.prototype.showAlert = function () {
        var alert = this.alertCtrl.create({
            title: 'Lista Creada!',
            buttons: ['OK']
        });
        alert.present();
    };
    CreateNewListPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad CreateNewListPage');
    };
    return CreateNewListPage;
}());
CreateNewListPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-create-new-list',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\create-new-list\create-new-list.html"*/'<!--\n\n  Generated template for the CreateNewListPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n        <ion-icon name="menu"></ion-icon>\n\n      </button>\n\n    </ion-buttons>\n\n    <ion-title>\n\n      <ion-row>\n\n        <ion-col col-9 class="nopadding">\n\n          Crear Lista Nueva\n\n        </ion-col>\n\n        <!-- <ion-col col-3 class="nopadding" align="right"> \n\n          <ion-icon ios="ios-create" md="md-create"></ion-icon>\n\n          <ion-icon style="margin-left:15px;" ios="ios-trash" md="md-trash"></ion-icon>\n\n        </ion-col>-->\n\n\n\n      </ion-row>\n\n    </ion-title>\n\n\n\n  </ion-navbar>\n\n</ion-header>\n\n\n\n<ion-content padding>\n\n\n\n  <div>\n\n    <ion-list>\n\n\n\n      <ion-item>\n\n        <ion-label floating>Nombre</ion-label>\n\n        <ion-input type="text"></ion-input>\n\n      </ion-item>\n\n\n\n      <ion-item>\n\n        <ion-label floating>Descripción</ion-label>\n\n        <ion-input type="password"></ion-input>\n\n      </ion-item>\n\n      \n\n      <br>\n\n      <br>\n\n\n\n      <ion-item>\n\n        <ion-label>Privada</ion-label>\n\n        <ion-checkbox></ion-checkbox>\n\n      </ion-item>\n\n\n\n    </ion-list>\n\n  </div>\n\n  <br>\n\n  <br>\n\n\n\n\n\n\n\n  <button class="botonCrearLista" color="secondary" ion-button (click)="showAlert()"> GUARDAR </button>\n\n\n\n\n\n\n\n\n\n</ion-content>'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\create-new-list\create-new-list.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]])
], CreateNewListPage);

//# sourceMappingURL=create-new-list.js.map

/***/ }),

/***/ 137:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EditListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
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
 * Generated class for the EditListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var EditListPage = (function () {
    function EditListPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    EditListPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad EditListPage');
    };
    return EditListPage;
}());
EditListPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-edit-list',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\edit-list\edit-list.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n        <ion-icon name="menu"></ion-icon>\n\n      </button>\n\n    </ion-buttons>\n\n    <ion-title>\n\n        <ion-row>\n\n            <ion-col col-10 class="nopadding">\n\n                Editar lista numero 1\n\n   \n\n            </ion-col>\n\n            <ion-col col-2 class="nopadding" align="right">\n\n                <ion-icon ios="ios-trash" md="md-trash"></ion-icon>\n\n            </ion-col>\n\n          </ion-row>\n\n    </ion-title>\n\n\n\n  </ion-navbar>\n\n</ion-header>\n\n\n\n<ion-content padding>\n\n\n\n  <ion-list>\n\n\n\n    <ion-item>\n\n      <ion-label floating>Nombre de la Lista</ion-label>\n\n      <ion-input type="text"></ion-input>\n\n    </ion-item>\n\n\n\n    <ion-item>\n\n      <ion-label floating>Descripcion</ion-label>\n\n      <ion-textarea></ion-textarea>\n\n    </ion-item>\n\n    <br>\n\n    <br>\n\n    <ion-item>\n\n      <ion-label>Lista Privada</ion-label>\n\n      <ion-checkbox color="red" checked="false"></ion-checkbox>\n\n    </ion-item>\n\n\n\n  </ion-list>\n\n\n\n\n\n      <button class="botonGuardarEditado" ion-button color="light">GUARDAR</button>\n\n\n\n  \n\n\n\n\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\edit-list\edit-list.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], EditListPage);

//# sourceMappingURL=edit-list.js.map

/***/ }),

/***/ 148:
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = 148;

/***/ }),

/***/ 191:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../pages/Modulo 2/canal/canal.module": [
		753,
		9
	],
	"../pages/Modulo 2/estadistica/estadistica.module": [
		754,
		8
	],
	"../pages/Modulo 2/inicio/inicio.module": [
		755,
		7
	],
	"../pages/Modulo 2/listas/listas.module": [
		756,
		6
	],
	"../pages/Modulo 2/menu/menu.module": [
		757,
		5
	],
	"../pages/Modulo 2/suscripciones/suscripciones.module": [
		758,
		4
	],
	"../pages/Modulo 2/tabs/tabs.module": [
		759,
		3
	],
	"../pages/Modulo 2/tendencias/tendencias.module": [
		760,
		2
	],
	"../pages/Modulo 2/usuario/usuario.module": [
		761,
		1
	],
	"../pages/configuracion-notificaciones/configuracion-notificaciones.module": [
		752,
		16
	],
	"../pages/notificaciones/notificaciones.module": [
		762,
		15
	],
	"../pages/playlist/add-list/add-list.module": [
		763,
		14
	],
	"../pages/playlist/create-new-list/create-new-list.module": [
		764,
		13
	],
	"../pages/playlist/edit-list/edit-list.module": [
		765,
		12
	],
	"../pages/playlist/playlist.module": [
		766,
		0
	],
	"../pages/playlist/pop-over-listas-reproduccion/pop-over-listas-reproduccion.module": [
		767,
		11
	],
	"../pages/playlist/view-list/view-list.module": [
		768,
		10
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return __webpack_require__.e(ids[1]).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = 191;
module.exports = webpackAsyncContext;

/***/ }),

/***/ 379:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotificacionesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__configuracion_notificaciones_configuracion_notificaciones__ = __webpack_require__(135);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_rest_api_service__ = __webpack_require__(457);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var NotificacionesPage = (function () {
    function NotificacionesPage(navCtrl, navParams, api) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.api = api;
    }
    NotificacionesPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad NotificacionesPage');
    };
    NotificacionesPage.prototype.goToConfiguracionNotificaciones = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__configuracion_notificaciones_configuracion_notificaciones__["a" /* ConfiguracionNotificacionesPage */]);
    };
    return NotificacionesPage;
}());
NotificacionesPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-notificaciones',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\notificaciones\notificaciones.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n      <ion-icon name="menu"></ion-icon>\n\n    </button>\n\n    </ion-buttons>\n\n    <ion-title>\n\n      Notificaciones\n\n    </ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n<ion-content padding id="page1">\n\n  <button id="notificaciones-button1" ion-button color="light" block icon-right style="text-align:left;" on-click="goToConfiguracionNotificaciones()">\n\n    Configuración\n\n    <ion-icon name="settings"></ion-icon>\n\n  </button>\n\n  <ion-list id="notificaciones-list3">\n\n    <ion-item color="none" id="notificaciones-list-item10">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n    <ion-item color="none" id="notificaciones-list-item11">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n    <ion-item color="none" id="notificaciones-list-item12">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n    <ion-item color="none" id="notificaciones-list-item13">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n  </ion-list>\n\n</ion-content>'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\notificaciones\notificaciones.html"*/,
        providers: [__WEBPACK_IMPORTED_MODULE_3__app_rest_api_service__["a" /* RestApiService */]]
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_3__app_rest_api_service__["a" /* RestApiService */]])
], NotificacionesPage);

//# sourceMappingURL=notificaciones.js.map

/***/ }),

/***/ 380:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AddListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__create_new_list_create_new_list__ = __webpack_require__(136);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



// import { AlertController } from 'ionic-angular';
/**
 * Generated class for the AddListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var AddListPage = (function () {
    function AddListPage(navCtrl, navParams /*  , public alertCtrl: AlertController*/) {
        this.navCtrl = navCtrl;
        this.navParams = navParams; /*  , public alertCtrl: AlertController*/
        this.ListasDeReproduccion = [
            { title: 'Lista numero 1', amount: '13', duration: '30:00 min', img: 'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg' },
            { title: 'Lista numero 2', amount: '3', duration: '3:00 min', img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho' },
            { title: 'Lista numero 3', amount: '1', duration: '39:05 min', img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho' },
        ];
    }
    AddListPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad AddListPage');
    };
    /*  showAddListPrompt() {
      let prompt = this.alertCtrl.create({
        title: 'Crear Lista',
        message: "Introduzca datos de la Lista a crear",
        inputs: [
          {
            name: 'title',
            placeholder: 'Titulo'
          },
          {
            name: 'description',
            placeholder: 'Descripcion'
          }
        ],
  
        buttons: [
          {
            text: 'Cancel',
            handler: data => {
              console.log('Cancel clicked');
            }
          },
          {
            text: 'Save',
            handler: data => {
              console.log('Saved clicked');
            }
          }
        ]
      });
      prompt.present();
    }*/
    AddListPage.prototype.goToCreateNewList = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__create_new_list_create_new_list__["a" /* CreateNewListPage */]);
    };
    return AddListPage;
}());
AddListPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-add-list',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\add-list\add-list.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n        <ion-icon name="menu"></ion-icon>\n\n      </button>\n\n    </ion-buttons>\n\n    <ion-title>\n\n      <ion-row>\n\n        <ion-col col-10 class="nopadding">\n\n          Agregar Lista de Reproduccion\n\n\n\n        </ion-col>\n\n      </ion-row>\n\n    </ion-title>\n\n\n\n  </ion-navbar>\n\n</ion-header>\n\n\n\n<ion-content padding>\n\n\n\n  <ion-list>\n\n    <ion-item *ngFor="let lista of ListasDeReproduccion" >\n\n      <ion-grid>\n\n        <ion-row>\n\n            <ion-row >\n\n              <div class="ellipsis">\n\n                <ion-icon name="list" padding-right="30dpx"></ion-icon>\n\n                <span class="List-title-soft">{{lista.title}}</span>\n\n              </div>\n\n            </ion-row>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n\n\n    <hr>\n\n    <div class="ellipsis" padding-left="100dpx" padding-top="15dpx" (click)="goToCreateNewList()">\n\n      <ion-icon class="custom-icon" name="add" padding-right="20dpx" ></ion-icon>\n\n      <span class="List-title">Crear Lista</span>\n\n    </div>\n\n\n\n  </ion-list>\n\n\n\n\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\add-list\add-list.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */] /*  , public alertCtrl: AlertController*/])
], AddListPage);

//# sourceMappingURL=add-list.js.map

/***/ }),

/***/ 381:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ViewListPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
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
 * Generated class for the ViewListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var ViewListPage = (function () {
    function ViewListPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.ListaDeVideos = [
            { title: 'Video numero 1', plays: '133', duration: '30:00 min', img: 'https://birdinflight.imgix.net/wp-content/uploads/2016/07/cassius-interactive-music-video_cover.jpg?auto=format&q=80&fit=crop&crop=faces&w=632' },
            { title: 'Video numero 2', plays: '32', duration: '3:00 min', img: 'http://assets7.capitalxtra.com/2017/42/krept-and-konan-ask-flipz-video-1508500206-list-handheld-0.png' },
            { title: 'Video numero 3', plays: '12', duration: '39:05 min', img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRESg8T4eeKccQZTSsGLyFT7DZzWASx8TXiJzRLVtoxojdWB-Rb' },
        ];
    }
    ViewListPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ViewListPage');
    };
    return ViewListPage;
}());
ViewListPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-view-list',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\view-list\view-list.html"*/'<!--\n\n  Generated template for the ViewListPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header>\n\n    <ion-navbar color="primary">\n\n      <ion-buttons start>\n\n        <button ion-button menuToggle>\n\n          <ion-icon name="menu"></ion-icon>\n\n        </button>\n\n      </ion-buttons>\n\n      <ion-title>\n\n          <ion-row>\n\n              <ion-col col-9 class="nopadding">\n\n                  Lista numero 1\n\n     \n\n              </ion-col>\n\n              <ion-col col-3 class="nopadding" align="right">\n\n                  <ion-icon  ios="ios-create" md="md-create"></ion-icon>\n\n                  <ion-icon style="margin-left:15px;" ios="ios-trash" md="md-trash"></ion-icon>\n\n              </ion-col>\n\n              \n\n            </ion-row>\n\n      </ion-title>\n\n  \n\n    </ion-navbar>\n\n  </ion-header>\n\n\n\n\n\n<ion-content padding>\n\n\n\n  <h2 class="TituloLista">Nombre de la lista</h2>\n\n\n\n    <ion-list >\n\n        <ion-item *ngFor="let video of ListaDeVideos" >\n\n          <ion-thumbnail item-start id="List-img">\n\n            <img [src]="video.img">\n\n          </ion-thumbnail>\n\n          <ion-grid>\n\n            <ion-row>\n\n              <ion-col col-10 class="nopadding" >\n\n                <ion-row >\n\n                  <div class="ellipsis">\n\n                    <span class="List-title">{{video.title}}</span>\n\n                  </div>\n\n    \n\n                </ion-row>\n\n                <ion-row>\n\n                  <span class="List-amount">{{video.plays}} plays</span>\n\n                </ion-row>\n\n                <ion-row>\n\n                  <span class="List-duration">{{video.duration}}</span>\n\n                </ion-row>\n\n              </ion-col>\n\n              <ion-col col-2 class="nopadding" align="right">\n\n                <ion-icon class="f15 color-grey"  ios="ios-trash" md="md-trash"></ion-icon>\n\n              </ion-col>\n\n            </ion-row>\n\n          </ion-grid>\n\n        </ion-item>\n\n    \n\n      </ion-list>\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\view-list\view-list.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], ViewListPage);

//# sourceMappingURL=view-list.js.map

/***/ }),

/***/ 382:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PopOverListasReproduccionPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__edit_list_edit_list__ = __webpack_require__(137);
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
 * Generated class for the PopOverListasReproduccionPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var PopOverListasReproduccionPage = (function () {
    function PopOverListasReproduccionPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    PopOverListasReproduccionPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad PopOverListasReproduccionPage');
    };
    PopOverListasReproduccionPage.prototype.goToEditList = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__edit_list_edit_list__["a" /* EditListPage */]);
    };
    return PopOverListasReproduccionPage;
}());
PopOverListasReproduccionPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-pop-over-listas-reproduccion',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\pop-over-listas-reproduccion\pop-over-listas-reproduccion.html"*/'<ion-list >\n\n    <ion-item (click)="goToEditList()">\n\n      <ion-grid>\n\n        <ion-row > \n\n          <ion-col col-4 class="nopadding">\n\n              <ion-icon class="f21 color-blue" ios="ios-create" md="md-create"></ion-icon>\n\n          </ion-col>\n\n          <ion-col col-8 class="nopadding" align="right">\n\n              Editar lista \n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    \n\n    </ion-item>\n\n    <ion-item>\n\n        <ion-grid>\n\n          <ion-row>\n\n            <ion-col col-4 class="nopadding">\n\n                <ion-icon class="f21 color-blue" ios="ios-trash" md="md-trash"></ion-icon>\n\n            </ion-col>\n\n            <ion-col col-8 class="nopadding" align="right">\n\n                Eliminar lista \n\n            </ion-col>\n\n          </ion-row>\n\n        </ion-grid>\n\n      \n\n      </ion-item>\n\n    \n\n  </ion-list>'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\pop-over-listas-reproduccion\pop-over-listas-reproduccion.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], PopOverListasReproduccionPage);

//# sourceMappingURL=pop-over-listas-reproduccion.js.map

/***/ }),

/***/ 384:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(385);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(389);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 389:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(45);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(375);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__ = __webpack_require__(378);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__(749);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_ng2_charts__ = __webpack_require__(750);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_ng2_charts___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_ng2_charts__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_playlist_edit_list_edit_list__ = __webpack_require__(137);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__pages_playlist_view_list_view_list__ = __webpack_require__(381);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__pages_playlist_create_new_list_create_new_list__ = __webpack_require__(136);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__pages_playlist_add_list_add_list__ = __webpack_require__(380);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__pages_playlist_pop_over_listas_reproduccion_pop_over_listas_reproduccion__ = __webpack_require__(382);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__angular_http__ = __webpack_require__(335);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__pages_notificaciones_notificaciones__ = __webpack_require__(379);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__pages_configuracion_notificaciones_configuracion_notificaciones__ = __webpack_require__(135);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};












//Modificado Grupo 10



//Fin Modificado
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_7__pages_playlist_edit_list_edit_list__["a" /* EditListPage */],
            __WEBPACK_IMPORTED_MODULE_11__pages_playlist_pop_over_listas_reproduccion_pop_over_listas_reproduccion__["a" /* PopOverListasReproduccionPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_playlist_view_list_view_list__["a" /* ViewListPage */],
            __WEBPACK_IMPORTED_MODULE_10__pages_playlist_add_list_add_list__["a" /* AddListPage */],
            __WEBPACK_IMPORTED_MODULE_9__pages_playlist_create_new_list_create_new_list__["a" /* CreateNewListPage */],
            __WEBPACK_IMPORTED_MODULE_13__pages_notificaciones_notificaciones__["a" /* NotificacionesPage */],
            __WEBPACK_IMPORTED_MODULE_14__pages_configuracion_notificaciones_configuracion_notificaciones__["a" /* ConfiguracionNotificacionesPage */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["d" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */], {}, {
                links: [
                    { loadChildren: '../pages/configuracion-notificaciones/configuracion-notificaciones.module#ConfiguracionNotificacionesPageModule', name: 'ConfiguracionNotificacionesPage', segment: 'configuracion-notificaciones', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/canal/canal.module#CanalPageModule', name: 'CanalPage', segment: 'canal', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/estadistica/estadistica.module#EstadisticaPageModule', name: 'EstadisticaPage', segment: 'estadistica', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/inicio/inicio.module#InicioPageModule', name: 'InicioPage', segment: 'inicio', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/listas/listas.module#ListasPageModule', name: 'ListasPage', segment: 'listas', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/menu/menu.module#MenuPageModule', name: 'MenuPage', segment: 'menu', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/suscripciones/suscripciones.module#SuscripcionesPageModule', name: 'SuscripcionesPage', segment: 'suscripciones', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/tabs/tabs.module#TabsPageModule', name: 'TabsPage', segment: 'tabs', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/tendencias/tendencias.module#TendenciasPageModule', name: 'TendenciasPage', segment: 'tendencias', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/usuario/usuario.module#UsuarioPageModule', name: 'UsuarioPage', segment: 'usuario', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/notificaciones/notificaciones.module#NotificacionesPageModule', name: 'NotificacionesPage', segment: 'notificaciones', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/playlist/add-list/add-list.module#AddListPageModule', name: 'AddListPage', segment: 'add-list', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/playlist/create-new-list/create-new-list.module#CreateNewListPageModule', name: 'CreateNewListPage', segment: 'create-new-list', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/playlist/edit-list/edit-list.module#EditListPageModule', name: 'EditListPage', segment: 'edit-list', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/playlist/playlist.module#PlaylistPageModule', name: 'PlaylistPage', segment: 'playlist', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/playlist/pop-over-listas-reproduccion/pop-over-listas-reproduccion.module#PopOverListasReproduccionPageModule', name: 'PopOverListasReproduccionPage', segment: 'pop-over-listas-reproduccion', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/playlist/view-list/view-list.module#ViewListPageModule', name: 'ViewListPage', segment: 'view-list', priority: 'low', defaultHistory: [] }
                ]
            }),
            __WEBPACK_IMPORTED_MODULE_12__angular_http__["b" /* HttpModule */],
            __WEBPACK_IMPORTED_MODULE_6_ng2_charts__["ChartsModule"]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["b" /* IonicApp */]],
        entryComponents: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_7__pages_playlist_edit_list_edit_list__["a" /* EditListPage */],
            __WEBPACK_IMPORTED_MODULE_11__pages_playlist_pop_over_listas_reproduccion_pop_over_listas_reproduccion__["a" /* PopOverListasReproduccionPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_playlist_view_list_view_list__["a" /* ViewListPage */],
            __WEBPACK_IMPORTED_MODULE_10__pages_playlist_add_list_add_list__["a" /* AddListPage */],
            __WEBPACK_IMPORTED_MODULE_9__pages_playlist_create_new_list_create_new_list__["a" /* CreateNewListPage */],
            __WEBPACK_IMPORTED_MODULE_13__pages_notificaciones_notificaciones__["a" /* NotificacionesPage */],
            __WEBPACK_IMPORTED_MODULE_14__pages_configuracion_notificaciones_configuracion_notificaciones__["a" /* ConfiguracionNotificacionesPage */]
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__["a" /* StatusBar */],
            __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */],
            { provide: __WEBPACK_IMPORTED_MODULE_1__angular_core__["ErrorHandler"], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicErrorHandler */] }
        ]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 439:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"./af": 195,
	"./af.js": 195,
	"./ar": 196,
	"./ar-dz": 197,
	"./ar-dz.js": 197,
	"./ar-kw": 198,
	"./ar-kw.js": 198,
	"./ar-ly": 199,
	"./ar-ly.js": 199,
	"./ar-ma": 200,
	"./ar-ma.js": 200,
	"./ar-sa": 201,
	"./ar-sa.js": 201,
	"./ar-tn": 202,
	"./ar-tn.js": 202,
	"./ar.js": 196,
	"./az": 203,
	"./az.js": 203,
	"./be": 204,
	"./be.js": 204,
	"./bg": 205,
	"./bg.js": 205,
	"./bn": 206,
	"./bn.js": 206,
	"./bo": 207,
	"./bo.js": 207,
	"./br": 208,
	"./br.js": 208,
	"./bs": 209,
	"./bs.js": 209,
	"./ca": 210,
	"./ca.js": 210,
	"./cs": 211,
	"./cs.js": 211,
	"./cv": 212,
	"./cv.js": 212,
	"./cy": 213,
	"./cy.js": 213,
	"./da": 214,
	"./da.js": 214,
	"./de": 215,
	"./de-at": 216,
	"./de-at.js": 216,
	"./de-ch": 217,
	"./de-ch.js": 217,
	"./de.js": 215,
	"./dv": 218,
	"./dv.js": 218,
	"./el": 219,
	"./el.js": 219,
	"./en-au": 220,
	"./en-au.js": 220,
	"./en-ca": 221,
	"./en-ca.js": 221,
	"./en-gb": 222,
	"./en-gb.js": 222,
	"./en-ie": 223,
	"./en-ie.js": 223,
	"./en-nz": 224,
	"./en-nz.js": 224,
	"./eo": 225,
	"./eo.js": 225,
	"./es": 226,
	"./es-do": 227,
	"./es-do.js": 227,
	"./es.js": 226,
	"./et": 228,
	"./et.js": 228,
	"./eu": 229,
	"./eu.js": 229,
	"./fa": 230,
	"./fa.js": 230,
	"./fi": 231,
	"./fi.js": 231,
	"./fo": 232,
	"./fo.js": 232,
	"./fr": 233,
	"./fr-ca": 234,
	"./fr-ca.js": 234,
	"./fr-ch": 235,
	"./fr-ch.js": 235,
	"./fr.js": 233,
	"./fy": 236,
	"./fy.js": 236,
	"./gd": 237,
	"./gd.js": 237,
	"./gl": 238,
	"./gl.js": 238,
	"./gom-latn": 239,
	"./gom-latn.js": 239,
	"./he": 240,
	"./he.js": 240,
	"./hi": 241,
	"./hi.js": 241,
	"./hr": 242,
	"./hr.js": 242,
	"./hu": 243,
	"./hu.js": 243,
	"./hy-am": 244,
	"./hy-am.js": 244,
	"./id": 245,
	"./id.js": 245,
	"./is": 246,
	"./is.js": 246,
	"./it": 247,
	"./it.js": 247,
	"./ja": 248,
	"./ja.js": 248,
	"./jv": 249,
	"./jv.js": 249,
	"./ka": 250,
	"./ka.js": 250,
	"./kk": 251,
	"./kk.js": 251,
	"./km": 252,
	"./km.js": 252,
	"./kn": 253,
	"./kn.js": 253,
	"./ko": 254,
	"./ko.js": 254,
	"./ky": 255,
	"./ky.js": 255,
	"./lb": 256,
	"./lb.js": 256,
	"./lo": 257,
	"./lo.js": 257,
	"./lt": 258,
	"./lt.js": 258,
	"./lv": 259,
	"./lv.js": 259,
	"./me": 260,
	"./me.js": 260,
	"./mi": 261,
	"./mi.js": 261,
	"./mk": 262,
	"./mk.js": 262,
	"./ml": 263,
	"./ml.js": 263,
	"./mr": 264,
	"./mr.js": 264,
	"./ms": 265,
	"./ms-my": 266,
	"./ms-my.js": 266,
	"./ms.js": 265,
	"./my": 267,
	"./my.js": 267,
	"./nb": 268,
	"./nb.js": 268,
	"./ne": 269,
	"./ne.js": 269,
	"./nl": 270,
	"./nl-be": 271,
	"./nl-be.js": 271,
	"./nl.js": 270,
	"./nn": 272,
	"./nn.js": 272,
	"./pa-in": 273,
	"./pa-in.js": 273,
	"./pl": 274,
	"./pl.js": 274,
	"./pt": 275,
	"./pt-br": 276,
	"./pt-br.js": 276,
	"./pt.js": 275,
	"./ro": 277,
	"./ro.js": 277,
	"./ru": 278,
	"./ru.js": 278,
	"./sd": 279,
	"./sd.js": 279,
	"./se": 280,
	"./se.js": 280,
	"./si": 281,
	"./si.js": 281,
	"./sk": 282,
	"./sk.js": 282,
	"./sl": 283,
	"./sl.js": 283,
	"./sq": 284,
	"./sq.js": 284,
	"./sr": 285,
	"./sr-cyrl": 286,
	"./sr-cyrl.js": 286,
	"./sr.js": 285,
	"./ss": 287,
	"./ss.js": 287,
	"./sv": 288,
	"./sv.js": 288,
	"./sw": 289,
	"./sw.js": 289,
	"./ta": 290,
	"./ta.js": 290,
	"./te": 291,
	"./te.js": 291,
	"./tet": 292,
	"./tet.js": 292,
	"./th": 293,
	"./th.js": 293,
	"./tl-ph": 294,
	"./tl-ph.js": 294,
	"./tlh": 295,
	"./tlh.js": 295,
	"./tr": 296,
	"./tr.js": 296,
	"./tzl": 297,
	"./tzl.js": 297,
	"./tzm": 298,
	"./tzm-latn": 299,
	"./tzm-latn.js": 299,
	"./tzm.js": 298,
	"./uk": 300,
	"./uk.js": 300,
	"./ur": 301,
	"./ur.js": 301,
	"./uz": 302,
	"./uz-latn": 303,
	"./uz-latn.js": 303,
	"./uz.js": 302,
	"./vi": 304,
	"./vi.js": 304,
	"./x-pseudo": 305,
	"./x-pseudo.js": 305,
	"./yo": 306,
	"./yo.js": 306,
	"./zh-cn": 307,
	"./zh-cn.js": 307,
	"./zh-hk": 308,
	"./zh-hk.js": 308,
	"./zh-tw": 309,
	"./zh-tw.js": 309
};
function webpackContext(req) {
	return __webpack_require__(webpackContextResolve(req));
};
function webpackContextResolve(req) {
	var id = map[req];
	if(!(id + 1)) // check for number or string
		throw new Error("Cannot find module '" + req + "'.");
	return id;
};
webpackContext.keys = function webpackContextKeys() {
	return Object.keys(map);
};
webpackContext.resolve = webpackContextResolve;
module.exports = webpackContext;
webpackContext.id = 439;

/***/ }),

/***/ 457:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RestApiService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__ = __webpack_require__(458);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__(323);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(335);
//Clase que se encarga de enviar las solicitudes al servidor Rest Java
//En periodo de prueba, no se ha validado que funciona, pero es la estructura basica. 
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




//Direccion del servidor donde esta la BDD
var URL = 'http://localhost:8080/viucab';
var RestApiService = (function () {
    function RestApiService(http) {
        this.http = http;
    }
    //Metodo GET: /direccion
    //Accede al metodo que se encuentra en direccion y devuelve la respuesta
    RestApiService.prototype.getTodo = function (direccion) {
        console.log(URL + '/' + direccion);
        return this.http
            .get(URL + '/' + direccion)
            .map(function (data) { return data.json(); })
            .subscribe();
    };
    //Metodo GET: /direccion/id_objeto
    //Accede al metodo que se encuentra en direccion, enviando un id y devuelve la respuesta
    RestApiService.prototype.getUno = function (direccion, idObjeto) {
        return this.http
            .get(URL + '/' + direccion + '/' + idObjeto)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo GET: /direccion + (param)
    //Accede al metodo que se encuentra en direccion, enviando parametros y devuelve la respuesta
    RestApiService.prototype.getTodoParam = function (direccion, param) {
        return this.http
            .get(URL + '/' + direccion, param)
            .map(function (data) { return data.json(); })
            .subscribe();
    };
    //Metodo GET: /direccion + (param)
    //Accede al metodo que se encuentra en direccion, enviando un id y parametros y devuelve la respuesta
    RestApiService.prototype.getUnoParam = function (direccion, idObjeto, param) {
        return this.http
            .get(URL + '/' + direccion + '/' + idObjeto, param)
            .map(function (data) { return data.json(); })
            .subscribe();
    };
    //Metodo POST: /direccion
    //Actualiza o envia datos mas parametros a una direccion
    RestApiService.prototype.postTodo = function (direccion, datos, param) {
        return this.http
            .post(URL + '/' + direccion, datos, param)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo POST: /direccion/id_objeto
    //Actualiza el objeto id en una direccion. Es necesario el enviar el dato nuevo y los parametros
    RestApiService.prototype.postUno = function (direccion, idObjeto, dato, param) {
        return this.http
            .post(URL + '/' + direccion + "/" + idObjeto, dato, param)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo PUT: /direccion
    //Agrega en una direccion, envia los datos y el parametro
    RestApiService.prototype.putTodo = function (direccion, datos, param) {
        return this.http
            .put(URL + '/' + direccion, datos, param)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo PUT: /direccion/id_objeto
    //Agrega el objeto id en una direccion, envia los datos y el parametro
    RestApiService.prototype.putUno = function (direccion, idObjeto, dato, param) {
        return this.http
            .put(URL + '/' + direccion + '/' + idObjeto, dato, param)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo DELETE: /direccion
    //Elimina en una direccion, enviando parametros
    RestApiService.prototype.deleteTodo = function (direccion, param) {
        return this.http
            .delete(URL + '/' + direccion, param)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo DELETE: /direccion/id_objeto
    //Elimina un objeto en una direccion, es necesario el id y los parametros
    RestApiService.prototype.deleteUno = function (direccion, idObjeto, param) {
        return this.http
            .delete(URL + '/' + direccion + "/" + idObjeto, param)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo DELETE: /direccion
    //Elimina varios objetos en una direccion, es necesario la lista de objetos a eliminar y los parametros
    RestApiService.prototype.deleteVarios = function (direccion, dato, param) {
        return this.http
            .delete(URL + '/' + direccion, dato)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Manejo de erorres
    RestApiService.prototype.handleError = function (error) {
        console.error('ApiService::handleError', error);
        return __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__["Observable"].throw(error);
    };
    return RestApiService;
}());
RestApiService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* Http */]])
], RestApiService);

//# sourceMappingURL=rest-api.service.js.map

/***/ }),

/***/ 749:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(378);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(375);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var MyApp = (function () {
    function MyApp(platform, statusBar, splashScreen) {
        this.rootPage = 'MenuPage';
        platform.ready().then(function () {
            statusBar.styleDefault();
            splashScreen.hide();
        });
    }
    return MyApp;
}());
MyApp = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\app\app.html"*/'<ion-nav [root]="rootPage"></ion-nav>\n\n'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\app\app.html"*/
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* Platform */], __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */], __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */]])
], MyApp);

//# sourceMappingURL=app.component.js.map

/***/ })

},[384]);
//# sourceMappingURL=main.js.map