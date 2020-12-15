import { Component, OnInit } from '@angular/core';
import { NavbarToolbarService } from 'src/app/services/navbar_toolbar/navbar-toolbar.service';


@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css'],
  providers: [NavbarToolbarService]
})
export class ToolbarComponent implements OnInit {



  constructor(private service : NavbarToolbarService) { 

  }

  ngOnInit(): void {
  }

  toggleNavbar() {
    console.log("btn clicked");
    this.service.callMethodOfSecondComponent();
  }

}
