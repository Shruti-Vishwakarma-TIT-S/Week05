package com.csvdatahandling.basicproblems;

import java.io.*;

public class ReadCsv {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\Student.csv";

        // Call the method to print the CSV content
        printCSV(filepath);
    }

    public static void printCSV(String filepath){
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Print the header row
            System.out.println("\tID \tName \tDep \tSalary ");

            // Read each line of the CSV file
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into columns based on commas
                String[] columns = line.split(",");
                // Print the columns
                System.out.println("\t" + columns[0] + "\t " + columns[1] + "\t " + columns[2] + "\t " + columns[3]);
            }
        } catch (IOException e) {
            // Print stack trace in case of an IOException
            e.printStackTrace();
        }
    }
}
