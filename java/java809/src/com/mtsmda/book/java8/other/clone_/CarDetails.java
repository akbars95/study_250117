package com.mtsmda.book.java8.other.clone_;

/**
 * Created by dminzat on 11/11/2016.
 */
public class CarDetails {

    private String carDescription;

    public CarDetails() {

    }

    public CarDetails(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDetails that = (CarDetails) o;

        return carDescription.equals(that.carDescription);

    }

    @Override
    public int hashCode() {
        return carDescription.hashCode();
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "carDescription='" + carDescription + '\'' +
                '}';
    }

}