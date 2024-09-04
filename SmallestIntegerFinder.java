import java.util.Scanner;

public class SmallestIntegerFinder {
    
    // Function to calculate the sum of digits of a number
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input M and N
        System.out.print("Enter the value of M (100 <= M <= 10000): ");
        int M = scanner.nextInt();
        System.out.print("Enter the value of N (0 < N < 100): ");
        int N = scanner.nextInt();
        
        // Validate the inputs
        if (M < 100 || M > 10000 || N <= 0 || N >= 100) {
            System.out.println("INVALID INPUT");
            return;
        }
        
        // Find the smallest number greater than M whose digits sum to N
        int result = M + 1;
        while (sumOfDigits(result) != N) {
            result++;
        }
        
        // Output the result and number of digits
        System.out.println("The required number = " + result);
        System.out.println("Total number of digits = " + String.valueOf(result).length());
        
        scanner.close();
    }
}
