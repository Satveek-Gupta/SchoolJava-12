import java.util.Scanner;

public class CompositeMagicNumbers {

    // Function to check if a number is composite
    public static boolean isComposite(int num) {
        if (num <= 1) {
            return false;
        }
        int factorCount = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factorCount++;
            }
        }
        return factorCount > 2;
    }

    // Function to check if a number is a magic number
    public static boolean isMagicNumber(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the range m and n
        System.out.print("Enter the value of m: ");
        int m = scanner.nextInt();
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Validate the input
        if (m < 1 || n < 1 || m >= n) {
            System.out.println("Invalid input. Ensure that m and n are positive integers and m < n.");
            return;
        }

        // Find and display composite magic numbers
        System.out.print("THE COMPOSITE MAGIC INTEGERS ARE: ");
        int frequency = 0;
        for (int i = m; i <= n; i++) {
            if (isComposite(i) && isMagicNumber(i)) {
                System.out.print(i + " ");
                frequency++;
            }
        }
        
        // Display the frequency of composite magic numbers
        System.out.println("\nFREQUENCY OF COMPOSITE MAGIC INTEGERS IS: " + frequency);
        
        scanner.close();
    }
}
