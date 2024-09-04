import java.util.Arrays;
import java.util.Scanner;

public class SentenceProcessor3 {

    // Method to process the sentence
    public static void processSentence(String sentence) {
        // Remove the terminating punctuation
        char lastChar = sentence.charAt(sentence.length() - 1);
        if (lastChar == '.' || lastChar == '!' || lastChar == '?') {
            sentence = sentence.substring(0, sentence.length() - 1).trim();
        } else {
            System.out.println("The sentence should end with '.', '?', or '!'.");
            return;
        }

        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Get the number of words
        int length = words.length;

        // Sort the words in alphabetical order
        Arrays.sort(words);

        // Display the length and sorted words
        System.out.println("Length of the sentence (measured in words): " + length);
        System.out.println("Sentence in alphabetical order: " + String.join(" ", words));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence in UPPER CASE terminated by '.', '!', or '?'");

        // Read the sentence
        String sentence = scanner.nextLine().trim();

        // Process the sentence
        processSentence(sentence);

        scanner.close();
    }
}
