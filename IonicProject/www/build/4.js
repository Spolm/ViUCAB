webpackJsonp([4],{

/***/ 576:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PopOverListasReproduccionPageModule", function() { return PopOverListasReproduccionPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(54);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__pop_over_listas_reproduccion__ = __webpack_require__(588);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var PopOverListasReproduccionPageModule = (function () {
    function PopOverListasReproduccionPageModule() {
    }
    return PopOverListasReproduccionPageModule;
}());
PopOverListasReproduccionPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__pop_over_listas_reproduccion__["a" /* PopOverListasReproduccionPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["d" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__pop_over_listas_reproduccion__["a" /* PopOverListasReproduccionPage */]),
        ],
    })
], PopOverListasReproduccionPageModule);

//# sourceMappingURL=pop-over-listas-reproduccion.module.js.map

/***/ }),

/***/ 588:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PopOverListasReproduccionPage; });
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
    return PopOverListasReproduccionPage;
}());
PopOverListasReproduccionPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-pop-over-listas-reproduccion',template:/*ion-inline-start:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\Modulo 2\pop-over-listas-reproduccion\pop-over-listas-reproduccion.html"*/'<ion-list >\n    <ion-item>\n      <ion-grid>\n        <ion-row>\n          <ion-col col-4 class="nopadding">\n              <ion-icon class="f21 color-blue" ios="ios-create" md="md-create"></ion-icon>\n          </ion-col>\n          <ion-col col-8 class="nopadding" align="right">\n              Editar lista \n          </ion-col>\n        </ion-row>\n      </ion-grid>\n    \n    </ion-item>\n    <ion-item>\n        <ion-grid>\n          <ion-row>\n            <ion-col col-4 class="nopadding">\n                <ion-icon class="f21 color-blue" ios="ios-trash" md="md-trash"></ion-icon>\n            </ion-col>\n            <ion-col col-8 class="nopadding" align="right">\n                Eliminar lista \n            </ion-col>\n          </ion-row>\n        </ion-grid>\n      \n      </ion-item>\n    \n  </ion-list>'/*ion-inline-end:"C:\Users\veron\Documents\Desarrollo\ViUCAB\IonicProject\src\pages\Modulo 2\pop-over-listas-reproduccion\pop-over-listas-reproduccion.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], PopOverListasReproduccionPage);

//# sourceMappingURL=pop-over-listas-reproduccion.js.map

/***/ })

});
//# sourceMappingURL=4.js.map