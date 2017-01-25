package com.mtsmda.book.java8.other.clone_;

/**
 * Created by dminzat on 11/11/2016.
 */
public class ModelWithoutClone {

    private String name;

    public ModelWithoutClone() {

    }

    public ModelWithoutClone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelWithoutClone that = (ModelWithoutClone) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "ModelWithoutClone{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}