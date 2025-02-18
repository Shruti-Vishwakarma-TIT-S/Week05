package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVWriter;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.*;

public class WriteEncryptedCSV {
    public static void main(String[] args) {
        // Define the file paths
        String csvFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\encryption\\employees_encrypted.csv";

        // Call the method to write encrypted data to CSV
        writeEncryptedCSV(csvFilePath);
    }

    public static void writeEncryptedCSV(String csvFilePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Generate AES key
            SecretKey key = AESUtil.generateKey();
            String keyAsString = Base64.encodeBase64String(key.getEncoded());
            System.out.println("Encryption Key: " + keyAsString);

            // Write header row
            String[] header = {"Employee ID", "Name", "Department", "Salary", "Email"};
            writer.writeNext(header);

            // Define employee data
            List<String[]> employeeData = Arrays.asList(
                    new String[]{"1", "Rahul Sharma", "HR", "50000", "rahul.sharma@example.com"},
                    new String[]{"2", "Anjali Verma", "Finance", "60000", "anjali.verma@example.com"},
                    new String[]{"3", "Vikram Singh", "IT", "70000", "vikram.singh@example.com"}
            );

            // Encrypt sensitive fields and write to CSV file
            for (String[] employee : employeeData) {
                employee[3] = AESUtil.encrypt(employee[3], key); // Encrypt Salary
                employee[4] = AESUtil.encrypt(employee[4], key); // Encrypt Email
                writer.writeNext(employee);
            }

            System.out.println("Encrypted CSV Written Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
