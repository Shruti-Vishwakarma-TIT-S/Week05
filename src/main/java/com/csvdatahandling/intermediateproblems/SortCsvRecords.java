package com.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class SortCsvRecords {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\Employee.csv";

        // Call the method to sort and print the top 5 highest-paid employees
        sortAndPrintTopEmployees(filepath);
    }

    public static void sortAndPrintTopEmployees(String filepath) {
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {

            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Remove the header row and store it separately
            String[] header = records.remove(0);

            // Sort the records by salary in descending order
            records.sort((r1, r2) -> Integer.parseInt(r2[3].trim()) - Integer.parseInt(r1[3].trim()));

            // Print the header row
            System.out.println(String.join(", ", header));

            // Print the top 5 highest-paid employees
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(", ", records.get(i)));
            }
        }
        catch (IOException | CsvException e) {
            // Print stack trace in case of an IOException or CsvException
            e.printStackTrace();
        }
    }
}
