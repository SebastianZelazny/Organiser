import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  imgUrl: string;
  imgName: string;
  backgroundStyle: string;
  contentBox: string;
  constructor() { }

  ngOnInit(): void {
    this.imgUrl="assets/images/main-page/";
    this.imgName="HomePage.png";
    this.backgroundStyle="100% 100%"
    this.contentBox="content-box";
  }
  getUrl(){
    return "url("+this.imgUrl+this.imgName+")";
  }

}
