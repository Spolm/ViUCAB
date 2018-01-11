webpackJsonp([4],{

/***/ 107:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomecablePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_angularfire2_auth__ = __webpack_require__(45);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var HomecablePage = (function () {
    function HomecablePage(fire, navCtrl, navParams, app) {
        this.fire = fire;
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.app = app;
        //
        this.email = fire.auth.currentUser.email;
    }
    HomecablePage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad HomecablePage');
    };
    //
    /**
  Se usa para devolverte a una pagina
   */
    HomecablePage.prototype.logout = function () {
        var root = this.app.getRootNav();
        root.popToRoot();
    };
    return HomecablePage;
}());
HomecablePage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-homecable',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\homecable\homecable.html"*/'<!--\n\n  Generated template for the HomecablePage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header>\n\n\n\n  <ion-navbar color="primary">\n\n    <ion-title>HOMEEEEE</ion-title>\n\n  </ion-navbar>\n\n\n\n</ion-header>\n\n\n\n\n\n<ion-content padding>\n\n   {{email}}\n\n    <!--    <button ion-button block outline (click)="logout()" >lOG OUT</button>\n\n  -->\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\homecable\homecable.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2_angularfire2_auth__["a" /* AngularFireAuth */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["b" /* App */]])
], HomecablePage);

//# sourceMappingURL=homecable.js.map

/***/ }),

/***/ 111:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(17);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__olvidar_contrase_a_olvidar_contrase_a__ = __webpack_require__(208);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__registrarse_registrarse__ = __webpack_require__(209);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angularfire2_auth__ = __webpack_require__(45);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__homecable_homecable__ = __webpack_require__(107);
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
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
//
var LoginPage = (function () {
    function LoginPage(fire, navCtrl, navParams, alertCtrl, formBuilder) {
        this.fire = fire;
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
        this.formBuilder = formBuilder;
        this.myForm = this.formBuilder.group({
            email: ['', [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].email]],
            password: ['', [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].pattern(/^[a-z0-9_-]{6,18}$/)]]
        });
    }
    LoginPage.prototype.saveData = function () {
        console.log(this.myForm.value);
    };
    LoginPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad LoginPage');
    };
    LoginPage.prototype.alert = function (message) {
        this.alertCtrl.create({
            title: 'Info!',
            subTitle: message,
            buttons: ['OK']
        }).present();
    };
    LoginPage.prototype.IniciarS = function () {
        var _this = this;
        this.fire.auth.signInWithEmailAndPassword(this.usu.value, this.passw.value)
            .then(function (data) {
            console.log('agarra la data', _this.fire.auth.currentUser);
            _this.alert('Exito! tu te logeaste');
            _this.navCtrl.setRoot(__WEBPACK_IMPORTED_MODULE_6__homecable_homecable__["a" /* HomecablePage */]);
            //el usuario es logeado
        })
            .catch(function (error) {
            console.log('encontramos error', error);
            _this.alert(error.message);
        });
        console.log('Iniciar sesion con', this.usu.value, this.passw.value);
        // console.log(this.usu.value, this.passw.value)
        // -------codigo para validacion-----
        /*
      if(this.usu.value == "luis" && this.passw.value == "admin"){
        let alert = this.alertCtrl.create({
    
          title: 'Logeaste correctamentes',
          subTitle: 'Excelente!',
          buttons: ['OK']
        
        });
        alert.present();
        this.navCtrl.push(HomecablePage);
      }else{
    
        let alert = this.alertCtrl.create({
          
              title: 'ERROR!!!',
              subTitle: 'Usuario o contraseña incorrectas!',
              buttons: ['OK']
            
            });
            alert.present();
    
      }*/
    };
    LoginPage.prototype.goPaginaOlvidarcontra = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_3__olvidar_contrase_a_olvidar_contrase_a__["a" /* OlvidarContraseñaPage */]);
    };
    LoginPage.prototype.goPaginaRegistrar = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_4__registrarse_registrarse__["a" /* RegistrarsePage */]);
        {
        }
    };
    //Funcion mostrar confirmacion
    LoginPage.prototype.showConfirm = function () {
        var confirm = this.alertCtrl.create({
            title: 'Use this lightsaber?',
            message: 'Do you agree to use this lightsaber to do good across the intergalactic galaxy?',
            buttons: [
                {
                    text: 'Disagree',
                    handler: function () {
                        console.log('Disagree clicked');
                    }
                },
                {
                    text: 'Agree',
                    handler: function () {
                        console.log('Agree clicked');
                    }
                }
            ]
        });
        confirm.present();
    };
    return LoginPage;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* ViewChild */])('email'),
    __metadata("design:type", Object)
], LoginPage.prototype, "usu", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* ViewChild */])('password'),
    __metadata("design:type", Object)
], LoginPage.prototype, "passw", void 0);
LoginPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-login',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\login\login.html"*/'<!--\n\n  Generated template for the LoginPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header >\n\n  <ion-navbar color="primary">\n\n    <ion-title>Login</ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n\n\n<!-- <ion-input formControlName="name" type="text" ></ion-input>-->\n\n\n\n<ion-content padding >\n\n  <form [formGroup]="myForm" (ngSubmit)="saveData()" novalidate> \n\n    \n\n      <ion-img width="200" height="200" class="center" src="assets/imgs/Logo1.png"></ion-img>\n\n    <ion-list>\n\n\n\n      <ion-item>\n\n        <ion-icon name="mail" item-start></ion-icon>\n\n        <ion-label floating>Correo electronico</ion-label>\n\n        <ion-input formControlName="email" type="email" value="" #Usuario></ion-input>\n\n      </ion-item>\n\n\n\n      <ion-item>\n\n        <ion-icon name="eye" item-start></ion-icon>\n\n        <ion-label floating>Contraseña</ion-label>\n\n        <ion-input formControlName="password" type="password" value="" #Contraseña></ion-input>    \n\n      </ion-item>\n\n\n\n    </ion-list>\n\n    \n\n    <div padding>\n\n        <button ion-button block type="submit"  clear (click)=\'IniciarS()\' >Iniciar sesion</button>\n\n    </div>\n\n    <div padding>\n\n        <button ion-button block clear (click)=\'goPaginaRegistrar()\'  >Crear una cuenta</button>\n\n    </div>\n\n    <div padding>\n\n        <button ion-button block clear (click)=\'goPaginaOlvidarcontra()\'  >Olvidaste tu contraseña ?</button>\n\n    </div>\n\n  </form>\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\login\login.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_5_angularfire2_auth__["a" /* AngularFireAuth */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */],
        __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormBuilder */]])
], LoginPage);

