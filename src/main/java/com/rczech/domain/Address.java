//package com.rczech.domain;
//
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class Address {
//
//    private String street;
//    private String city;
//    //@Column(name = "postal_code")
//    private int postalCode;
//   // @Column(name = "building_number")
//    private int buildingNumber;
//    private String country;
//
//    public Address(String street, String city, int postalCode, int buildingNumber, String country) {
//        this.street = street;
//        this.city = city;
//        this.postalCode = postalCode;
//        this.buildingNumber = buildingNumber;
//        this.country = country;
//    }
//    private Address() {}
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "street='" + street + '\'' +
//                ", city='" + city + '\'' +
//                ", postalCode=" + postalCode +
//                ", buildingNumber=" + buildingNumber +
//                ", country='" + country + '\'' +
//                '}';
//    }
//}
