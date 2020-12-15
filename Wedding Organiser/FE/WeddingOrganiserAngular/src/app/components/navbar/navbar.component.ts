import { Component, OnInit } from '@angular/core';
import { NavbarToolbarService } from 'src/app/services/navbar_toolbar/navbar-toolbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [NavbarToolbarService]
})
export class NavbarComponent implements OnInit {
  
  active = false;
  isExpanded = false;
  element: HTMLElement;

  constructor(private service: NavbarToolbarService) { 
    service.invokeEvent.subscribe(() => {
      this.showHide();
    })


  }

  ngOnInit(): void {
   
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

  showHide(){
    this.isExpanded =! this.isExpanded;
    console.log(this.isExpanded);
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
