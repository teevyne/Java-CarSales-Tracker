package com.cardatabase.CarDatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    private String firstName;

    private String lastName;

    public Owner(){

    }

    public Owner(Long id, String givenName, String surname){
        ownerId = id;
        firstName = givenName;
        lastName = surname;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JsonIgnore
//    @JoinTable(name = "car_owner", joinColumns = { @JoinColumn(name = "ownerid") }, inverseJoinColumns = { @JoinColumn(name = "id") })
//    private Set<Car> cars = new HashSet<Car>(0);
//
//    public Set<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }


}
