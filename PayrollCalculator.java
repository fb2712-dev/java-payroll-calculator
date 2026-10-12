import java.util.Scanner;

/**
 * PayrollCalculator
 *
 * A simple payroll calculator that reads an employee's name, hourly wage
 * and hours worked, computes gross salary, a flat 20% tax and net salary,
 * and prints a formatted payroll summary.
 *
 * Author: Francesco Bortoluzzi
 * Course: APANPS5175 Introduction to Programming using Java
 */
public class PayrollCalculator {

    // Flat tax rate as a named constant, so the value is defined in one place
    private static final double TAX_RATE = 0.20;

    public static void main(String[] args) {
        // Scanner reads what the user types in the console
        Scanner scanner = new Scanner(System.in);

        // ---- 1. Variable declarations ----
        String name;
        double hourlyWage;
        int hoursWorked;
        double grossSalary;
        double tax;
        double netSalary;

        // ---- 2. User input (each value is validated) ----
        name = readName(scanner);
        hourlyWage = readPositiveDouble(scanner, "Enter your hourly wage: $");
        hoursWorked = readNonNegativeInt(scanner, "Enter the number of hours worked: ");

        // ---- 3. Calculations ----
        grossSalary = hourlyWage * hoursWorked;   // earnings before deductions
        tax = grossSalary * TAX_RATE;             // 20% flat tax
        netSalary = grossSalary - tax;            // earnings after tax

        // ---- 4. Output in the required format ----
        System.out.println();
        System.out.println("Payroll Summary for " + name);
        System.out.println("-----------------------------------");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Hourly Wage: $%.2f%n", hourlyWage);
        System.out.printf("Gross Salary: $%.2f%n", grossSalary);
        System.out.printf("Taxes Deducted: $%.2f%n", tax);
        System.out.printf("Net Salary: $%.2f%n", netSalary);

        // Release the Scanner resource
        scanner.close();
    }

    /**
     * Reads a non-empty name. Keeps asking until the user types something.
     */
    private static String readName(Scanner scanner) {
        while (true) {
            System.out.print("Enter your name: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: name cannot be empty. Please try again.");
        }
    }

    /**
     * Reads a decimal number greater than zero.
     * Rejects text (e.g. "abc") and zero or negative values.
     */
    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Error: the value must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a valid number (e.g. 25.50).");
            }
        }
    }

    /**
     * Reads a whole number that is zero or greater.
     * Rejects text, decimals (e.g. "40.5") and negative values.
     */
    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= 0) {
                    return value;
                }
                System.out.println("Error: hours worked cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a whole number (e.g. 40).");
            }
        }
    }
}
