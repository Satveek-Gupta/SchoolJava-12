import java.util.Scanner;

public class MatrixMirror {

    // Function to display the matrix
    public static void displayMatrix(int[][] matrix, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Function to create the mirror image of the matrix
    public static int[][] createMirrorImage(int[][] matrix, int M) {
        int[][] mirroredMatrix = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                mirroredMatrix[i][j] = matrix[i][M - j - 1];
            }
        }
        return mirroredMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the matrix
        System.out.println("Enter the size of the matrix (M):");
        int M = scanner.nextInt();

        // Check if M is within the valid range
        if (M <= 2 || M >= 20) {
            System.out.println("Invalid input! M must be greater than 2 and less than 20.");
            return;
        }

        // Input the matrix elements
        int[][] matrix = new int[M][M];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Display the original matrix
        System.out.println("Original Matrix:");
        displayMatrix(matrix, M);

        // Create and display the mirror image matrix
        int[][] mirroredMatrix = createMirrorImage(matrix, M);
        System.out.println("Mirror Image Matrix:");
        displayMatrix(mirroredMatrix, M);

        scanner.close();
    }
}
