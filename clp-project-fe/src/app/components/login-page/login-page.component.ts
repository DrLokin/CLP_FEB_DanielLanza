import { Component,OnInit } from '@angular/core';
import { FormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { Subscription } from 'rxjs';

import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {

  loginFail = false;

  loginForm = new UntypedFormGroup({
    email: new UntypedFormControl('', [Validators.required, Validators.email]),
    password: new UntypedFormControl('', Validators.required)
  })

  featuredProducts:Product[] = [];

  loggedInSubscription!:Subscription
 

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    this.loggedInSubscription = this.authService.isLoggedIn().subscribe(isLoggedIn => {
      console.log(`Logged in is ${isLoggedIn}`);
      if (isLoggedIn){
        this.router.navigate(['home']);
      } 
    });
    console.log(this.loggedInSubscription);
    console.log("******************");

  }


  onSubmit():void {
    this.authService.login(this.loginForm.get('email')?.value, this.loginForm.get('password')?.value).subscribe(
      (currUser) => {
        console.log(currUser)
        // hide user's password
        // currUser.password = ''
        this.authService.setUser(currUser)
        this.authService.loggedIn=true;
      },
      (err) => {
        console.log(err);
      },
      () => {
        setTimeout(() => {
          console.log("Successful login");
          this.router.navigate(['home']);
        },1000)
        
        
      }
    );
  }

  


}
