webpackJsonp([2],{

/***/ 760:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TendenciasPageModule", function() { return TendenciasPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__tendencias__ = __webpack_require__(776);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var TendenciasPageModule = (function () {
    function TendenciasPageModule() {
    }
    return TendenciasPageModule;
}());
TendenciasPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__tendencias__["a" /* TendenciasPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__tendencias__["a" /* TendenciasPage */]),
        ],
    })
], TendenciasPageModule);

//# sourceMappingURL=tendencias.module.js.map

/***/ }),

/***/ 776:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TendenciasPage; });
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
 * Generated class for the TendenciasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var TendenciasPage = (function () {
    function TendenciasPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    TendenciasPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad TendenciasPage');
    };
    return TendenciasPage;
}());
TendenciasPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-tendencias',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\Modulo 2\tendencias\tendencias.html"*/'<ion-header>\n\n    <ion-navbar color="primary">\n\n      <ion-buttons start>\n\n        <button ion-button menuToggle>\n\n        <ion-icon name="menu"></ion-icon>\n\n      </button>\n\n      </ion-buttons>\n\n      <ion-title>\n\n        <ion-icon name="logo-youtube"> ViUCAB</ion-icon>\n\n        \n\n        <ion-buttons class= \'centrado-Lupa\'  >   \n\n          <button  >\n\n           <ion-icon name="search"></ion-icon>\n\n        </button>\n\n        </ion-buttons>   \n\n  \n\n        <ion-buttons class= \'centrado-porcentual\'  >\n\n            <button  >\n\n  \n\n          <ion-icon name="videocam" color="primary"></ion-icon>   \n\n        </button>\n\n        </ion-buttons>   \n\n      \n\n      </ion-title>\n\n      \n\n    </ion-navbar>\n\n  </ion-header>\n\n   \n\n  <ion-content padding>\n\n     \n\n    \n\n  \n\n       \n\n  </ion-content>'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\Modulo 2\tendencias\tendencias.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], TendenciasPage);

//# sourceMappingURL=tendencias.js.map

/***/ })

});
//# sourceMappingURL=2.js.map