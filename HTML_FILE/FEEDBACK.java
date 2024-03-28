import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FEEDBACK {

    public static void main(String[] args) {
        // Read CSV file and store data in a list
        List<String[]> csvData = readCSV("FEEDBACK_QUESTIONS.csv");

        // Generate HTML content for paragraphs
        String paragraphContent = generateParagraphHTML(csvData);

        // Write paragraph content to file
        writeToFile(paragraphContent, "FEEDBACK.html");
    }

    private static List<String[]> readCSV(String csvFilePath) {
        List<String[]> csvData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                csvData.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvData;
    }

    private static String generateParagraphHTML(List<String[]> csvData) {
        StringBuilder paragraphContent = new StringBuilder();
        for (String[] row : csvData) {
            StringBuilder sentence = new StringBuilder();
            for (String cell : row) {
                sentence.append(cell).append(" ");
            }
            paragraphContent.append("<p>").append(sentence.toString().trim()).append("</p>\n");
        }
        return paragraphContent.toString();
    }

    private static void writeToFile(String content, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}