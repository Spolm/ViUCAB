webpackJsonp([0],{

/***/ 766:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PlaylistPageModule", function() { return PlaylistPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__playlist__ = __webpack_require__(778);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var PlaylistPageModule = (function () {
    function PlaylistPageModule() {
    }
    return PlaylistPageModule;
}());
PlaylistPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__playlist__["a" /* PlaylistPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__playlist__["a" /* PlaylistPage */]),
        ],
    })
], PlaylistPageModule);

//# sourceMappingURL=playlist.module.js.map

/***/ }),

/***/ 778:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PlaylistPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__view_list_view_list__ = __webpack_require__(381);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__playlist_pop_over_listas_reproduccion_pop_over_listas_reproduccion__ = __webpack_require__(382);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__add_list_add_list__ = __webpack_require__(380);
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
 * Generated class for the ListasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var PlaylistPage = (function () {
    function PlaylistPage(navCtrl, navParams, popoverCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.popoverCtrl = popoverCtrl;
        this.ListasDeReproduccion = [
            { title: 'Lista numero 1', amount: '13', duration: '30:00 min', img: 'https://www.lapatilla.com/site/wp-content/uploads/2017/08/Meme.x43795.jpg' },
            { title: 'Lista numero 2', amount: '3', duration: '3:00 min', img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho' },
            { title: 'Lista numero 3', amount: '1', duration: '39:05 min', img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho' },
        ];
    }
    PlaylistPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ListasPage');
        this.tab = 'mias';
    };
    PlaylistPage.prototype.presentPopover = function (myEvent) {
        var popover = this.popoverCtrl.create(__WEBPACK_IMPORTED_MODULE_3__playlist_pop_over_listas_reproduccion_pop_over_listas_reproduccion__["a" /* PopOverListasReproduccionPage */]);
        popover.present({
            ev: myEvent
        });
    };
    PlaylistPage.prototype.goToViewList = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__view_list_view_list__["a" /* ViewListPage */]);
    };
    PlaylistPage.prototype.goToAddList = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_4__add_list_add_list__["a" /* AddListPage */]);
    };
    return PlaylistPage;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])('myNav'),
    __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */])
], PlaylistPage.prototype, "nav", void 0);
PlaylistPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'page-playlist',template:/*ion-inline-start:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\playlist.html"*/'<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-buttons start>\n\n      <button ion-button menuToggle>\n\n        <ion-icon name="menu"></ion-icon>\n\n      </button>\n\n    </ion-buttons>\n\n    <ion-title>\n\n\n\n      <ion-buttons class=\'centrado-porcentual\'>\n\n        <button>\n\n          <ion-icon name="videocam" color="primary"></ion-icon>\n\n        </button>\n\n      </ion-buttons>\n\n      Listas de Reproducción\n\n\n\n\n\n    </ion-title>\n\n\n\n  </ion-navbar>\n\n\n\n  <div>\n\n    <ion-segment [(ngModel)]="tab">\n\n      <ion-segment-button value="mias">\n\n        MIAS\n\n      </ion-segment-button>\n\n      <ion-segment-button value="sugeridas">\n\n        SUGERIDAS\n\n      </ion-segment-button>\n\n    </ion-segment>\n\n  </div>\n\n</ion-header>\n\n\n\n<ion-content padding>\n\n\n\n\n\n  <!-- <button ion-button (click)="goToEditList()">Editar</button>\n\n\n\n -->\n\n\n\n\n\n\n\n<div [ngSwitch]="tab">\n\n  <ion-list *ngSwitchCase="\'mias\'">\n\n\n\n    <button ion-button (click)="goToAddList()" >Agregar Lista</button>\n\n\n\n    <ion-item *ngFor="let lista of ListasDeReproduccion" >\n\n      <ion-thumbnail item-start id="List-img" (click)="goToViewList()">\n\n        <img [src]="lista.img">\n\n      </ion-thumbnail>\n\n      <ion-grid>\n\n        <ion-row>\n\n          <ion-col col-10 class="nopadding" (click)="goToViewList()">\n\n            <ion-row >\n\n              <div class="ellipsis">\n\n                <span class="List-title">{{lista.title}}</span>\n\n              </div>\n\n\n\n            </ion-row>\n\n            <ion-row>\n\n              <span class="List-amount">{{lista.amount}} videos</span>\n\n            </ion-row>\n\n            <ion-row>\n\n              <span class="List-duration">{{lista.duration}}</span>\n\n            </ion-row>\n\n          </ion-col>\n\n          <ion-col col-2 class="nopadding" align="right">\n\n            <ion-icon class="f15 color-grey" (click)="presentPopover($event)"  ios="ios-more" md="md-more"></ion-icon>\n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n\n\n  </ion-list>\n\n\n\n  <ion-list no-lines *ngSwitchCase="\'sugeridas\'">\n\n\n\n    <ion-item>\n\n      <ion-grid>\n\n        <ion-row>\n\n          <ion-col col-3>\n\n            <ion-icon name="american-football" class="grande"></ion-icon>\n\n          </ion-col>\n\n          <ion-col col-9 class="paddingtop15">\n\n            <h1>Deportes</h1>\n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n\n\n    <ion-item>\n\n      <ion-grid>\n\n        <ion-row>\n\n          <ion-col col-3>\n\n            <ion-icon name="game-controller-b" class="grande"></ion-icon>\n\n          </ion-col>\n\n          <ion-col col-9 class="paddingtop15">\n\n            <h1>Videojuegos</h1>\n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n\n\n    <ion-item>\n\n      <ion-grid>\n\n        <ion-row>\n\n          <ion-col col-3>\n\n            <ion-icon ios="ios-musical-notes" md="md-musical-notes" class="grande"></ion-icon>\n\n          </ion-col>\n\n          <ion-col col-9 class="paddingtop15">\n\n            <h1>Música</h1>\n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n\n\n    <ion-item>\n\n      <ion-grid>\n\n        <ion-row>\n\n          <ion-col col-3>\n\n            <ion-icon name="happy" class="grande"></ion-icon>\n\n          </ion-col>\n\n          <ion-col col-9 class="paddingtop15">\n\n            <h1>Comedia</h1>\n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n\n\n    <ion-item>\n\n      <ion-grid>\n\n        <ion-row>\n\n          <ion-col col-3>\n\n            <ion-icon name="color-palette" class="grande"></ion-icon>\n\n          </ion-col>\n\n          <ion-col col-9 class="paddingtop15">\n\n            <h1>Arte</h1>\n\n          </ion-col>\n\n        </ion-row>\n\n      </ion-grid>\n\n    </ion-item>\n\n  </ion-list>\n\n</div>\n\n\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Usuario\Documents\Universidad\Desarrollo\Proyecto\Proyecto1\PruebaGit\ViUCAB\IonicProject\src\pages\playlist\playlist.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["j" /* PopoverController */]])
], PlaylistPage);

//# sourceMappingURL=playlist.js.map

/***/ })

});
//# sourceMappingURL=0.js.map