import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MerriedInformationComponent } from './components/headers/merried-information/merried-information.component';
import { SidebarMenuComponent } from './components/sidebar/sidebar-menu/sidebar-menu.component';
import { HomePageComponent } from './components/main-container/home-page/home-page.component';
import { InformationComponent } from './components/main-container/information/information.component';

@NgModule({
  declarations: [
    AppComponent,
    MerriedInformationComponent,
    SidebarMenuComponent,
    HomePageComponent,
    InformationComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
