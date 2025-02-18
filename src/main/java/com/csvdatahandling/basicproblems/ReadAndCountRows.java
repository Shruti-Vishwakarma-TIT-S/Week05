package com.csvdatahandling.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\Student.csv";

        // Call the method to print the CSV content
        countCSVRows(filepath);
    }

    public static void countCSVRows(String filepath){
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Print the header row

            // Initialize count variable
            int count = -1;

            // Read each line of the CSV file
            String line;
            while ((line = br.readLine()) != null) {

                // Split the line into columns based on commas
                String[] columns = line.split(",");

                // Count increment
                count ++;
            }
            System.out.println("Total number of Rows are: "+ count);
        } catch (IOException e) {
            // Print stack trace in case of an IOException
            e.printStackTrace();
        }
    }
}
