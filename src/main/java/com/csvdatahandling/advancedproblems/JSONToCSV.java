package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JSONToCSV {
    public static void main(String[] args) {
        // Define the file paths
        String jsonFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\JSON.json";
        String csvFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\JSON.csv";

        // Convert JSON to CSV
        convertJSONToCSV(jsonFilePath, csvFilePath);
    }

    public static void convertJSONToCSV(String jsonFilePath, String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Read JSON file
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }

            // Parse JSON array
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Write CSV header
            String[] header = JSONObject.getNames(jsonArray.getJSONObject(0));
            writer.writeNext(header);

            // Write CSV records
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String[] record = new String[header.length];
                for (int j = 0; j < header.length; j++) {
                    record[j] = jsonObject.getString(header[j]);
                }
                writer.writeNext(record);
            }

            System.out.println("JSON to CSV Conversion Completed Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