//# sourceMappingURL=login.js.map

/***/ }),

/***/ 153:
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
webpackEmptyAsyncContext.id = 153;

/***/ }),

/***/ 195:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../pages/M01-Login/categoria/categoria.module": [
		455,
		0
	],
	"../pages/M01-Login/homecable/homecable.module": [
		196
	],
	"../pages/M01-Login/invitacion-google/invitacion-google.module": [
		456,
		3
	],
	"../pages/M01-Login/invitacion-twitter/invitacion-twitter.module": [
		205
	],
	"../pages/M01-Login/login/login.module": [
		207
	],
	"../pages/M01-Login/olvidar-contraseña/olvidar-contraseña.module": [
		244
	],
	"../pages/M01-Login/registrarse/registrarse.module": [
		245
	],
	"../pages/M01-Login/signup/signup.module": [
		457,
		2
	],
	"../pages/M01-Login/sugerencia/sugerencia.module": [
		458,
		1
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return Promise.all(ids.slice(1).map(__webpack_require__.e)).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = 195;
module.exports = webpackAsyncContext;

/***/ }),

/***/ 196:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomecablePageModule", function() { return HomecablePageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__homecable__ = __webpack_require__(107);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var HomecablePageModule = (function () {
    function HomecablePageModule() {
    }
    return HomecablePageModule;
}());
HomecablePageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__homecable__["a" /* HomecablePage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__homecable__["a" /* HomecablePage */]),
        ],
    })
], HomecablePageModule);

//# sourceMappingURL=homecable.module.js.map

/***/ }),

/***/ 205:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvitacionTwitterPageModule", function() { return InvitacionTwitterPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__invitacion_twitter__ = __webpack_require__(206);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var InvitacionTwitterPageModule = (function () {
    function InvitacionTwitterPageModule() {
    }
    return InvitacionTwitterPageModule;
}());
InvitacionTwitterPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__invitacion_twitter__["a" /* InvitacionTwitterPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__invitacion_twitter__["a" /* InvitacionTwitterPage */]),
        ],
    })
], InvitacionTwitterPageModule);

