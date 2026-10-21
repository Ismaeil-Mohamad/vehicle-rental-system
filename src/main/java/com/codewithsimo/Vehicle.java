package com.codewithsimo;

public abstract class Vehicle {
    private String model;
    private int year;
    private boolean isRented;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
        this.isRented = false;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
