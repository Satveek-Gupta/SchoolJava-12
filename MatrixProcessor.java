import java.util.Arrays;
import java.util.Scanner;

public class MatrixProcessor {

    // Method to display the matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    // Method to find and display max and min values along with their positions
    public static void findMinMax(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minRow = -1, minCol = -1;
        int maxRow = -1, maxCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Minimum value: " + min + " at position (" + minRow + "," + minCol + ")");
        System.out.println("Maximum value: " + max + " at position (" + maxRow + "," + maxCol + ")");
    }

    // Method to sort the matrix elements and rearrange them
    public static void sortAndRearrangeMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] flatArray = new int[M * N];

        // Convert matrix to flat array
        int index = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                flatArray[index++] = matrix[i][j];
            }
        }

        // Sort the flat array
        Arrays.sort(flatArray);

        // Convert the sorted flat array back to matrix
        index = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = flatArray[index++];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M, N;

        // Input matrix dimensions
        do {
            System.out.println("Enter the number of rows (M) and columns (N) for the matrix (both greater than 2 and less than 20):");
            M = scanner.nextInt();
            N = scanner.nextInt();
        } while (M <= 2 || M >= 20 || N <= 2 || N >= 20);

        int[][] matrix = new int[M][N];

        // Input matrix elements
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Display the input matrix
        System.out.println("Input Matrix:");
        displayMatrix(matrix);

        // Find and display min and max values and their positions
        findMinMax(matrix);

        // Sort and rearrange the matrix
        sortAndRearrangeMatrix(matrix);

        // Display the rearranged matrix
        System.out.println("Rearranged Matrix:");
        displayMatrix(matrix);

        scanner.close();
    }
}
