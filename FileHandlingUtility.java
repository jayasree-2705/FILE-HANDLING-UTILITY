
import java.io.*;
import java.util.*;

public class FileHandlingUtility {

    // Method to write content to a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println(" The file is written successfully.");
        } catch (IOException e) {
            System.err.println(" Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println(" File content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.err.println(" Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content (e.g., replace a word)
    public static void modifyFile(String fileName, String target, String replacement) {
        try {
            // Read all lines into a list
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line.replace(target, replacement));
                }
            }

            // Write modified lines back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println(" The file is modified successfully.");
        } catch (IOException e) {
            System.err.println(" Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate file operations
    public static void main(String[] args) {
        String fileName = "example.txt";
        String content = "Hello, this is a sample text file used to demonstrate file operations.";

        // Write to file
        writeFile(fileName, content);

        // Read the file
        readFile(fileName);

        // Modify the file (replace "sample" with "demo")
        modifyFile(fileName, "sample", "demo");

        // Read again to see changes
        readFile(fileName);
    }
}