//# sourceMappingURL=invitacion-twitter.module.js.map

/***/ }),

/***/ 206:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InvitacionTwitterPage; });
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
 * Generated class for the InvitacionTwitterPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var InvitacionTwitterPage = (function () {
    function InvitacionTwitterPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    InvitacionTwitterPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad InvitacionTwitterPage');
    };
    return InvitacionTwitterPage;
}());
InvitacionTwitterPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-invitacion-twitter',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\invitacion-twitter\invitacion-twitter.html"*/'<!--\n\n  Generated template for the InvitacionTwitterPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header>\n\n\n\n  <ion-navbar color="primary">\n\n    <ion-title>Invitar amigos twitter</ion-title>\n\n  </ion-navbar>\n\n\n\n</ion-header>\n\n\n\n\n\n<ion-content padding>\n\n\n\n  <ion-list >\n\n    <h4 style="color:#000000;font-weight:600;text-align:center;">Cuentales a tus amigos de nosotros : </h4>\n\n    <ion-icon aling="left" ios="logo-twitter" md="logo-twitter"></ion-icon>\n\n  \n\n    </ion-list>\n\n    \n\n    <div padding>\n\n      <button ion-button block outline  >Invitar</button>\n\n  </div>\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\invitacion-twitter\invitacion-twitter.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]])
], InvitacionTwitterPage);

//# sourceMappingURL=invitacion-twitter.js.map

/***/ }),

/***/ 207:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginPageModule", function() { return LoginPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__login__ = __webpack_require__(111);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var LoginPageModule = (function () {
    function LoginPageModule() {
    }
    return LoginPageModule;
}());
LoginPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__login__["a" /* LoginPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__login__["a" /* LoginPage */]),
        ],
    })
], LoginPageModule);

//# sourceMappingURL=login.module.js.map

/***/ }),

/***/ 208:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OlvidarContraseñaPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(17);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_angularfire2_auth__ = __webpack_require__(45);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__login_login__ = __webpack_require__(111);
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
 * Generated class for the OlvidarContraseñaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var OlvidarContraseñaPage = (function () {
    function OlvidarContraseñaPage(fire, navCtrl, navParams, alertCtrl, formBuilder) {
        this.fire = fire;
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
        this.formBuilder = formBuilder;
        this.myForm = this.formBuilder.group({
            email: ['', [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].email]]
        });
    }
    OlvidarContraseñaPage.prototype.saveData = function () {
        console.log(this.myForm.value);
    };
    OlvidarContraseñaPage.prototype.alert = function (info, message) {
        this.alertCtrl.create({
            title: info,
            subTitle: message,
            buttons: ['OK']
        }).present();
    };
    OlvidarContraseñaPage.prototype.verificacion = function () {
        if (this.email.value == "fer@gmail.com") {
            this.alert('Recuperacion de contraseña', 'Hemos enviado tu contraseña a tu correo');
            this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_4__login_login__["a" /* LoginPage */]);
        }
        else {
            this.alert('Datos incorrectos', 'El correo no esta registrado');
        }
    };
    OlvidarContraseñaPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad OlvidarContraseñaPage');
    };
    return OlvidarContraseñaPage;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* ViewChild */])('email'),
    __metadata("design:type", Object)
], OlvidarContraseñaPage.prototype, "email", void 0);
OlvidarContraseñaPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-olvidar-contrasena',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\olvidar-contraseña\olvidar-contraseña.html"*/'<!--\n\n  Generated template for the OlvidarContraseñaPage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header>\n\n  <ion-navbar color="primary">\n\n    <ion-title>Recuperar contraseña</ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n\n\n\n\n<ion-content padding>\n\n    <form > \n\n        <ion-img width="200" height="200" class="center1"  src="assets/imgs/Logo candado.jpg"></ion-img>\n\n        <h4 style="color:#000000;font-weight:600;text-align:center;">¿No recuerdas tu contraseña? </h4>\n\n        <p style="color:#000000;font-weight:600;text-align:center;">Ingresa tu correo electronico y te enviaremos tu contraseña </p>\n\n    </form>\n\n    <form [formGroup]="myForm" (ngSubmit)="saveData()" novalidate>             \n\n        <ion-list id="recuperarContraseA-list4">\n\n            <ion-item>\n\n                <ion-label style="text-align:center;" floating>Correo electronico</ion-label>\n\n                <ion-input formControlName="email" type="email" value="" #email></ion-input>\n\n            </ion-item>\n\n            <ion-item *ngIf="myForm.get(\'email\').errors && myForm.get(\'email\').dirty">\n\n                <p color="danger" ion-text *ngIf="myForm.get(\'email\').hasError(\'required\')">Field is required</p>\n\n                <p color="danger" ion-text *ngIf="myForm.get(\'email\').hasError(\'email\')">It is not an email</p>\n\n            </ion-item>\n\n    \n\n            </ion-list>\n\n            <div padding>\n\n                    <button ion-button block type="submit" [disabled]="myForm.invalid" clear (click)=\'verificacion()\' icon-end >Enviar Correo</button>\n\n            </div>\n\n     \n\n    </form>\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\olvidar-contraseña\olvidar-contraseña.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3_angularfire2_auth__["a" /* AngularFireAuth */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */],
        __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */],
        __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormBuilder */]])
], OlvidarContraseñaPage);

