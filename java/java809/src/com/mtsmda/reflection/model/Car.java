package com.mtsmda.reflection.model;

import java.time.LocalDate;

/**
 * Created by dminzat on 2/2/2017.
 */
public class Car {

    private Integer id;
    private String mark;
    private String model;
    private LocalDate yearOfIssue;

    public Car() {

    }

    public Car(Integer id, String mark, String model, LocalDate yearOfIssue) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(LocalDate yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }
}