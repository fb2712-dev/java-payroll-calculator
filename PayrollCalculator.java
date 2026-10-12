import java.util.Scanner;

// Author: Francesco Bortoluzzi
// Course: APANPS5175 Introduction to Programming using Java
public class PayrollCalculator {

    private static final double TAX_RATE = 0.20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;
        double hourlyWage;
        int hoursWorked;
        double grossSalary;
        double tax;
        double netSalary;

        name = readName(scanner);
        hourlyWage = readPositiveDouble(scanner, "Enter your hourly wage: $");
        hoursWorked = readNonNegativeInt(scanner, "Enter the number of hours worked: ");

        grossSalary = hourlyWage * hoursWorked;
        tax = grossSalary * TAX_RATE;
        netSalary = grossSalary - tax;

        System.out.println();
        System.out.println("Payroll Summary for " + name);
        System.out.println("-----------------------------------");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Hourly Wage: $%.2f%n", hourlyWage);
        System.out.printf("Gross Salary: $%.2f%n", grossSalary);
        System.out.printf("Taxes Deducted: $%.2f%n", tax);
        System.out.printf("Net Salary: $%.2f%n", netSalary);

        scanner.close();
    }

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
