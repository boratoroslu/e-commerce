package com.boratoroslu.e_ticaret.repository;

import com.boratoroslu.e_ticaret.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//crud işlemlerini gerçekleştiren restful web servislerini otomatik olarak bizim için oluşturacak
@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product-category")
@CrossOrigin("http://localhost:4200")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
