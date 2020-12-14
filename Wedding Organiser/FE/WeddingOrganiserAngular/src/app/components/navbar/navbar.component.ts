import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  constructor() { }

  active = false;

  ngOnInit(): void {
   
  }
  
  isExpanded = false;

  element: HTMLElement;

  toggleActive(event:any){

    event.preventDefault();
    if(this.element !== undefined){
      this.element.style.backgroundColor = "white";
    } 
    var target = event.currentTarget;
    target.style.backgroundColor = "#e51282";
    this.element = target;
  }

  showHide(){
    this.isExpanded =! this.isExpanded
  }

  show(){
    if(this.isExpanded != true){
      this.isExpanded = true;
    }
  }

  hide(){
    this.isExpanded = false;
    console.log(this.isExpanded);
  }

}
