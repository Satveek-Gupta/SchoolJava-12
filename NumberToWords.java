import java.util.Scanner;

public class NumberToWords {

    // Arrays for number words
    private static final String[] units = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] teens = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    // Method to convert a number to words
    public static String convertToWords(int number) {
        if (number == 0) {
            return "Zero";
        }

        String words = "";

        // Process hundreds place
        if (number >= 100) {
            words += units[number / 100] + " Hundred";
            number %= 100;
            if (number > 0) {
                words += " and ";
            }
        }

        // Process tens and units place
        if (number >= 20) {
            words += tens[number / 10];
            number %= 10;
            if (number > 0) {
                words += "-" + units[number];
            }
        } else if (number >= 10) {
            words += teens[number - 10];
        } else if (number > 0) {
            words += units[number];
        }

        return words.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        // Input number
        do {
            System.out.println("Enter a natural number less than 1000:");
            number = scanner.nextInt();
        } while (number < 0 || number >= 1000);

        // Convert number to words
        String result = convertToWords(number);

        // Display the result
        System.out.println("The number in words is: " + result);

        scanner.close();
    }
}
