package ro.ddavid.springproject.exceptions.homework;

import java.util.Scanner;


/*
 * Calculator
 * Objective:
 * Create a simple calculator that handles exceptions for invalid input and arithmetic errors.
 *
 * Requirements:
 * Create a method called calculate that takes two double operands and a char operator as parameters.
 * This method should perform the specified operation and return the result.
 * Handle the following exceptions within the calculate method:
 * ArithmeticException for division by zero.
 * IllegalArgumentException for an invalid operator.
 * In the main method, prompt the user to enter two numbers and an operator.
 * Use a try-catch block to handle possible exceptions, such as NumberFormatException from invalid input,
 * and any exceptions thrown by the calculate method.
 * Display the result of the calculation or an appropriate error message based on the exception caught.
 * */
public class Calculator {

    public static double calculate(double operand1, double operand2, char operator) throws ArithmeticException, IllegalArgumentException {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator. Only +, -, *, and / are allowed.");
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            double operand1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second number: ");
            double operand2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.nextLine().charAt(0);

            double result = calculate(operand1, operand2, operator);
            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter valid numbers.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operator: " + e.getMessage());
        }
    }
}
