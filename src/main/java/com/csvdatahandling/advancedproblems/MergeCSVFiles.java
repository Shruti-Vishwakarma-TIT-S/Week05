package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        // Define the file paths of the input CSV files and the output CSV file
        String filePath1 = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\student1.csv";
        String filePath2 = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\student2.csv";
        String outputFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\merged.csv";

        // Call the method to merge the CSV files
        mergeCSVFiles(filePath1, filePath2, outputFilePath);
    }

    public static void mergeCSVFiles(String filePath1, String filePath2, String outputFilePath) {
        try (CSVReader reader1 = new CSVReader(new FileReader(filePath1));
             CSVReader reader2 = new CSVReader(new FileReader(filePath2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            // Read all records from the first CSV file
            List<String[]> records1 = reader1.readAll();

            // Read all records from the second CSV file
            List<String[]> records2 = reader2.readAll();

            // Create a map to store the records from the second CSV file by ID
            Map<String, String[]> map = new HashMap<>();
            for (String[] record : records2) {
                map.put(record[0], record);
            }

            // Write the header row to the output file
            String[] header1 = records1.get(0);
            String[] header2 = records2.get(0);
            String[] mergedHeader = {header1[0], header1[1], header1[2], header2[1], header2[2]};
            writer.writeNext(mergedHeader);

            // Merge the records based on ID and write to the output file
            for (int i = 1; i < records1.size(); i++) {
                String[] record1 = records1.get(i);
                String[] record2 = map.get(record1[0]);
                if (record2 != null) {
                    String[] mergedRecord = {record1[0], record1[1], record1[2], record2[1], record2[2]};
                    writer.writeNext(mergedRecord);
                }
            }

            System.out.println("CSV Files Merged Successfully");
        }
        catch (IOException | CsvException e) {
            // Print stack trace in case of an IOException or CsvException
            e.printStackTrace();
        }
    }
}
