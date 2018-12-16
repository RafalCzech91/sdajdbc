package com.rczech.domain;

import javax.persistence.*;

@Entity
@Table
public class Owner {

    @Id
    @GeneratedValue
    @Column(name = "owner_id")
    private  int id;


    private String name;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public Owner(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    private Owner() {}
}