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

    public Warehouse(String nameW, String street, String city, int postalCode, int buildingNumber, String country) {

        this.nameW = nameW;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.buildingNumber = buildingNumber;
        this.country = country;
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
                '}';
    }
}