//# sourceMappingURL=olvidar-contraseña.js.map

/***/ }),

/***/ 209:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegistrarsePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(17);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_angularfire2_auth__ = __webpack_require__(45);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__homecable_homecable__ = __webpack_require__(107);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_firebase__ = __webpack_require__(367);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_firebase___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_firebase__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var RegistrarsePage = (function () {
    function RegistrarsePage(alertCtrl, fire, navCtrl, navParams, formbuilder) {
        this.alertCtrl = alertCtrl;
        this.fire = fire;
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.formbuilder = formbuilder;
        //objeto para facebook
        //
        //
        //
        ////
        this.provider = {
            name: '',
            profilePicture: '',
            email: '',
            loggedin: false
        };
        this.userData = null;
        this.myForm = this.formbuilder.group({
            email: ['', [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].email]],
            Contraseña: ['', [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].pattern(/^[a-z0-9_-]{6,18}$/)]],
            RepetirContraseña: ['', [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["f" /* Validators */].pattern(/^[a-z0-9_-]{6,18}$/)]],
        });
        this.email = this.myForm.controls['email'];
        this.Contraseña = this.myForm.controls['Contraseña'];
        this.RepetirContraseña = this.myForm.controls['RepetirContraseña'];
    }
    RegistrarsePage.prototype.saveData = function () {
        console.log(this.myForm.value);
    };
    RegistrarsePage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad RegistrarsePage');
    };
    //
    //PARA EL WS
    //----para los mensajes de alerta
    RegistrarsePage.prototype.alert = function (message) {
        this.alertCtrl.create({
            title: 'Info!',
            subTitle: message,
            buttons: ['OK']
        }).present();
    };
    //--Registrar usuario normal
    RegistrarsePage.prototype.registerUser = function () {
        var _this = this;
        this.fire.auth.createUserWithEmailAndPassword(this.usu.value, this.passw.value)
            .then(function (data) {
            console.log('agarre  data ', data);
            _this.alert('Registrado!');
            _this.navCtrl.setRoot(__WEBPACK_IMPORTED_MODULE_4__homecable_homecable__["a" /* HomecablePage */]);
        })
            .catch(function (error) {
            console.log('got error', error);
            _this.alert(error.message);
        });
        console.log('registrar con', this.usu.value, this.passw.value);
    };
    //--Registrar por facebook google twitter
    RegistrarsePage.prototype.loginWithFacebook = function () {
        var _this = this;
        this.fire.auth.signInWithPopup(new __WEBPACK_IMPORTED_MODULE_5_firebase___default.a.auth.FacebookAuthProvider())
            .then(function (res) {
            _this.provider.loggedin = true;
            _this.provider.name = res.user.displayName;
            _this.provider.email = res.user.email;
            _this.provider.profilePicture = res.user.photoURL;
            console.log(res);
            _this.navCtrl.setRoot(__WEBPACK_IMPORTED_MODULE_4__homecable_homecable__["a" /* HomecablePage */]);
            _this.alert('Exito! tu te logeaste');
        })
            .catch(function (error) {
            console.log('encontramos error', error);
            _this.alert(error.message);
        });
    };
    RegistrarsePage.prototype.loginWithGoogle = function () {
        var _this = this;
        this.fire.auth.signInWithPopup(new __WEBPACK_IMPORTED_MODULE_5_firebase___default.a.auth.GoogleAuthProvider())
            .then(function (res) {
            console.log('fdesde --google--');
            console.log(res);
            _this.provider.loggedin = true;
            _this.provider.name = res.user.displayName;
            _this.provider.email = res.user.email;
            _this.provider.profilePicture = res.user.photoURL;
            console.log(res);
            _this.navCtrl.setRoot(__WEBPACK_IMPORTED_MODULE_4__homecable_homecable__["a" /* HomecablePage */]);
            _this.alert('Exito! tu te logeaste');
        })
            .catch(function (error) {
            console.log('encontramos error', error);
            _this.alert(error.message);
        });
    };
    RegistrarsePage.prototype.loginWithTwitter = function () {
        var _this = this;
        this.fire.auth.signInWithPopup(new __WEBPACK_IMPORTED_MODULE_5_firebase___default.a.auth.TwitterAuthProvider())
            .then(function (res) {
            console.log('fdesde --twitter--');
            console.log(res);
            _this.provider.loggedin = true;
            _this.provider.name = res.user.displayName;
            _this.provider.email = res.user.email;
            _this.provider.profilePicture = res.user.photoURL;
            _this.navCtrl.setRoot(__WEBPACK_IMPORTED_MODULE_4__homecable_homecable__["a" /* HomecablePage */]);
            _this.alert('Exito! tu te logeaste');
        })
            .catch(function (error) {
            console.log('encontramos error', error);
            _this.alert(error.message);
        });
    };
    //--deslogear desde fb twtter y google
    RegistrarsePage.prototype.logout = function () {
        this.fire.auth.signOut();
        this.provider.loggedin = false;
    };
    //-Primer login de fb sin firebase---------------
    //loginWithFB() {
    // this.facebook.login(['email', 'public_profile','user_friends']).then((Response: FacebookLoginResponse)=>	 {
    //  this.facebook.api('me?fields=id,name,email,first_name,picture.width(720).height(720).as(picture_large)',[]).then(profile =>{
    //  this.userData ={email: profile['email'], first_name: profile['first_name'],picture: profile['picture_large']['data']['url'], username:profile['name'] };
    //  }  )
    // } )
    //}
    /*
    loginWithFB() {
      
      this.facebook.login(['public_profile', 'user_friends', 'email'])
      .then((res: FacebookLoginResponse) => console.log('Logged into Facebook!', res))
      .catch(e => console.log('Error logging into Facebook', e));
    
    
    this.facebook.logEvent(this.facebook.EVENTS.EVENT_NAME_ADDED_TO_CART);
    
    }
    
    */
    RegistrarsePage.prototype.signup = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_4__homecable_homecable__["a" /* HomecablePage */]);
    };
    return RegistrarsePage;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* ViewChild */])('email'),
    __metadata("design:type", Object)
], RegistrarsePage.prototype, "usu", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* ViewChild */])('Contraseña'),
    __metadata("design:type", Object)
], RegistrarsePage.prototype, "passw", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* ViewChild */])('RepetirContraseña'),
    __metadata("design:type", Object)
], RegistrarsePage.prototype, "passw2", void 0);
RegistrarsePage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-registrarse',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\registrarse\registrarse.html"*/'<!--\n\n  Generated template for the RegistrarsePage page.\n\n\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n\n  Ionic pages and navigation.\n\n-->\n\n<ion-header>\n\n  \n\n    <ion-navbar color="primary">\n\n      <ion-title>Registrarse</ion-title>\n\n    </ion-navbar>\n\n  \n\n  </ion-header>\n\n  \n\n  \n\n  <ion-content padding>\n\n    <form [formGroup]="myForm" (ngSubmit)="saveData()"> \n\n      <ion-list >\n\n          <h4 style="color:#000000;font-weight:600;text-align:center;">Ingresa todos los datos: </h4>\n\n             \n\n   \n\n          <ion-item>\n\n              <ion-icon name="mail" item-start> </ion-icon>\n\n              <ion-label floating>Correo electronico</ion-label>\n\n              <ion-input formControlName="email" type="email" #email></ion-input>\n\n          </ion-item>\n\n          <ion-item *ngIf="myForm.get(\'email\').errors && myForm.get(\'email\').dirty">\n\n              <p color="danger" ion-text *ngIf="myForm.get(\'email\').hasError(\'required\')">Field is required</p>\n\n              <p color="danger" ion-text *ngIf="myForm.get(\'email\').hasError(\'email\')">It is not an email</p>\n\n          </ion-item>\n\n  \n\n          \n\n          <ion-item>\n\n            <ion-icon name="eye" item-start></ion-icon>\n\n            <ion-label floating>Contraseña</ion-label>\n\n            <ion-input formControlName="Contraseña" type="password" value="" #Contraseña></ion-input>\n\n          </ion-item>\n\n          <ion-item *ngIf="myForm.get(\'Contraseña\').errors && myForm.get(\'Contraseña\').dirty">\n\n            <p color="danger" ion-text *ngIf="myForm.get(\'Contraseña\').hasError(\'required\')">Field is required</p>\n\n            <p color="danger" ion-text *ngIf="myForm.get(\'Contraseña\').hasError(\'pattern\')">It is not a strong password</p>\n\n          </ion-item>\n\n          <ion-item>\n\n            <ion-icon name="eye" item-start></ion-icon>\n\n            <ion-label floating>Confirmar contraseña</ion-label>\n\n            <ion-input formControlName="RepetirContraseña" type="password" value="" #RepetirContraseña></ion-input>\n\n          </ion-item>\n\n          <ion-item *ngIf="myForm.get(\'RepetirContraseña\').errors && myForm.get(\'RepetirContraseña\').dirty">\n\n            <p color="danger" ion-text *ngIf="myForm.get(\'RepetirContraseña\').hasError(\'required\')">Field is required</p>\n\n            <p color="danger" ion-text *ngIf="myForm.get(\'RepetirContraseña\').hasError(\'pattern\')">It is not a strong password</p>\n\n          </ion-item>\n\n    \n\n          1\n\n      </ion-list>\n\n  \n\n          <div padding>\n\n              <button ion-button block type="submit" [disabled]="!myForm.valid" clear (click)="registerUser()">Continuar</button>\n\n          </div>\n\n          <h6 style="color:#000000;font-weight:600;text-align:center;">Tambien puedes ingresar a traves de : </h6>\n\n          \n\n        <div padding>\n\n                <!-- Float the icon left -->\n\n          <button ion-button block type="submit" clear (click)="loginWithGoogle()" *ngIf ="!provider.loggedin">\n\n            <ion-icon ios="logo-googleplus" md="logo-googleplus"></ion-icon>\n\n            Google+\n\n          </button>\n\n        </div>\n\n\n\n        <div padding>\n\n          <!-- Float the icon right -->\n\n          <button ion-button block type="submit" clear  (click)="loginWithTwitter()" *ngIf ="!provider.loggedin">\n\n            <ion-icon ios="logo-twitter" md="logo-twitter"></ion-icon>\n\n            TWITTER\n\n          </button>\n\n        </div>\n\n\n\n        <div padding>\n\n          <button ion-button block type="submit" clear  (click)="loginWithFacebook()" *ngIf ="!provider.loggedin">\n\n            <ion-icon ios="logo-facebook" md="logo-facebook"></ion-icon>\n\n             Facebook\n\n          </button>\n\n        </div>\n\n\n\n    <ion-card  *ngIf ="provider.loggedin">   \n\n        <img src="{{ provider.profilePicture }}"/>\n\n        <ion-card-content>\n\n          <ion-card-title>\n\n           {{ provider.name }}\n\n            </ion-card-title>\n\n          <p style="text-align: center">\n\n       {{provider.email }}\n\n          </p>\n\n        </ion-card-content>\n\n      </ion-card>\n\n\n\n    <button ion-button inline (click)="logout()" *ngIf ="provider.loggedin"><ion-icon ios="logo-facebook" md="logo-facebook"></ion-icon> salir </button>\n\n    \n\n  </form>\n\n  \n\n</ion-content>\n\n    \n\n    \n\n    \n\n    <!--\n\n  <ion-card *ngIf="userData" >\n\n    <ion-card-header>{{ userData.username }}</ion-card-header>\n\n    <img [src]="userData.picture">\n\n    <ion-card-content>\n\n      <p> Email: {{ userData.email }} </p>\n\n      <p> First Name: {{ userData.first_name }} </p>\n\n    </ion-card-content>\n\n  </ion-card> -->\n\n\n\n\n\n  <!-- Only icon (no text) -->\n\n  <!--<button ion-button icon-left   inline (click)="loginwithFB()" >\n\n    <ion-icon ios="logo-facebook" md="logo-facebook"></ion-icon>\n\n    Facebook\n\n  </button>\n\n  <ion-card *ngIf="userData" >\n\n      <ion-card-header>{{userData.username }}</ion-card-header>\n\n//\n\n  </ion-card>-->'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\registrarse\registrarse.html"*/,
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3_angularfire2_auth__["a" /* AngularFireAuth */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3_angularfire2_auth__["a" /* AngularFireAuth */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavParams */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormBuilder */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormBuilder */]) === "function" && _e || Object])
], RegistrarsePage);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=registrarse.js.map

