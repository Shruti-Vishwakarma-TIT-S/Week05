package csvdatahandlingtest.intermediateproblemstest;

import com.csvdatahandling.intermediateproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FilterRecordsTest {

    @Test
    void testFilterAndPrintRecords() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\StudentTest.csv";
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "ID \tName \tMarks" + lineSeparator +
                "101\t Mark Antony\t 96" + lineSeparator +
                "104\t Shelly Bell\t 92" + lineSeparator;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        FilterRecords.filterAndPrintRecords(filepath);
        String actualOutput = outContent.toString();

        System.out.println("Actual Output:\n" + actualOutput);

        assertEquals(expectedOutput, actualOutput);
    }
}
