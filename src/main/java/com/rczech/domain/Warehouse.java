package com.rczech.domain;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue

    private int id;

    @Column(name = "name")
    private String nameW;


    private String street;
    private String city;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(name = "building_number")
    private int buildingNumber;
    private String country;


//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "postalCode",
//                    column = @Column(name = "postal_code")
//            ),
//            @AttributeOverride(
//                    name = "buildingNumber",
//                    column = @Column(name = "building_number")
//            )
//    })

    //private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Warehouse(String nameW, String street, String city, int postalCode, int buildingNumber, String country, Owner owner) {

        this.nameW = nameW;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.buildingNumber = buildingNumber;
        this.country = country;
        this.owner = owner;
    }

    private Warehouse() {
    }


    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", nameW='" + nameW + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", buildingNumber=" + buildingNumber +
                ", country='" + country + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
