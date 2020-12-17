import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavbarToolbarService {

  public isExpanded = false;

  isExpandedValueChanged: Subject<boolean> = new Subject<boolean>();

  constructor() {
    this.isExpandedValueChanged.subscribe((value) => {
      this.isExpanded = value
  });
  }

  showHide(){
    this.isExpandedValueChanged.next(!this.isExpanded);
    console.log(this.isExpanded);
  }

  Hide(){
    this.isExpandedValueChanged.next(false);
    console.log(this.isExpanded);
  }

  Show(){
    if(this.isExpanded == false){
      this.isExpandedValueChanged.next(true);
    }
    console.log(this.isExpanded);
  }

}
