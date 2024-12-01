import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from "../../common/product";
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  standalone:true,
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products: Product[] = [];
  currentCategoryId: number = 1;

  constructor(private productService: ProductService, private route: ActivatedRoute){

  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(() =>{
      this.listProducts();
    })
  } 

  listProducts(){

  const hasCategpryId: boolean =  this.route.snapshot.paramMap.has('id');

  if (hasCategpryId) {
    this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
  }else{
    this.currentCategoryId = 1;
  }

    this.productService.getProductList(this.currentCategoryId).subscribe(
      data =>{
        this.products = data;
      }
    )
  }
}
