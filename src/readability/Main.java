package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
    public static void main(String[] args) {
        // Pass the command line argument to this variable
        String pathToFile = args[0];
        System.out.println(pathToFile);

        try {
            TextDocument doc = new TextDocument(readFileAsString(pathToFile));
            doc.readabilityLevel();
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }

    }
}