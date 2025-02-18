package csvdatahandlingtest.advancedproblemstest;

import com.csvdatahandling.advancedproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.regex.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCSVTest {

    @Test
    void testValidateCSV() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\contactsTest.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        // Mock the input CSV content
        String inputCSVContent = "ID,Name,Email,Phone Number\n" +
                "1,Rahul Sharma,rahul.sharma@example.com,1234567890\n" +
                "2,Anjali Verma,anjali.verma@example,0987654321\n" +
                "3,Vikram Singh,vikram.singh@example.com,01234567890\n" +
                "4,Priya Iyer,priya.iyer@example.com,123456789\n" +
                "5,Arjun Mehta,arjun.mehta@example.com,1234567890\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(inputCSVContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ValidateCSV.validateCSV(filepath);
        String actualOutput = outContent.toString();

        System.out.println("Actual Output:\n" + actualOutput);

        String expectedOutput = "ID, Name, Email, Phone Number\n" +
                "1, Rahul Sharma, rahul.sharma@example.com, 1234567890\n" +
                "Invalid row: 2, Anjali Verma, anjali.verma@example, 0987654321\n" +
                "Error: Invalid email or phone number format.\n" +
                "Invalid row: 3, Vikram Singh, vikram.singh@example.com, 01234567890\n" +
                "Error: Invalid email or phone number format.\n" +
                "Invalid row: 4, Priya Iyer, priya.iyer@example.com, 123456789\n" +
                "Error: Invalid email or phone number format.\n" +
                "5, Arjun Mehta, arjun.mehta@example.com, 1234567890\n";

        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }
}
