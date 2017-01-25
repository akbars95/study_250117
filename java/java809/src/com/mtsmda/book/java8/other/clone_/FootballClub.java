package com.mtsmda.book.java8.other.clone_;

import java.io.Serializable;

/**
 * Created by dminzat on 11/14/2016.
 * clone impl via serialization
 */
public class FootballClub implements Serializable{

    private String footballClubName;
    private int age;

    public FootballClub() {

    }

    public FootballClub(String footballClubName, int age) {
        this.footballClubName = footballClubName;
        this.age = age;
    }

    public String getFootballClubName() {
        return footballClubName;
    }

    public void setFootballClubName(String footballClubName) {
        this.footballClubName = footballClubName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "footballClubName='" + footballClubName + '\'' +
                ", age=" + age +
                '}';
    }
}