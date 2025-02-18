package com.csvdatahandling.basicproblems;

import java.io.*;

public class CsvFileWrite {
    public static void main(String[] args) {
        // Define the file path of the CSV file to be written
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\basicproblems\\WriteCsv.csv";

        // Call the method to write the CSV content to the file
        writeCSV(filepath);
    }

    public static void writeCSV(String filepath){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            // Write the header row to the CSV file
            bw.write("ID, Name, Dept, Salary\n");

            // Write data rows to the CSV file
            bw.write("101, Shruti, CSE, 4596352\n");
            bw.write("102, Monu, IT, 2352\n");
            bw.write("103, Seema, EC, 6352\n");

            // Print a success message to the console
            System.out.println("CSV File Written Successfully");
        } catch (IOException e) {
            // Print stack trace in case of an IOException
            e.printStackTrace();
        }
    }
}
