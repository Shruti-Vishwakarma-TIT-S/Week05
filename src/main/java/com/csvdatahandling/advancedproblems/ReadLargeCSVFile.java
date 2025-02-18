package com.csvdatahandling.advancedproblems;

import java.io.*;
import java.util.*;

public class ReadLargeCSVFile {
    public static void main(String[] args) {
        // Define the file path of the large CSV file
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\student2.csv";

        // Call the method to read and process the CSV file in chunks
        readCSVInChunks(filepath, 100);
    }

    public static void readCSVInChunks(String filepath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int recordCount = 0;
            int totalProcessedRecords = 0;
            List<String> chunk = new ArrayList<>();

            // Skip the header row
            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                chunk.add(line);
                recordCount++;

                if (recordCount == chunkSize) {
                    // Process the current chunk
                    processChunk(chunk);
                    totalProcessedRecords += recordCount;
                    System.out.println("Processed records: " + totalProcessedRecords);

                    // Clear the chunk and reset the record count
                    chunk.clear();
                    recordCount = 0;
                }
            }

            // Process any remaining records in the last chunk
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalProcessedRecords += chunk.size();
                System.out.println("Processed records: " + totalProcessedRecords);
            }

            System.out.println("Total records processed: " + totalProcessedRecords);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processChunk(List<String> chunk) {
        // Implement your processing logic here
        System.out.println("Processing chunk of size: " + chunk.size());
    }
}
