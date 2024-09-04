import java.util.Scanner;

public class CircularPrime {
    
    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Function to perform a cyclic shift on the digits of a number
    public static int rotateNumber(int num) {
        String numStr = Integer.toString(num);
        String rotatedStr = numStr.substring(1) + numStr.charAt(0);
        return Integer.parseInt(rotatedStr);
    }
    
    // Function to check if a number is a circular prime
    public static boolean isCircularPrime(int num) {
        int count = numDigits(num);
        int rotatedNum = num;
        
        for (int i = 0; i < count; i++) {
            if (!isPrime(rotatedNum)) {
                return false;
            }
            rotatedNum = rotateNumber(rotatedNum);
        }
        return true;
    }
    
    // Function to count the number of digits in a number
    public static int numDigits(int num) {
        return Integer.toString(num).length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        if (isCircularPrime(num)) {
            System.out.println(num + " is a circular prime.");
        } else {
            System.out.println(num + " is not a circular prime.");
        }
        
        scanner.close();
    }
}