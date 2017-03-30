package com.mtsmda.reflection.model;

import java.time.LocalDate;

/**
 * Created by dminzat on 2/2/2017.
 */
public class Person {

    private Integer idPerson;
    private String firstname;
    private String lastname;
    private String middlename;
    private LocalDate dateOfBirth;
    private Character gender;
    private Car car;
    private String phoneNumber;

    public Person() {

    }

    public Person(Integer idPerson, String firstname, String lastname, String middlename, LocalDate dateOfBirth, Character gender, Car car, String phoneNumber) {
        this.idPerson = idPerson;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.car = car;
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}