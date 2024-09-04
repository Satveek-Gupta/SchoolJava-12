import java.util.Scanner;

public class MatrixOperations1 {

    // Function to rotate the matrix 90 degrees clockwise
    public static int[][] rotateMatrix(int[][] matrix, int m) {
        int[][] rotatedMatrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][m - 1 - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }
    
    // Function to find the sum of the four corners of the matrix
    public static int sumOfCorners(int[][] matrix, int m) {
        return matrix[0][0] + matrix[0][m-1] + matrix[m-1][0] + matrix[m-1][m-1];
    }
    
    // Function to display the matrix
    public static void displayMatrix(int[][] matrix, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input matrix size
        System.out.print("Enter the size of the matrix (M) [3 <= M < 10]: ");
        int m = scanner.nextInt();
        
        // Validate the input
        if (m < 3 || m >= 10) {
            System.out.println("INVALID INPUT");
            return;
        }
        
        // Declare and input matrix
        int[][] matrix = new int[m][m];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Display original matrix
        System.out.println("Original Matrix:");
        displayMatrix(matrix, m);
        
        // Rotate the matrix 90 degrees clockwise
        int[][] rotatedMatrix = rotateMatrix(matrix, m);
        
        // Display rotated matrix
        System.out.println("\nRotated Matrix (90 degrees clockwise):");
        displayMatrix(rotatedMatrix, m);
        
        // Calculate and display the sum of the corners
        int sumCorners = sumOfCorners(matrix, m);
        System.out.println("\nSum of the corners of the original matrix: " + sumCorners);
        
        scanner.close();
    }
}
