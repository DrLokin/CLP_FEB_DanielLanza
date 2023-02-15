import { Component,OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  currUser!:User;

  constructor(private auth:AuthService){}

  ngOnInit(){
    this.currUser = this.auth.fetchUser();
  }

}
