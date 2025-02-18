package csvdatahandlingtest.basicproblemstest;

import com.csvdatahandling.basicproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ReadCsvTest {

    @Test
    void testPrintCSV() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\basicproblemstest\\StudentTest.csv";
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "\tID \tName \tDep \tSalary " + lineSeparator + "1\t John\t HR\t 50000" + lineSeparator + "2\t Jane\t IT\t 60000" + lineSeparator;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ReadCsv.printCSV(filepath);
        String actualOutput = outContent.toString();

        System.out.println("Actual Output:\n" + actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }
}
