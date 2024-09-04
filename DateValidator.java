import java.util.Scanner;

public class DateValidator {

    // Method to check if a date is valid
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        // Days in each month
        int[] daysInMonth = {31, 28 + (isLeapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return day <= daysInMonth[month - 1];
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to compute the day number of the year
    public static int getDayNumberOfYear(int day, int month, int year) {
        int[] daysInMonth = {31, 28 + (isLeapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayNumber = 0;

        for (int i = 0; i < month - 1; i++) {
            dayNumber += daysInMonth[i];
        }
        dayNumber += day;

        return dayNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input date of birth
        System.out.println("Enter your date of birth in dd mm yyyy format:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        // Validate date
        if (isValidDate(day, month, year)) {
            System.out.println("VALID DATE");

            // Compute and display the day number of the year
            int dayNumber = getDayNumberOfYear(day, month, year);
            System.out.println("Day number of the year: " + dayNumber);
        } else {
            System.out.println("INVALID DATE");
        }

        scanner.close();
    }
}
