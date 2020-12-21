import { Component, OnInit } from '@angular/core';
import { NavbarToolbarService } from 'src/app/services/navbar_toolbar/navbar-toolbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  
  active = false;
  element: HTMLElement;
  isExpanded = false;

  constructor(public service: NavbarToolbarService) { 
  }

  ngOnInit(): void {
    this.service.isExpandedValueChanged.subscribe((value) => {
      this.isExpanded = value
  });
  }
  
  toggleActive(event:any){

    event.preventDefault();
    if(this.element !== undefined){
      this.element.style.backgroundColor = "white";
    } 
    var target = event.currentTarget;
    target.style.backgroundColor = "#e51282";
    this.element = target;
  }

  show(){
    //if(this.service.isExpanded != true){
    //  this.service.isExpanded = true;
    this.service.Show();
    }


  hide(){
   // this.service.isExpanded = false;
   // console.log(this.service.isExpanded);
   this.service.Hide();
  }

  /*showHide(){
    this.service.showHide();
  }*/

}
