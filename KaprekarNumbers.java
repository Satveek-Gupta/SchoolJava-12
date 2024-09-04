import java.util.Scanner;

public class KaprekarNumbers {

    // Method to check if a number is a Kaprekar number
    public static boolean isKaprekarNumber(int n) {
        int d = String.valueOf(n).length(); // Number of digits in n
        long square = (long) n * n; // Square of the number
        
        // Convert the square to a string to split it
        String squareStr = Long.toString(square);
        int len = squareStr.length();
        
        // Split the square into two parts
        String rightPart = squareStr.length() > d ? squareStr.substring(len - d) : squareStr;
        String leftPart = squareStr.length() > d ? squareStr.substring(0, len - d) : "0";
        
        // Convert the parts back to integers
        int right = Integer.parseInt(rightPart);
        int left = Integer.parseInt(leftPart);
        
        // Check if the sum of the parts equals the original number
        return (left + right) == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input range
        System.out.println("Enter two positive integers p and q where p < q:");
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        
        // Validate the input
        if (p <= 0 || q <= 0 || p >= q) {
            System.out.println("Invalid input. Ensure that p < q and both are positive integers.");
            return;
        }
        
        // Find and display Kaprekar numbers in the range
        System.out.println("Kaprekar numbers between " + p + " and " + q + ":");
        boolean foundKaprekar = false;
        
        for (int i = p; i <= q; i++) {
            if (isKaprekarNumber(i)) {
                System.out.println(i);
                foundKaprekar = true;
            }
        }
        
        if (!foundKaprekar) {
            System.out.println("No Kaprekar numbers in the given range.");
        }
        
        scanner.close();
    }
}