/***/ }),

/***/ 244:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OlvidarContraseñaPageModule", function() { return OlvidarContraseñaPageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__olvidar_contrase_a__ = __webpack_require__(208);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var OlvidarContraseñaPageModule = (function () {
    function OlvidarContraseñaPageModule() {
    }
    return OlvidarContraseñaPageModule;
}());
OlvidarContraseñaPageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__olvidar_contrase_a__["a" /* OlvidarContraseñaPage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__olvidar_contrase_a__["a" /* OlvidarContraseñaPage */]),
        ],
    })
], OlvidarContraseñaPageModule);

//# sourceMappingURL=olvidar-contraseña.module.js.map

/***/ }),

/***/ 245:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RegistrarsePageModule", function() { return RegistrarsePageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__registrarse__ = __webpack_require__(209);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var RegistrarsePageModule = (function () {
    function RegistrarsePageModule() {
    }
    return RegistrarsePageModule;
}());
RegistrarsePageModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__registrarse__["a" /* RegistrarsePage */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__registrarse__["a" /* RegistrarsePage */]),
        ],
    })
], RegistrarsePageModule);

//# sourceMappingURL=registrarse.module.js.map

/***/ }),

/***/ 288:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(289);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(306);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 306:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(43);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(285);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__ = __webpack_require__(287);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__(452);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__pages_M01_Login_home_home__ = __webpack_require__(453);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_M01_Login_login_login_module__ = __webpack_require__(207);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__pages_M01_Login_olvidar_contrase_a_olvidar_contrase_a_module__ = __webpack_require__(244);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__pages_M01_Login_registrarse_registrarse_module__ = __webpack_require__(245);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__pages_M01_Login_invitacion_twitter_invitacion_twitter_module__ = __webpack_require__(205);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__pages_M01_Login_homecable_homecable_module__ = __webpack_require__(196);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_angularfire2__ = __webpack_require__(110);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__ionic_native_facebook__ = __webpack_require__(454);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_angularfire2_auth__ = __webpack_require__(45);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var firebaseAuth = {
    apiKey: "AIzaSyD5QOpTS7_8zgRSu3dBaG-V6B9QmQpD_Uc",
    authDomain: "test-project-9ca72.firebaseapp.com",
    databaseURL: "https://test-project-9ca72.firebaseio.com",
    projectId: "test-project-9ca72",
    storageBucket: "test-project-9ca72.appspot.com",
    messagingSenderId: "438129532489"
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
            __WEBPACK_IMPORTED_MODULE_6__pages_M01_Login_home_home__["a" /* HomePage */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_7__pages_M01_Login_login_login_module__["LoginPageModule"],
            __WEBPACK_IMPORTED_MODULE_8__pages_M01_Login_olvidar_contrase_a_olvidar_contrase_a_module__["OlvidarContraseñaPageModule"],
            __WEBPACK_IMPORTED_MODULE_9__pages_M01_Login_registrarse_registrarse_module__["RegistrarsePageModule"],
            __WEBPACK_IMPORTED_MODULE_10__pages_M01_Login_invitacion_twitter_invitacion_twitter_module__["InvitacionTwitterPageModule"],
            __WEBPACK_IMPORTED_MODULE_11__pages_M01_Login_homecable_homecable_module__["HomecablePageModule"],
            __WEBPACK_IMPORTED_MODULE_12_angularfire2__["a" /* AngularFireModule */].initializeApp(firebaseAuth),
            __WEBPACK_IMPORTED_MODULE_14_angularfire2_auth__["b" /* AngularFireAuthModule */],
            __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["e" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */], {}, {
                links: [
                    { loadChildren: '../pages/M01-Login/categoria/categoria.module#CategoriaPageModule', name: 'CategoriaPage', segment: 'categoria', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/homecable/homecable.module#HomecablePageModule', name: 'HomecablePage', segment: 'homecable', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/invitacion-twitter/invitacion-twitter.module#InvitacionTwitterPageModule', name: 'InvitacionTwitterPage', segment: 'invitacion-twitter', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/invitacion-google/invitacion-google.module#InvitacionGooglePageModule', name: 'InvitacionGooglePage', segment: 'invitacion-google', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/login/login.module#LoginPageModule', name: 'LoginPage', segment: 'login', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/olvidar-contraseña/olvidar-contraseña.module#OlvidarContraseñaPageModule', name: 'OlvidarContraseñaPage', segment: 'olvidar-contraseña', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/registrarse/registrarse.module#RegistrarsePageModule', name: 'RegistrarsePage', segment: 'registrarse', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/signup/signup.module#SignupPageModule', name: 'SignupPage', segment: 'signup', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/M01-Login/sugerencia/sugerencia.module#SugerenciaPageModule', name: 'SugerenciaPage', segment: 'sugerencia', priority: 'low', defaultHistory: [] }
                ]
            })
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicApp */]],
        entryComponents: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_6__pages_M01_Login_home_home__["a" /* HomePage */]
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__["a" /* StatusBar */],
            __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */],
            __WEBPACK_IMPORTED_MODULE_14_angularfire2_auth__["a" /* AngularFireAuth */],
            { provide: __WEBPACK_IMPORTED_MODULE_1__angular_core__["v" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["d" /* IonicErrorHandler */] },
            __WEBPACK_IMPORTED_MODULE_13__ionic_native_facebook__["a" /* Facebook */]
        ]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 452:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(287);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(285);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pages_M01_Login_home_home__ = __webpack_require__(453);
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
        this.rootPage = __WEBPACK_IMPORTED_MODULE_4__pages_M01_Login_home_home__["a" /* HomePage */];
        platform.ready().then(function () {
            // Okay, so the platform is ready and our plugins are available.
            // Here you can do any higher level native things you might need.
            statusBar.styleDefault();
            splashScreen.hide();
        });
    }
    return MyApp;
}());
MyApp = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\app\app.html"*/'<ion-nav [root]="rootPage"></ion-nav>\n\n'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\app\app.html"*/
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* Platform */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* Platform */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */]) === "function" && _c || Object])
], MyApp);

