package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\Validate.csv";

        // Call the method to validate the CSV file
        validateCSV(filepath);
    }

    public static void validateCSV(String filepath) {
        // Define the regex patterns for email and phone number validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Store the header row separately
            String[] header = records.get(0);
            System.out.println(String.join(", ", header));

            // Validate each record
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);

                // Assuming email is in the third column
                String email = row[2].trim();

                // Assuming phone number is in the fourth column
                String phone = row[3].trim();

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.println("Invalid row: " + String.join(", ", row));
                    System.out.println("Error: Invalid email or phone number format.");
                }
                else {
                    System.out.println(String.join(", ", row));
                }
            }
        }
        catch (IOException | CsvException e) {
            // Print stack trace in case of an IOException or CsvException
            e.printStackTrace();
        }
    }
}
