package com.json.practiceproblem;

public class Car {
    // Defining the fields for the Car class
    private String brand;
    private int yearOfManufacture;
    private double price;

    public Car(){

    }
    // Constructor to initialize the Car object
    public Car(String brand, int yearOfManufacture, double price) {
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
    }

    // Getters for each field
    public String getBrand() {
        return brand;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }
}
