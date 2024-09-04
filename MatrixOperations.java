import java.util.Scanner;
import java.util.Arrays;

public class MatrixOperations {
    
    // Function to check if a given element is on the boundary of the matrix
    public static boolean isBoundary(int i, int j, int m) {
        return i == 0 || j == 0 || i == m - 1 || j == m - 1;
    }

    // Function to sort and rearrange non-boundary elements
    public static void sortNonBoundary(int[][] matrix, int m) {
        int index = 0;
        int[] nonBoundaryElements = new int[(m - 2) * (m - 2)];
        
        // Extract non-boundary elements
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                nonBoundaryElements[index++] = matrix[i][j];
            }
        }
        
        // Sort the non-boundary elements
        Arrays.sort(nonBoundaryElements);
        index = 0;
        
        // Replace the non-boundary elements in the matrix
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                matrix[i][j] = nonBoundaryElements[index++];
            }
        }
    }
    
    // Function to calculate the sum of both diagonals
    public static int[] diagonalSums(int[][] matrix, int m) {
        int sumPrimary = 0, sumSecondary = 0;
        for (int i = 0; i < m; i++) {
            sumPrimary += matrix[i][i];
            sumSecondary += matrix[i][m - 1 - i];
        }
        return new int[]{sumPrimary, sumSecondary};
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
    
    // Function to display only diagonal elements
    public static void displayDiagonals(int[][] matrix, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j == m - 1) {
                    System.out.print(matrix[i][j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input matrix size
        int m;
        do {
            System.out.print("Enter the size of the matrix (M) [4 <= M <= 9]: ");
            m = scanner.nextInt();
        } while (m < 4 || m > 9);
        
        // Declare and input matrix
        int[][] matrix = new int[m][m];
        System.out.println("Enter positive integers into the matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Display original matrix
        System.out.println("\nOriginal Matrix:");
        displayMatrix(matrix, m);
        
        // Sort and rearrange non-boundary elements
        sortNonBoundary(matrix, m);
        
        // Display rearranged matrix
        System.out.println("\nRearranged Matrix:");
        displayMatrix(matrix, m);
        
        // Display diagonal elements of the rearranged matrix
        System.out.println("\nDiagonal Elements of Rearranged Matrix:");
        displayDiagonals(matrix, m);
        
        // Calculate and display the sum of both diagonals
        int[] sums = diagonalSums(matrix, m);
        System.out.println("\nSum of primary diagonal: " + sums[0]);
        System.out.println("Sum of secondary diagonal: " + sums[1]);
        
        scanner.close();
    }
}