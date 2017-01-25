package com.mtsmda.book.java8.other.clone_;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 11/11/2016.
 */
public class User implements Cloneable{

    private Integer userId;
    private String userName;
    private LocalDate userDateOfBirth;

    public User() {

    }

    public User(Integer userId, String userName, LocalDate userDateOfBirth) {
        this.userId = userId;
        this.userName = userName;
        this.userDateOfBirth = userDateOfBirth;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(LocalDate userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!userName.equals(user.userName)) return false;
        return userDateOfBirth.equals(user.userDateOfBirth);

    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userDateOfBirth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userDateOfBirth=" + userDateOfBirth +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}