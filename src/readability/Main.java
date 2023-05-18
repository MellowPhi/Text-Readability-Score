package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Om Thapa
 */
public class Main {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
    public static void main(String[] args) {
        // Pass the command line argument to this variable
        // String pathToFile = args[0];
        String pathToFile = "/Users/omslaww/Readability Score (Java)/Readability Score (Java)/task/src/readability/in3.txt";
        // System.out.println(pathToFile);
//        String pathToFile = "142,262";
//        TextDocument doc = new TextDocument(pathToFile);
//        System.out.println(doc.getTokens("\\b\\d+,\\d+\\b|\\b\\w+\\b"));
//        System.out.println(doc.getNumSyllables());

        try {
            TextDocument doc = new TextDocument(readFileAsString(pathToFile));
            System.out.println("Generating the readability score for: ");
            System.out.println(doc.getText());
            System.out.print("\n");
            doc.readabilityLevel();
            // System.out.println(doc.getTokens("\\b\\w+\\b").size());
            // System.out.println(doc.getTokens("\\b\\d+,\\d+|\\b\\w+\\b").size());
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }

    }
}