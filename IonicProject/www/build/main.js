webpackJsonp([12],{

/***/ 138:
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
webpackEmptyAsyncContext.id = 138;

/***/ }),

/***/ 181:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../pages/Modulo 2/canal/canal.module": [
		571,
		9
	],
	"../pages/Modulo 2/estadistica/estadistica.module": [
		572,
		8
	],
	"../pages/Modulo 2/inicio/inicio.module": [
		573,
		7
	],
	"../pages/Modulo 2/listas/listas.module": [
		574,
		6
	],
	"../pages/Modulo 2/menu/menu.module": [
		575,
		5
	],
	"../pages/Modulo 2/pop-over-listas-reproduccion/pop-over-listas-reproduccion.module": [
		576,
		4
	],
	"../pages/Modulo 2/suscripciones/suscripciones.module": [
		578,
		3
	],
	"../pages/Modulo 2/tabs/tabs.module": [
		579,
		2
	],
	"../pages/Modulo 2/tendencias/tendencias.module": [
		580,
		1
	],
	"../pages/Modulo 2/usuario/usuario.module": [
		581,
		0
	],
	"../pages/configuracion-notificaciones/configuracion-notificaciones.module": [
		577,
		11
	],
	"../pages/notificaciones/notificaciones.module": [
		582,
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
webpackAsyncContext.id = 181;
module.exports = webpackAsyncContext;

/***/ }),

/***/ 251:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotificacionesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(54);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_rest_api_service__ = __webpack_require__(278);
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
    // goToConfiguracionNotificacion(params){
    //   if (!params) params = {};
    //   this.navCtrl.push(ConfiguracionNotificacionesPage);
    // }
    NotificacionesPage.prototype.goToConfiguracionNotificaciones = function (params) {
        console.log('entro aqui');
        var data = (this.api.getTodo('holamundo'));
        console.log(data);
    };
    return NotificacionesPage;
}());
NotificacionesPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-notificaciones',template:/*ion-inline-start:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\notificaciones\notificaciones.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n      <ion-icon name="menu"></ion-icon>\n\n    </button>\n\n    </ion-buttons>\n\n    <ion-title>\n\n      Notificaciones\n\n    </ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n<ion-content padding id="page1">\n\n  <button id="notificaciones-button1" ion-button color="light" block icon-right style="text-align:left;" on-click="goToConfiguracionNotificaciones()">\n\n    Configuración\n\n    <ion-icon name="settings"></ion-icon>\n\n  </button>\n\n  <ion-list id="notificaciones-list3">\n\n    <ion-item color="none" id="notificaciones-list-item10">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n    <ion-item color="none" id="notificaciones-list-item11">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n    <ion-item color="none" id="notificaciones-list-item12">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n    <ion-item color="none" id="notificaciones-list-item13">\n\n      <ion-thumbnail item-left>\n\n        <img />\n\n      </ion-thumbnail>\n\n      <h2>\n\n        Item\n\n      </h2>\n\n    </ion-item>\n\n  </ion-list>\n\n</ion-content>'/*ion-inline-end:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\notificaciones\notificaciones.html"*/,
        providers: [__WEBPACK_IMPORTED_MODULE_2__app_rest_api_service__["a" /* RestApiService */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__app_rest_api_service__["a" /* RestApiService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__app_rest_api_service__["a" /* RestApiService */]) === "function" && _c || Object])
], NotificacionesPage);

var _a, _b, _c;
//# sourceMappingURL=notificaciones.js.map

/***/ }),

/***/ 252:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ConfiguracionNotificacionesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(54);
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
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-configuracion-notificaciones',template:/*ion-inline-start:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\configuracion-notificaciones\configuracion-notificaciones.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n      <ion-icon name="menu"></ion-icon>\n\n    </button>\n\n  </ion-buttons>\n\n    <ion-title>\n\n      Configuración\n\n    </ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n<ion-content padding id="page3">\n\n  <div id="titulo" class="show-list-numbers-and-dots">\n\n      <strong>\n\n        Configuración de Notificaciones\n\n      </strong>\n\n  </div>\n\n  <form id="configuracion-form">\n\n    <ion-item id="notificaciones-toggle">\n\n      <ion-label>\n\n        Notificaciones\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="true"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="noletin-toggle">\n\n      <ion-label>\n\n        Boletín Semanal\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="true"></ion-toggle>\n\n    </ion-item>\n\n    <div id="mensaje" class="show-list-numbers-and-dots">\n\n        <strong>\n\n          Acepto recibir notificaciones a mi correo electrónico\n\n        </strong>\n\n    </div>\n\n    <ion-item id="videos-toggle">\n\n      <ion-label>\n\n        Videos Recomendados\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="subscripciones-toggle">\n\n      <ion-label>\n\n        Videos de Subscripciones\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="etiquetados-toggle">\n\n      <ion-label>\n\n        Videos Etiquetados\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n    <ion-item id="estadisticas-toggle">\n\n      <ion-label>\n\n        Estadísticas de Usuario\n\n      </ion-label>\n\n      <ion-toggle color="positive" checked="false"></ion-toggle>\n\n    </ion-item>\n\n  </form>\n\n</ion-content>'/*ion-inline-end:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\configuracion-notificaciones\configuracion-notificaciones.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], ConfiguracionNotificacionesPage);

//# sourceMappingURL=configuracion-notificaciones.js.map

/***/ }),

