import java.util.Scanner;

public class PrimePalindrome {

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        String numStr = Integer.toString(number);
        int left = 0;
        int right = numStr.length() - 1;
        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }

    // Method to find and display prime palindromes in the range [m, n]
    public static void findPrimePalindromes(int m, int n) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        
        for (int i = m; i <= n; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                count++;
                result.append(i).append(" ");
            }
        }
        
        // Display the results
        System.out.println("Count of prime palindromes: " + count);
        if (count > 0) {
            System.out.println("Prime palindromes: " + result.toString().trim());
        } else {
            System.out.println("No prime palindromes found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two positive integers m and n (m < n) where m < 3000 and n < 3000:");

        // Read the integers m and n
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Validate the input
        if (m < 0 || n < 0 || m >= n || m >= 3000 || n >= 3000) {
            System.out.println("Invalid input. Ensure m and n are positive integers where m < n and both are less than 3000.");
            return;
        }

        // Find and display prime palindromes
        findPrimePalindromes(m, n);

        scanner.close();
    }
}
