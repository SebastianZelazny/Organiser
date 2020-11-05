import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/services/menu/menu-service.service';

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.css']
})
export class SidebarMenuComponent implements OnInit {

  constructor(private menuService: MenuService) { }

  ngOnInit(): void {
  }

  closeNav(){
    this.menuService.closeNav();
  }
}
