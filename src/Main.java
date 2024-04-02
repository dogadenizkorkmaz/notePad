import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the last saved text from the file
        String lastSavedText = readLastSavedText();
        if (lastSavedText != null) {
            System.out.println("Last saved text: " + lastSavedText);
        } else {
            System.out.println("No text has been saved yet.");
        }

        // Get new text input from the user
        System.out.print("Enter new text: ");
        String newText = scanner.nextLine();

        // Save the text to the file
        writeToFile(newText);
    }

    // Method to write text to the file
    private static void writeToFile(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(text);
            System.out.println("Text successfully saved to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    // Method to read the last saved text from the file
    private static String readLastSavedText() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            return text.toString();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }
}
