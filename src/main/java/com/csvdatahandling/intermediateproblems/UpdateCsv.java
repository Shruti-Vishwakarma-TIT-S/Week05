package com.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class UpdateCsv {
    public static void main(String[] args) {
        // Define the file path of the input CSV file and the output CSV file
        String inputFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\Employee.csv";
        String outputFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\Output.csv";

        // Call the method to update the CSV file
        updateEmployeeSalaries(inputFilePath, outputFilePath);
    }

    public static void updateEmployeeSalaries(String inputFilePath, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Write the header row to the output file
            String[] header = records.get(0);
            writer.writeNext(header);

            // Iterate through the records and update the salary of employees in the "IT" department
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                if (row[2].equalsIgnoreCase("IT")) {
                    // Increase the salary by 10%
                    double salary = Double.parseDouble(row[3].trim());
                    salary *= 1.1;
                    row[3] = String.valueOf((int) salary);
                }
                // Write the updated record to the output file
                writer.writeNext(row);
            }

            System.out.println("CSV File Updated Successfully");
        }
        catch (IOException | CsvException e) {
            // Print stack trace in case of an IOException or CsvException
            e.printStackTrace();
        }
    }
}
