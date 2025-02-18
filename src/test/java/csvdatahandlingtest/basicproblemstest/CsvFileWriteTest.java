package csvdatahandlingtest.basicproblemstest;

import com.csvdatahandling.basicproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class CsvFileWriteTest {

    @Test
    void testWriteCSV() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\basicproblemstest\\WriteCsvTest.csv";
        String expectedContent = "ID, Name, Dept, Salary\n" +
                "101, Shruti, CSE, 4596352\n" +
                "102, Monu, It, 2352\n" +
                "103, Seema, EC, 6352\n";

        CsvFileWrite.writeCSV(filepath);

        StringBuilder actualContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                actualContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedContent, actualContent.toString());
    }
}
