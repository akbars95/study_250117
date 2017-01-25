package com.mtsmda.book.java8.other.clone_;

import java.time.Period;

/**
 * Created by dminzat on 11/14/2016.
 *
 * cloning constructor
 */
public class Person {

    private String firstname;
    private String lastname;
    private int age;

    public Person() {

    }

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Person(Person person){
        this(person.getFirstname(), person.getLastname(), person.getAge());
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}