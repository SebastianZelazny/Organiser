import { Component, OnInit } from '@angular/core';
import { NavbarToolbarService } from 'src/app/services/navbar_toolbar/navbar-toolbar.service';


@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css'],
})
export class ToolbarComponent implements OnInit {

  isExpanded:boolean;

  constructor(public service : NavbarToolbarService) { 

  }

  ngOnInit(): void {
    this.service.isExpandedValueChanged.subscribe((value) => {
      this.isExpanded = value
  });
  }

  toggleNavbar() {
    console.log("btn clicked");
    this.service.showHide(!this.isExpanded);
  }

}
