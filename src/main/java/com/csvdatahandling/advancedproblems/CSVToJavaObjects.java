package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class CSVToJavaObjects {
    public static void main(String[] args) {
        // Define the file path of the CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\Contact.java";

        // Call the method to convert CSV data to Java objects
        List<Contact> contacts = convertCSVToContacts(filepath);

        // Print the contact objects
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static List<Contact> convertCSVToContacts(String filepath) {
        List<Contact> contacts = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            // Read all records from the CSV file
            List<String[]> records = reader.readAll();

            // Skip the header row and convert each record to a Contact object
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);

                // Check if the row has the correct number of columns
                if (row.length == 4) {
                    String id = row[0];
                    String name = row[1];
                    String email = row[2];
                    String phoneNumber = row[3];

                    Contact contact = new Contact(id, name, email, phoneNumber);
                    contacts.add(contact);
                }
                else {
                    System.out.println("Invalid row: " + Arrays.toString(row));
                }
            }
        }
        catch (IOException | CsvException e) {
            // Print stack trace in case of an IOException or CsvException
            e.printStackTrace();
        }

        return contacts;
    }
}
