package com.elecsoft.www;

import java.util.Date;

public class Account {
    String firstName;
    String lastName;
    String email;
    String password;
    String month;
    String date;
    String year;
    int gender;

    public Account(String firstName, String lastName, String email, String password, String month, String date, String year, int gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.month = month;
        this.date = date;
        this.year = year;
        this.gender = gender;
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public String getYear() {
        return year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", month='" + month + '\'' +
                ", date='" + date + '\'' +
                ", year='" + year + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getGender() {
        return gender;
    }

}
