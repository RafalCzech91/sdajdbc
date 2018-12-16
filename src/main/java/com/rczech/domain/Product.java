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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "longDescription",
                    column = @Column(name = "long_description")
            )
    })
    private Description description;



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
                ", catalogNumber='" + catalogNumber + '\'' +
                ", description=" + description +
                ", price=" + price +
                '}';
    }

    public void changeDescription(String description) {
        this.description = new Description(
                description, description);
    }
}
