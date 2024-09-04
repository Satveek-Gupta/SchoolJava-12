import java.util.Scanner;

public class ISBNValidator {

    // Function to check if a string is a valid 10-digit ISBN
    public static boolean isValidISBN(String isbn) {
        if (isbn.length() != 10) {
            return false; // ISBN must be 10 characters long
        }

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            char ch = isbn.charAt(i);

            if (ch < '0' || ch > '9') {
                return false; // The first 9 characters must be digits
            }

            sum += (10 - i) * (ch - '0'); // Multiply the digit by (10 - i) and add to sum
        }

        // Check the last digit
        char lastChar = isbn.charAt(9);
        if (lastChar == 'X') {
            sum += 10; // If the last digit is 'X', it represents 10
        } else if (lastChar >= '0' && lastChar <= '9') {
            sum += (lastChar - '0'); // Otherwise, it's a digit
        } else {
            return false; // Last character is neither a digit nor 'X'
        }

        return (sum % 11 == 0); // ISBN is valid if the sum is divisible by 11
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the ISBN code
        System.out.println("Enter the 10-digit ISBN code:");
        String isbn = scanner.nextLine();

        // Check if the ISBN is valid and display appropriate messages
        if (isbn.length() == 10 && isValidISBN(isbn)) {
            System.out.println("The ISBN " + isbn + " is VALID.");
        } else {
            System.out.println("The ISBN " + isbn + " is INVALID.");
        }

        scanner.close();
    }
}
