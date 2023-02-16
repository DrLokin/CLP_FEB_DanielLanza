import { Component,Input,OnInit,Output} from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/product';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent{

  @Input() productInfo!: Product;
  // the quantity rendered
  quantity: number = 1
  // is the item in the user's cart?
  isInCart: boolean = false
  // if the item is in the user's cart: then this is the cart's ID

  // amount of items in the wish list
  wishListCount!: number;
  // the products in the wish list
  wishList?: Product[];


  cartItemId?: number
  cartCount!: number;
  products: {
    product: Product,
    quantity: number
  }[] = [];
  subscription!: Subscription;
  totalPrice: number = 0;
  featuredBanner = "../../assets/images/featured.png"

  isLoggedIn = this.authService.loggedIn;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {


    this.wishList = this.authService.getUser().wishList;

    if (this.wishList) {
      this.wishListCount = this.wishList?.length;
    } else {
      this.wishList = [];
      this.wishListCount = 0;
    }
  }


  updateQuantity(changeQuantityBy: number) {
    let newQuan = this.quantity + changeQuantityBy

    // quantity by default has to be 1
    if (newQuan < 1) this.quantity = 1
    else if (newQuan > this.productInfo.quantity) this.quantity = this.productInfo.quantity
    else this.quantity = newQuan
  }

  isInWishList(product: Product): boolean {

    if (this.wishList) {
      for (let wish of this.wishList) {
        if (wish.id === product.id) {
          return true;
        }
      }
    }

    return false;

  }

  addToWishList(product: Product): void {
    console.log("wishlist", this.wishList)
    if (this.wishList) {
      this.wishList.push(product);
      this.updateWishList(this.wishList);
    }
  }

  private updateWishList(wishList: Product[]): void {
    let user1: User = this.authService.getUser();
    user1.wishList = wishList;

    this.authService.updateUser(user1).subscribe((user) => user1 = user);
    this.authService.setUser(user1);
  }



  removeFromWishList(product: Product): void {
    console.log(product);
    if (this.wishList) {
      this.wishList = this.wishList.filter(item => item.id !== product.id)
      this.updateWishList(this.wishList);
      // for (let wish of this.wishList){

      // let index = this.wishList.findIndex(item => {
      //   return item.id === product.id
      // })

      // if (index)

      // if (wish.id === product.id){
      //   this.wishList = this.wishList.filter(w => w !== product);

      //   console.log(this.wishList);
      //   this.updateWishList(this.wishList);
      // }
      // }
    }
  }

  ngOnDestroy() {
  }

  toProduct(id: number, allowed: boolean) {
    if (allowed) {
      this.router.navigateByUrl("/products/" + id);
    }
  }

}
