package csvdatahandlingtest.advancedproblemstest;

import com.csvdatahandling.advancedproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class DetectDuplicatesCSVTest {

    @Test
    void testDetectDuplicates() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\studentsTest.csv";

        String inputCSVContent = "ID,Name,Email,Phone Number\n" +
                "1,Rahul Sharma,rahul.sharma@example.com,1234567890\n" +
                "2,Anjali Verma,anjali.verma@example.com,0987654321\n" +
                "3,Vikram Singh,vikram.singh@example.com,01234567890\n" +
                "4,Priya Iyer,priya.iyer@example.com,123456789\n" +
                "5,Arjun Mehta,arjun.mehta@example.com,1234567890\n" +
                "2,Anjali Verma,duplicate.anjali@example.com,1122334455\n" +
                "5,Arjun Mehta,duplicate.arjun@example.com,6677889900\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(inputCSVContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        DetectDuplicatesCSV.detectDuplicates(filepath);
        String actualOutput = outContent.toString();

        System.out.println("Actual Output:\n" + actualOutput);

        String expectedOutput = "Duplicate records found:\n" +
                "[2, Anjali Verma, anjali.verma@example.com, 0987654321]\n" +
                "[2, Anjali Verma, duplicate.anjali@example.com, 1122334455]\n" +
                "[5, Arjun Mehta, arjun.mehta@example.com, 1234567890]\n" +
                "[5, Arjun Mehta, duplicate.arjun@example.com, 6677889900]\n";

        assertTrue(actualOutput.contains(expectedOutput.trim()));
    }

    @AfterEach
    void cleanUp() {
        // Clean up temporary files after each test
        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\studentsTest.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
