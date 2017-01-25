package com.mtsmda.book.java8.other.clone_;

/**
 * Created by dminzat on 11/11/2016.
 */
public class Car implements Cloneable{

    private Integer carId;
    private String carName;
    private CarDetails carDetails;

    public Car() {

    }

    public Car(Integer carId, String carName, CarDetails carDetails) {
        this.carId = carId;
        this.carName = carName;
        this.carDetails = carDetails;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public CarDetails getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(CarDetails carDetails) {
        this.carDetails = carDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!carId.equals(car.carId)) return false;
        if (!carName.equals(car.carName)) return false;
        return carDetails != null ? carDetails.equals(car.carDetails) : car.carDetails == null;

    }

    @Override
    public int hashCode() {
        int result = carId.hashCode();
        result = 31 * result + carName.hashCode();
        result = 31 * result + (carDetails != null ? carDetails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", carDetails=" + carDetails +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}