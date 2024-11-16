package com.example.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne  //bir çok product nesnesi tek bir kategori id'sine ait olabilir.
    @JoinColumn(name = "category_id", nullable = false) // category_id stünun boş geçilemez olduğunu belirtiyoruz
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "unitPrice")
    private BigDecimal unitPrice;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "active")
    private boolean active;
    @Column(name = "UnitInStock")
    private int UnitInStock;
    @Column(name = "dateCreated")
    @CreationTimestamp//bir entitiy nesnesi ilk kez veri tabanına kayıt edildiğinde bu nesnenin oluşturulma zamanını belirlemek için
    private Date dateCreated;
    @Column(name = "castUpdated")
    @UpdateTimestamp// "" """ "" " """ her update edildiğinde güncelleme zamanını
    private Date castUpdated;

}
