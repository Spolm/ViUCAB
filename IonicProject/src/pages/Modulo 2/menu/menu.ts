import { InicioPage } from './../inicio/inicio';
import {TendenciasPage } from './../tendencias/tendencias';
import {SuscripcionesPage} from './../suscripciones/suscripciones';
import {UsuarioPage} from './../usuario/usuario';
import {CanalPage} from './../canal/canal';
import {ListasPage} from './../listas/listas';
import {EstadisticaPage} from './../estadistica/estadistica';
import { TabsPage } from './../tabs/tabs';
import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, Nav } from 'ionic-angular';
 
export interface PageInterface {
  title: string;
  pageName: string;
  tabComponent?: any;
  index?: number;
  icon: string;
}
 
@IonicPage()
@Component({
  selector: 'page-menu',
  templateUrl: 'menu.html',
})
export class MenuPage {
  // Basic root for our content view
  rootPage = 'TabsPage';
 
  // Reference to the app's root nav
  @ViewChild(Nav) nav: Nav;
 
  pages: PageInterface[] = [
    { title: 'Inicio', pageName: 'TabsPage', tabComponent: 'InicioPage', index: 0, icon: 'home' },
    //Aqui van los links de las paginas principales de los demas grupos
    //{ title: 'Configuración de usuario', pageName: 'UsuarioPage', icon: 'contact' },
    //{ title: 'Mi canal', pageName: 'CanalPage', icon: 'play' },
    { title: 'Mis listas', pageName: 'ListasPage', icon: 'star-half' },
    { title: 'Estadísticas', pageName: 'EstadisticaPage', icon: 'stats' }
  ];
 
  constructor(public navCtrl: NavController) { }
 
  openPage(page: PageInterface) {
    let params = {};
 
    // The index is equal to the order of our tabs inside tabs.ts
    if (page.index) {
      params = { tabIndex: page.index };
    }
 
    // The active child nav is our Tabs Navigation
    if (this.nav.getActiveChildNav() && page.index != undefined) {
      this.nav.getActiveChildNav().select(page.index);
    } else {
      // Tabs are not active, so reset the root page 
      // In this case: moving to or from SpecialPage
      this.nav.setRoot(page.pageName, params);
    }
  }
 
  isActive(page: PageInterface) {
    // Again the Tabs Navigation
    let childNav = this.nav.getActiveChildNav();
 
    if (childNav) {
      if (childNav.getSelected() && childNav.getSelected().root === page.tabComponent) {
        return 'secondary';
      }
      return;
    }
 
    // Fallback needed when there is no active childnav (tabs not active)
    if (this.nav.getActive() && this.nav.getActive().name === page.pageName) {
      return 'secondary';
    }
    return;
  }

  MyChannelSubmenu: boolean = false;
  SettingsSubmenu: boolean = false;
  MyChannelItemHandler(): void {
    this.MyChannelSubmenu = !this.MyChannelSubmenu;
    this.SettingsSubmenu = false;
  }
  SettingsItemHandler(): void {
    this.SettingsSubmenu = !this.SettingsSubmenu;
    this.MyChannelSubmenu = false;
  }
 
}