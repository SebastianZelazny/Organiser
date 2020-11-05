import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/services/menu/menu-service.service';

@Component({
  selector: 'app-merried-information',
  templateUrl: './merried-information.component.html',
  styleUrls: ['./merried-information.component.css']
})
export class MerriedInformationComponent implements OnInit {

  constructor(private menuService: MenuService) { }

  ngOnInit(): void {
  }
  openNav(){
    this.menuService.openNav();
  }
}
