package com.rczech.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue
    @Column(name = "product_id")

    private int id;
    private String name;                //delete final - they cannot be in Hibernate

    @Column(name = "catalog_number")
    private String catalogNumber;
    private String description;

    public Product(String name, String catalogNumber) {
        this.name = name;
        this.catalogNumber = catalogNumber;
    }

    private Product() {                 //need to create deafult constructor class 'Product' from calss
    }
}
