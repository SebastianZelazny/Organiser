import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavbarToolbarService {


  public isExpandedValueChanged: Subject<boolean> = new Subject<boolean>();

  constructor() {
  }

  showHide(option){
    this.isExpandedValueChanged.next(option);
  }

  Hide(){
    this.isExpandedValueChanged.next(false);
  }

  Show(){
      this.isExpandedValueChanged.next(true);
  }

}
