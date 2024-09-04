// Prime.java
public class Prime {
    // Data Member
    private int n;

    // Constructor to initialize n
    public Prime(int n) {
        this.n = n;
    }

    // Method to check if the number is prime
    public void check() {
        if (isPrime(n)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }

    // Recursive method to determine if a number is prime
    private boolean isPrime(int num) {
        // Handle base cases
        if (num <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        return isPrimeHelper(num, num / 2);
    }

    // Helper method for recursion
    private boolean isPrimeHelper(int num, int divisor) {
        // Base case
        if (divisor == 1) {
            return true; // If we reach divisor 1, num is prime
        }
        if (num % divisor == 0) {
            return false; // If num is divisible by divisor, it's not prime
        }
        return isPrimeHelper(num, divisor - 1); // Recursive call with reduced divisor
    }

    public static void main(String[] args) {
        // Create an instance of Prime class
        Prime primeCheck = new Prime(29);

        // Check if the number is prime
        primeCheck.check();
    }
}
