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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    public Product(String name, String catalogNumber, Price price) {
        this.name = name;
        this.catalogNumber = catalogNumber;
        this.price = price;
    }

    private Product() {                 //need to create deafult constructor class 'Product' from calss
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void changeDescription(String description) {

        this.description = description;
    }
}
