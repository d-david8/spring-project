package ro.ddavid.springproject.exceptions.homework;

import java.util.Scanner;

/*
 * Age Validation
 * Objective:
 * Create a program to verify a person's age using exception handling.
 *
 * Requirements:
 * Create a custom checked exception called InvalidAgeException that extends Exception.
 * Create a method called validateAge that takes an integer age as a parameter and throws the InvalidAgeException
 * if the age is less than 0 or greater than 150.
 * In the main method, prompt the user to enter their age and read the input.
 * Use a try-catch block to handle the InvalidAgeException and display an appropriate error message if the exception occurs.
 * */
public class AgeValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your age: ");
        try {
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Age is valid.");
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age. Age must be between 0 and 150.");
        }
    }
}
