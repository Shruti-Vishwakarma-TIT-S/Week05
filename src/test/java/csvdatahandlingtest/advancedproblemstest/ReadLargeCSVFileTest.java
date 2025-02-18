package csvdatahandlingtest.advancedproblemstest;

import com.csvdatahandling.advancedproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class ReadLargeCSVFileTest {

    @Test
    void testReadCSVInChunks() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\advancedproblemstest\\contactsTest.csv";
        int chunkSize = 10;

        StringBuilder inputCSVContent = new StringBuilder("ID,Name,Email,Phone Number\n");
        for (int i = 1; i <= 10; i++) {
            inputCSVContent.append(i).append(",Name").append(i).append(",name").append(i).append("@example.com,1234567890\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(inputCSVContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ReadLargeCSVFile.readCSVInChunks(filepath, chunkSize);
        String actualOutput = outContent.toString();

        System.out.println("Actual Output:\n" + actualOutput);

        String expectedOutput = "Processing chunk of size: 100\n" +
                "Processed records: 100\n" +
                "Processing chunk of size: 100\n" +
                "Processed records: 200\n" +
                "Processing chunk of size: 100\n" +
                "Processed records: 300\n" +
                "Total records processed: 300\n";


        assertTrue(actualOutput.contains(expectedOutput));
    }

}
