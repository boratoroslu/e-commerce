package com.example.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "product_category")
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category") //mappedby bu ilişkiyi sahiplenen tarafı belirtmek için kullanıyoruz.
    private Set<Product> products; // mappedBy: product sınıfında bir category alanı vardır ve bu alan hangi kattegori nesnesine ait olduğunu belirtiyor

}