var _a, _b, _c;
//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ 453:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(13);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__login_login__ = __webpack_require__(111);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__invitacion_twitter_invitacion_twitter__ = __webpack_require__(206);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var HomePage = (function () {
    function HomePage(navCtrl) {
        this.navCtrl = navCtrl;
    }
    HomePage.prototype.goPaginaLogin = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__login_login__["a" /* LoginPage */]);
    };
    HomePage.prototype.goPaginaPrueba = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_3__invitacion_twitter_invitacion_twitter__["a" /* InvitacionTwitterPage */]);
    };
    return HomePage;
}());
HomePage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-home',template:/*ion-inline-start:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\home\home.html"*/'<ion-header>\n\n  <ion-navbar>\n\n    <ion-title>\n\n      Bienvenidos\n\n    </ion-title>\n\n  </ion-navbar>\n\n</ion-header>\n\n\n\n<ion-content padding>\n\n  <button ion-buttom (click)=\'goPaginaLogin()\'> ir a login</button>\n\n  <button ion-buttom (click)=\'goPaginaPrueba()\'> pRUEBAn</button>\n\n  \n\n\n\n\n\n</ion-content>\n\n'/*ion-inline-end:"C:\Users\Familia\Desktop\Luis\Proyecto\ViUCAB\Prueba\src\pages\M01-Login\home\home.html"*/
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavController */]])
], HomePage);

//# sourceMappingURL=home.js.map

/***/ })

},[288]);
//# sourceMappingURL=main.js.map