package com.json.practiceproblem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


public class JsonValidationExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Define the JSON to be validated
        String json = "{\"brand\":\"Toyota\", \"yearOfManufacture\":2022, \"price\":25000.0}";

        try {
            // Validate JSON structure by deserializing it into Car object
            Car car = mapper.readValue(json, Car.class);
            System.out.println("Valid JSON structure!");
        }
        catch (JsonProcessingException e) {
            System.out.println("Invalid JSON structure!");
            System.out.println(e.getMessage());
        }
    }
}
