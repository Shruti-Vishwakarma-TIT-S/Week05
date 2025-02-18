package com.csvdatahandling.intermediateproblems;

import java.io.*;

public class FilterRecords {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\Student.csv";

        // Call the method to filter and print qualifying records
        filterAndPrintRecords(filepath);
    }

    public static void filterAndPrintRecords(String filepath){
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Print the header row
            System.out.println("ID \tName \tMarks");

            // Read each line of the CSV file
            String line;
            while ((line = br.readLine()) != null) {

                // Split the line into columns based on commas
                String[] columns = line.split(",");

                // Parse the marks and filter students with marks greater than 80
                int marks = Integer.parseInt(columns[2]);

                if (marks > 80) {

                    // Print the qualifying records
                    System.out.println(columns[0] + "\t " + columns[1] + "\t " + columns[2]);
                }
            }
        }
        catch (IOException e) {
            // Print stack trace in case of an IOException
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            // Print stack trace in case of a NumberFormatException
            e.printStackTrace();
        }
    }
}
