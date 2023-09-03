package com.technology.registration.models;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private String district;
    //city town
    @Column(nullable = false)
    private String locality;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String premise;
    @Column(nullable = false)
    private String zipcode;

    @ManyToMany(mappedBy = "addresses")
    private Set<User> users;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
