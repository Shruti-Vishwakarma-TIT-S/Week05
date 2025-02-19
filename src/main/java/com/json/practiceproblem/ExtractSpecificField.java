package com.json.practiceproblem;

// Importing the Jackson ObjectMapper class for JSON deserialization
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractSpecificField {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance for reading JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading the JSON file and converting it to a Car object
            Car car = objectMapper.readValue(new File("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day02\\src\\main\\java\\com\\json\\practiceproblem\\CarRead.json"), Car.class);

            // Printing the car brand
            System.out.println("Car brand: " + car.getBrand());

            // Printing the car price
            System.out.println("Price of Car: " + car.getPrice());
        } catch (Exception e) {
            // Handling any exceptions that occur during the process
            e.printStackTrace();
        }
    }
}
