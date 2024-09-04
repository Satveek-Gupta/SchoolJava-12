import java.util.*;

public class SentenceAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of sentences
        System.out.print("Enter number of sentences: ");
        int numSentences = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Validate number of sentences
        if (numSentences < 1 || numSentences > 4) {
            System.out.println("Number of sentences exceeds the limit.");
            return;
        }

        // Input sentences
        System.out.println("Enter sentences:");
        StringBuilder paragraph = new StringBuilder();
        for (int i = 0; i < numSentences; i++) {
            paragraph.append(scanner.nextLine()).append(" ");
        }

        // Process paragraph
        String[] words = paragraph.toString().toUpperCase().split("\\s+");
        Map<String, Integer> wordCount = new TreeMap<>();

        // Count word frequencies
        for (String word : words) {
            if (!word.isEmpty() && (word.endsWith(".") || word.endsWith("?"))) {
                word = word.substring(0, word.length() - 1);
            }
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Output total number of words
        int totalWords = words.length;
        System.out.println("Total number of words: " + totalWords);

        // Output word frequencies
        System.out.println("WORD        FREQUENCY");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%-10s %d%n", entry.getKey(), entry.getValue());
        }

        scanner.close();
    }
}
