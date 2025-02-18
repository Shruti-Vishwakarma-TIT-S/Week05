package csvdatahandlingtest.advancedproblemstest;
import com.csvdatahandling.advancedproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

class GenerateCSVReportTest {

    @BeforeEach
    void setUpDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
             Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE employees (" +
                    "employee_id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "department VARCHAR(50), " +
                    "salary DOUBLE)";
            statement.execute(createTableSQL);

            String insertDataSQL = "INSERT INTO employees (employee_id, name, department, salary) VALUES " +
                    "(1, 'Rahul Sharma', 'HR', 50000), " +
                    "(2, 'Anjali Verma', 'Finance', 60000), " +
                    "(3, 'Vikram Singh', 'IT', 70000), " +
                    "(4, 'Priya Iyer', 'Marketing', 80000), " +
                    "(5, 'Arjun Mehta', 'Sales', 90000)";
            statement.execute(insertDataSQL);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchAndWriteToCSV() {

        String jdbcURL = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";
        String csvFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\employees_report_test.csv";

        GenerateCSVReport.fetchAndWriteToCSV(jdbcURL, username, password, csvFilePath);

        StringBuilder actualOutputCSVContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualOutputCSVContent.append(line).append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String expectedOutputCSVContent = "Employee ID,Name,Department,Salary\n" +
                "1,Rahul Sharma,HR,50000\n" +
                "2,Anjali Verma,Finance,60000\n" +
                "3,Vikram Singh,IT,70000\n" +
                "4,Priya Iyer,Marketing,80000\n" +
                "5,Arjun Mehta,Sales,90000\n";

        assertEquals(expectedOutputCSVContent.trim(), actualOutputCSVContent.toString().trim());
    }

    @AfterEach
    void cleanUp() {

        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\employees_report_test.csv"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
