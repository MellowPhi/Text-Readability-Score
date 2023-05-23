package readability;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author Om Thapa
 */
public class Main {
    private static String readFileAsString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes);
    }

    public static void main(String[] args) {
        // Uncomment if you are running from command line
        if (args.length < 1) {
            System.out.println("No argument provided.");
            System.exit(0);
        }
        System.out.println("Argument provided: " + args[0]);

        // Simply change the filePath for testing
        String filePath = args[0];

        try {
            TextDocument doc = new TextDocument(readFileAsString(filePath));
            System.out.println("The text is: ");
            System.out.println(doc.getText());
            System.out.print("\n");
            doc.readabilityLevel();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }
}

