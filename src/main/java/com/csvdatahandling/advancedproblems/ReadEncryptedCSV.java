package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVReader;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;

public class ReadEncryptedCSV {
    public static void main(String[] args) {
        // Define the file paths
        String csvFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\encryption\\employees_encrypted.csv";

        // Define the encryption key (use the same key used for encryption)
        String keyAsString = "your-encryption-key-here"; // Replace with the actual key

        // Call the method to read and decrypt data from CSV
        readEncryptedCSV(csvFilePath, keyAsString);
    }

    public static void readEncryptedCSV(String csvFilePath, String keyAsString) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            // Convert the key string back to SecretKey
            byte[] decodedKey = Base64.decodeBase64(keyAsString);
            SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            // Read CSV file
            List<String[]> records = reader.readAll();
            String[] header = records.get(0); // Read header row
            List<String[]> data = records.subList(1, records.size()); // Read data rows

            // Decrypt sensitive fields and print
            for (String[] record : data) {
                record[3] = AESUtil.decrypt(record[3], key); // Decrypt Salary
                record[4] = AESUtil.decrypt(record[4], key); // Decrypt Email
                System.out.println(Arrays.toString(record));
            }

            System.out.println("Decrypted CSV Read Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
