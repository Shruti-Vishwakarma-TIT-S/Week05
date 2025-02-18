package csvdatahandlingtest.basicproblemstest;

import com.csvdatahandling.basicproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadAndCountRowsTest {

    @Test
    void testCountCSVRows() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\basicproblemstest\\WriteCsvTest.csv";
        int expectedRowCount = 3;

        int actualRowCount = countCSVRows(filepath);

        assertEquals(expectedRowCount, actualRowCount);
    }

    // Helper method to count rows in the CSV file
    private int countCSVRows(String filepath) {
        int rowCount = -1; // Initialize count variable
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = br.readLine()) != null) {
                rowCount++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
