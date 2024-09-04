import java.util.Scanner;

public class SentenceEncryption {

    // Method to encrypt a sentence by shifting characters two positions ahead
    public static String encryptSentence(String sentence) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            encrypted.append((char) (c + 2));
        }
        return encrypted.toString();
    }

    // Method to reverse a sentence
    public static String reverseSentence(String sentence) {
        return new StringBuilder(sentence).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Input size of the array
        System.out.println("Enter the size of the array (between 2 and 9):");
        n = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        // Validate size
        if (n <= 1 || n >= 10) {
            System.out.println("Invalid size. The size must be greater than 1 and less than 10.");
            return;
        }

        // Define the string array
        String[] sentences = new String[n];

        // Input sentences into the array
        System.out.println("Enter " + n + " sentences (each ending with a full stop):");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine().trim();
            if (!sentences[i].endsWith(".")) {
                System.out.println("Each sentence must end with a full stop.");
                return;
            }
        }

        // Process and display the sentences
        System.out.println("Encrypted sentences:");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Odd rows (0-based index) - encrypt
                System.out.println(encryptSentence(sentences[i]));
            } else {
                // Even rows (0-based index) - reverse
                System.out.println(reverseSentence(sentences[i]));
            }
        }

        scanner.close();
    }
}
