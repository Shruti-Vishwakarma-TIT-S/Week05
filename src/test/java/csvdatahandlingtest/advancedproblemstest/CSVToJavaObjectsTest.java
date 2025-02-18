package csvdatahandlingtest.advancedproblemstest;

import com.csvdatahandling.advancedproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CSVToJavaObjectsTest {

    @Test
    void testConvertCSVToContacts() {

        String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\advancedproblemstest\\contactsTest.csv";

        String inputCSVContent = "ID,Name,Email,Phone Number\n" +
                "1,Rahul Sharma,rahul.sharma@example.com,1234567890\n" +
                "2,Anjali Verma,anjali.verma@example,0987654321\n" +
                "3,Vikram Singh,vikram.singh@example.com,01234567890\n" +
                "4,Priya Iyer,priya.iyer@example.com,123456789\n" +
                "5,Arjun Mehta,arjun.mehta@example.com,1234567890\n";

        // Write the mock input CSV content to a temporary file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(inputCSVContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Define the expected list of contacts
        List<Contact> expectedContacts = Arrays.asList(
                new Contact("1", "Rahul Sharma", "rahul.sharma@example.com", "1234567890"),
                new Contact("2", "Anjali Verma", "anjali.verma@example", "0987654321"),  // Invalid email format
                new Contact("3", "Vikram Singh", "vikram.singh@example.com", "01234567890"),  // Invalid phone number (11 digits)
                new Contact("4", "Priya Iyer", "priya.iyer@example.com", "123456789"),  // Invalid phone number (9 digits)
                new Contact("5", "Arjun Mehta", "arjun.mehta@example.com", "1234567890")
        );

        List<Contact> actualContacts = CSVToJavaObjects.convertCSVToContacts(filepath);
        
        assertEquals(expectedContacts.size(), actualContacts.size());
        for (int i = 0; i < expectedContacts.size(); i++) {
            assertEquals(expectedContacts.get(i).toString(), actualContacts.get(i).toString());
        }
    }
}
