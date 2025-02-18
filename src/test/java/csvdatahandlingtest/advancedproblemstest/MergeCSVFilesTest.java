package csvdatahandlingtest.advancedproblemstest;

import com.csvdatahandling.advancedproblems.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class MergeCSVFilesTest {

    @Test
    void testMergeCSVFiles() {

        String filePath1 = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\advancedproblemstest\\student1.csv";
        String filePath2 = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\advancedproblemstest\\student2.csv";
        String outputFilePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\advancedproblemstest\\merged.csv";

        String inputCSVContent1 = "ID,Name,Age\n" +
                "1,Rahul Sharma,20\n" +
                "2,Anjali Verma,22\n" +
                "3,Vikram Singh,21\n" +
                "4,Priya Iyer,23\n" +
                "5,Arjun Mehta,20\n";

        String inputCSVContent2 = "ID,Marks,Grade\n" +
                "1,85,A\n" +
                "2,90,A+\n" +
                "3,78,B+\n" +
                "4,88,A\n" +
                "5,92,A+\n";

        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(filePath1));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath2))) {
            writer1.write(inputCSVContent1);
            writer2.write(inputCSVContent2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expectedOutputCSVContent = "ID,Name,Age,Marks,Grade\n" +
                "1,Rahul Sharma,20,85,A\n" +
                "2,Anjali Verma,22,90,A+\n" +
                "3,Vikram Singh,21,78,B+\n" +
                "4,Priya Iyer,23,88,A\n" +
                "5,Arjun Mehta,20,92,A+\n";

        MergeCSVFiles.mergeCSVFiles(filePath1, filePath2, outputFilePath);

        StringBuilder actualOutputCSVContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualOutputCSVContent.append(line).append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedOutputCSVContent.trim(), actualOutputCSVContent.toString().trim());
    }

    @AfterEach
    void cleanUp() {

        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\students1Test.csv"));
            Files.deleteIfExists(Paths.get("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\students2Test.csv"));
            Files.deleteIfExists(Paths.get("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day01\\src\\test\\java\\csvdatahandlingtest\\intermediateproblemstest\\merged_studentsTest.csv"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
