package csvdatahandlingtest.intermediateproblemstest;
import com.csvdatahandling.intermediateproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UpdateCsvTest {

    @Test
    void testUpdateEmployeeSalaries() {

        String inputFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\EmployeeTest.csv";
        String outputFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\OutputTest.csv";
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "ID, Name, Dept, Salary" + lineSeparator +
                "101, Mark Antony, HR, 50000" + lineSeparator +
                "102, Julius Ceaser, Finance, 60000" + lineSeparator +
                "103, Jammie Robs, IT, 77000" + lineSeparator +
                "104, Shelly Bell, Marketing, 80000" + lineSeparator +
                "105, Jacob Fins, Sales, 90000" + lineSeparator;

        UpdateCsv.updateEmployeeSalaries(inputFilePath, outputFilePath);

        StringBuilder actualOutput = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(outputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                actualOutput.append(line).append(lineSeparator);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedOutput, actualOutput.toString());
    }
}
