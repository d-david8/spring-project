package ro.ddavid.springproject.exceptions.homework;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * File Copy Utility
 * Objective:
 * Create a file copy utility that handles exceptions related to file I/O operations.
 *
 * Requirements:
 * Create a method called copyFile that takes two strings as parameters: sourcePath and destinationPath.
 * This method should copy the contents of the source file to the destination file.
 * Use try-with-resources to ensure that resources are closed properly.
 * Handle the following exceptions within the copyFile method:
 * FileNotFoundException if the source file does not exist.
 * IOException for any other I/O related errors.
 * In the main method, prompt the user to enter the source and destination file paths.
 * Call the copyFile method within a try-catch block to handle the possible exceptions and display appropriate error messages.
 *  */
public class FileCopyUtility {

    public static void copyFile(String sourcePath, String destinationPath) {
        try (InputStream in = new FileInputStream(sourcePath);
             OutputStream out = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter source file path: ");
            String sourcePath = scanner.nextLine();

            System.out.println("Enter destination file path: ");
            String destinationPath = scanner.nextLine();

            copyFile(sourcePath, destinationPath);
        } catch (InputMismatchException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}

