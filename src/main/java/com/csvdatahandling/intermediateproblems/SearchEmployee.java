package com.csvdatahandling.intermediateproblems;

import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\Employee.csv";

        // Define the name of the employee to search
        String employeeName = "Mark Antony";

        // Call the method to search and print the employee details
        searchEmployeeByName(filepath, employeeName);
    }

    public static void searchEmployeeByName(String filepath, String employeeName) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Read each line of the CSV file
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into columns based on commas
                String[] columns = line.split(",");

                // Check if the name matches the employeeName
                if (columns[1].equalsIgnoreCase(employeeName)) {

                    // Print the employee's department and salary
                    System.out.println("Name: "+ employeeName + ", Department: " + columns[2] + ", Salary: " + columns[3]);
                    return;
                }
            }
            System.out.println("Employee not found: " + employeeName);
        } catch (IOException e) {
            // Print stack trace in case of an IOException
            e.printStackTrace();
        }
    }
}
