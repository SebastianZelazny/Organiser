import { Injectable } from '@angular/core';
import { Subject } from 'rxjs'; 

@Injectable({
  providedIn: 'root'
})
export class NavbarToolbarService {

  invokeEvent: Subject<any> = new Subject(); 

  callMethodOfSecondComponent() { 
    this.invokeEvent.next();   
  }
}
