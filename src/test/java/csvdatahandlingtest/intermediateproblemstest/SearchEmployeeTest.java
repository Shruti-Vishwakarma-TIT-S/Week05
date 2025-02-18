package csvdatahandlingtest.intermediateproblemstest;

import com.csvdatahandling.intermediateproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class SearchEmployeeTest {

    @Test
    void testSearchEmployeeByName() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\EmployeeTest.csv";
        String employeeName = "Julius Ceaser";
        String expectedOutput = "Name: " + employeeName + ", Department: Finance, Salary: 56532\n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        SearchEmployee.searchEmployeeByName(filepath, employeeName);
        String actualOutput = outContent.toString();

        System.out.println("Actual Output:\n" + actualOutput);

        assertEquals(expectedOutput, actualOutput);
    }
}
