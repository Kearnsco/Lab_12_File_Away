import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInspector {

    public static void main(String[] args) {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");

        // Show the dialog to choose a file
        int result = fileChooser.showOpenDialog(null);

        // If user selects a file
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getName();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    charCount += line.length();

                    // Split the line by spaces to count words
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }

                // Close the reader
                reader.close();

                // Print summary report
                System.out.println("Summary Report:");
                System.out.println("File Name: " + fileName);
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}