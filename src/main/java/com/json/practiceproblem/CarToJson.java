package com.json.practiceproblem;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {

    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectmap = new ObjectMapper();

            // Creating a new Car object with sample data
            Car car = new Car("Maruti Suzuki", 1896, 963852.45);

            // Converting the Car object to a JSON string
            String jsonString = objectmap.writeValueAsString(car);

            // Printing the JSON string
            System.out.println("Java object to JSON:\n " + jsonString);
        } catch (Exception e) {
            // Handling any exceptions that occur during the process
            e.printStackTrace();
        }
    }
}
