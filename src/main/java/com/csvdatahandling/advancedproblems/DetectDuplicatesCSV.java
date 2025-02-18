package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\advancedproblemstest\\students.csv";

        // Call the method to detect and print duplicate records
        detectDuplicates(filepath);
    }

    public static void detectDuplicates(String filepath) {
        Map<String, List<String[]>> recordMap = new HashMap<>();
        List<String[]> duplicates = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Iterate through the records and group them by ID
            for (String[] record : records) {
                String id = record[0];
                if (!recordMap.containsKey(id)) {
                    recordMap.put(id, new ArrayList<>());
                }
                recordMap.get(id).add(record);
            }

            // Detect duplicates and collect them
            for (Map.Entry<String, List<String[]>> entry : recordMap.entrySet()) {
                if (entry.getValue().size() > 1) {
                    duplicates.addAll(entry.getValue());
                }
            }

            // Print the duplicate records
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate records found:");
                for (String[] duplicate : duplicates) {
                    System.out.println(Arrays.toString(duplicate));
                }
            } else {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException | CsvException e) {
            // Print stack trace in case of an IOException or CsvException
            e.printStackTrace();
        }
    }
}
