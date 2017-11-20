webpackJsonp([0],{

/***/ 581:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioPageModule", function() { return UsuarioPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(54);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__usuario__ = __webpack_require__(592);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var UsuarioPageModule = (function () {
    function UsuarioPageModule() {
    }
    return UsuarioPageModule;
}());
UsuarioPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__usuario__["a" /* UsuarioPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__usuario__["a" /* UsuarioPage */]),
        ],
    })
], UsuarioPageModule);

//# sourceMappingURL=usuario.module.js.map

/***/ }),

/***/ 592:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UsuarioPage; });
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


/**
 * Generated class for the UsuarioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var UsuarioPage = (function () {
    function UsuarioPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    UsuarioPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad UsuarioPage');
    };
    return UsuarioPage;
}());
UsuarioPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-usuario',template:/*ion-inline-start:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\Modulo 2\usuario\usuario.html"*/'<ion-header>\n  <ion-navbar color="primary">\n    <ion-buttons start>\n      <button ion-button menuToggle>\n      <ion-icon name="menu"></ion-icon>\n    </button>\n    </ion-buttons>\n    <ion-title>\n      <ion-icon name="logo-youtube"> ViUCAB</ion-icon>\n      <ion-buttons class= \'centrado-porcentual\'  >\n          <button  >\n        <ion-icon name="videocam" color="primary"></ion-icon>   \n      </button>\n      </ion-buttons>   \n    \n    </ion-title>\n    \n  </ion-navbar>\n</ion-header>\n \n<ion-content padding>\n   \n  \n\n     \n</ion-content>\n'/*ion-inline-end:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\Modulo 2\usuario\usuario.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], UsuarioPage);

//# sourceMappingURL=usuario.js.map

/***/ })

});
//# sourceMappingURL=0.js.map