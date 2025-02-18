package csvdatahandlingtest.intermediateproblemstest;

import org.junit.jupiter.api.*;
import java.io.*;
import com.csvdatahandling.intermediateproblems.SortCsvRecords;
import static org.junit.jupiter.api.Assertions.*;

class SortCsvRecordsTest {

    @Test
    void testSortAndPrintTopEmployees() {
        // Arrange: Set up the file path and expected output
        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\SalaryTest.csv";
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "ID, Name, Dept, Salary" + lineSeparator +
                "105, Jacob Fins, Sales, 90000" + lineSeparator +
                "104, Shelly Bell, Marketing, 80000" + lineSeparator +
                "103, Jammie Robs, IT, 70000" + lineSeparator +
                "102, Julius Ceaser, Finance, 60000" + lineSeparator +
                "101, Mark Antony, HR, 50000" + lineSeparator;

        // Act: Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        SortCsvRecords.sortAndPrintTopEmployees(filepath);
        String actualOutput = outContent.toString();

        // Debug: Print actual output
        System.out.println("Actual Output:\n" + actualOutput);

        // Assert: Verify the output matches the expected output
        assertEquals(expectedOutput, actualOutput);
    }
}