/***/ 253:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(254);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(258);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 258:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(39);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(54);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(247);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__ = __webpack_require__(250);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__(570);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_http__ = __webpack_require__(207);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_notificaciones_notificaciones__ = __webpack_require__(251);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__pages_configuracion_notificaciones_configuracion_notificaciones__ = __webpack_require__(252);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_7__pages_notificaciones_notificaciones__["a" /* NotificacionesPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_configuracion_notificaciones_configuracion_notificaciones__["a" /* ConfiguracionNotificacionesPage */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */], {}, {
                links: [
                    { loadChildren: '../pages/Modulo 2/canal/canal.module#CanalPageModule', name: 'CanalPage', segment: 'canal', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/estadistica/estadistica.module#EstadisticaPageModule', name: 'EstadisticaPage', segment: 'estadistica', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/inicio/inicio.module#InicioPageModule', name: 'InicioPage', segment: 'inicio', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/listas/listas.module#ListasPageModule', name: 'ListasPage', segment: 'listas', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/menu/menu.module#MenuPageModule', name: 'MenuPage', segment: 'menu', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/pop-over-listas-reproduccion/pop-over-listas-reproduccion.module#PopOverListasReproduccionPageModule', name: 'PopOverListasReproduccionPage', segment: 'pop-over-listas-reproduccion', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/configuracion-notificaciones/configuracion-notificaciones.module#ConfiguracionNotificacionesPageModule', name: 'ConfiguracionNotificacionesPage', segment: 'configuracion-notificaciones', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/suscripciones/suscripciones.module#SuscripcionesPageModule', name: 'SuscripcionesPage', segment: 'suscripciones', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/tabs/tabs.module#TabsPageModule', name: 'TabsPage', segment: 'tabs', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/tendencias/tendencias.module#TendenciasPageModule', name: 'TendenciasPage', segment: 'tendencias', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/Modulo 2/usuario/usuario.module#UsuarioPageModule', name: 'UsuarioPage', segment: 'usuario', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/notificaciones/notificaciones.module#NotificacionesPageModule', name: 'NotificacionesPage', segment: 'notificaciones', priority: 'low', defaultHistory: [] }
                ]
            }),
            __WEBPACK_IMPORTED_MODULE_6__angular_http__["b" /* HttpModule */],
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["a" /* IonicApp */]],
        entryComponents: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_7__pages_notificaciones_notificaciones__["a" /* NotificacionesPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_configuracion_notificaciones_configuracion_notificaciones__["a" /* ConfiguracionNotificacionesPage */]
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__["a" /* StatusBar */],
            __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */],
            { provide: __WEBPACK_IMPORTED_MODULE_1__angular_core__["v" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["b" /* IonicErrorHandler */] }
        ]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 278:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RestApiService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__ = __webpack_require__(279);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__(195);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(207);
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
var URL = 'http://localhost:8080/viucab/hola';
var RestApiService = (function () {
    function RestApiService(http) {
        this.http = http;
    }
    //Metodo GET: /listaObjetos
    //Devuelve todos los objetos
    RestApiService.prototype.getTodo = function (objetos) {
        console.log(URL + '/' + objetos);
        return this.http
            .get(URL + '/' + objetos);
    };
    //Metodo GET: /listaObjetos/id_objeto
    //Devuelve un objeto, es necesario el id
    RestApiService.prototype.getUno = function (objetos, id) {
        return this.http
            .get(URL + '/' + objetos + '/' + id)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo POST: /listaObjetos
    //Actualiza varios datos de un tipo objeto
    RestApiService.prototype.postTodo = function (objetos, datos) {
        return this.http
            .post(URL + '/' + objetos, datos)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo POST: /listaObjetos/id_objeto
    //Actualiza un dato de tipo objeto. Es necesario el id
    RestApiService.prototype.postUno = function (objetos, id, dato) {
        return this.http
            .post(URL + '/' + objetos + "/" + id, dato)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo PUT: /listaObjetos
    //Agrega varios datos de tipo objetos
    RestApiService.prototype.putTodo = function (objetos, datos) {
        return this.http
            .put(URL + '/' + objetos, datos)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo PUT: /listaObjetos/id_objeto
    //Agrega un dato de tipo objetos
    RestApiService.prototype.putUno = function (objetos, dato) {
        return this.http
            .put(URL + '/' + objetos, dato)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo DELETE: /listaObjetos
    //Elimina todos los objetos
    RestApiService.prototype.deleteTodo = function (objetos) {
        return this.http
            .delete(URL + '/' + objetos)
            .map(function (data) { return data.json(); })
            .catch(this.handleError);
    };
    //Metodo DELETE: /listaObjetos/id_objeto
    //Elimina un dato de un objeto, es necesario el id
    RestApiService.prototype.deleteUno = function (objetos, id) {
        return this.http
            .delete(URL + '/' + objetos + "/" + id)
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
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["B" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* Http */]) === "function" && _a || Object])
], RestApiService);

var _a;
//# sourceMappingURL=rest-api.service.js.map

/***/ }),

/***/ 570:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(54);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(250);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(247);
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
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({template:/*ion-inline-start:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\app\app.html"*/'<ion-nav [root]="rootPage"></ion-nav>\n'/*ion-inline-end:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\app\app.html"*/
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* Platform */], __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */], __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */]])
], MyApp);

//# sourceMappingURL=app.component.js.map

/***/ })

},[253]);
//# sourceMappingURL=main.js.map