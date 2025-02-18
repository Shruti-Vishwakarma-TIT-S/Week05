package com.csvdatahandling.advancedproblems;

import com.opencsv.CSVWriter;
import java.io.*;
import java.sql.*;

public class GenerateCSVReport {
    public static void main(String[] args) {
        // Define database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/stu_info";
        String username = "shrutivish-123";
        String password = "18345693";

        // Define the file path of the output CSV file
        String csvFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\main\\java\\com\\csvdatahandling\\employees_report.csv";

        // Call the method to fetch records and write to CSV
        fetchAndWriteToCSV(jdbcURL, username, password, csvFilePath);
    }

    public static void fetchAndWriteToCSV(String jdbcURL, String username, String password, String csvFilePath) {
        String sql = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Write header row
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            // Fetch records from the result set and write to CSV file
            while (resultSet.next()) {
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String salary = resultSet.getString("salary");

                String[] record = {employeeId, name, department, salary};
                writer.writeNext(record);
            }

            System.out.println("CSV Report Generated Successfully");

        } catch (SQLException | IOException e) {
            // Print stack trace in case of an SQLException or IOException
            e.printStackTrace();
        }
    }
}
