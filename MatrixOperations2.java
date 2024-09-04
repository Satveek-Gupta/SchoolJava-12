import java.util.Scanner;

public class MatrixOperations2 {

    // Function to display a matrix
    public static void displayMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Function to check if the matrix is symmetric
    public static boolean isSymmetric(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to find the sum of the left diagonal
    public static int sumLeftDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    // Function to find the sum of the right diagonal
    public static int sumRightDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][size - i - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the matrix
        System.out.print("Enter the size of the matrix (M): ");
        int M = scanner.nextInt();

        // Validate the input
        if (M <= 2 || M >= 10) {
            System.out.println("Invalid input. M should be greater than 2 and less than 10.");
            return;
        }

        int[][] matrix = new int[M][M];

        // Input the elements of the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Display the original matrix
        System.out.println("Original Matrix:");
        displayMatrix(matrix, M);

        // Check if the matrix is symmetric
        boolean symmetric = isSymmetric(matrix, M);
        if (symmetric) {
            System.out.println("The matrix is symmetric.");
        } else {
            System.out.println("The matrix is not symmetric.");
        }

        // Calculate and display the sum of diagonals
        int leftDiagonalSum = sumLeftDiagonal(matrix, M);
        int rightDiagonalSum = sumRightDiagonal(matrix, M);

        System.out.println("Sum of left diagonal: " + leftDiagonalSum);
        System.out.println("Sum of right diagonal: " + rightDiagonalSum);

        scanner.close();
    }
}
