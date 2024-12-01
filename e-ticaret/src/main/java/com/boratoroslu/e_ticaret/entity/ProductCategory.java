package com.boratoroslu.e_ticaret.entity;

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

    @Column(name = "category_name")
    private String categoryName;

    //bire çok ilişki, bir kategorinin bir çok ürünü olabilir.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category") //mappedBy ilişkinin sahiplik tarafını gösteriyor (category) sahip taraf.
    private Set<Product> products;
}
