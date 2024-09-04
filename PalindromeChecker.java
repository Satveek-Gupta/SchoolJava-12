import java.util.Scanner;
import java.util.ArrayList;

public class PalindromeChecker {

    // Method to check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence in UPPER CASE terminated by '.', '?', or '!':");

        // Read the sentence
        String sentence = scanner.nextLine().trim();

        // Validate and clean the input
        if (!sentence.endsWith(".") && !sentence.endsWith("?") && !sentence.endsWith("!")) {
            System.out.println("The sentence should end with '.', '?', or '!'.");
            return;
        }

        // Remove the terminating punctuation
        sentence = sentence.substring(0, sentence.length() - 1).trim();

        // Split the sentence into words
        String[] words = sentence.split(" ");

        // List to hold palindromic words
        ArrayList<String> palindromicWords = new ArrayList<>();

        // Check each word for being a palindrome
        for (String word : words) {
            if (isPalindrome(word)) {
                palindromicWords.add(word);
            }
        }

        // Display the count of palindromic words
        System.out.println("Count of palindromic words: " + palindromicWords.size());

        // Display the palindromic words
        if (!palindromicWords.isEmpty()) {
            System.out.println("Palindromic words: " + String.join(", ", palindromicWords));
        } else {
            System.out.println("No palindromic words found.");
        }

        scanner.close();
    }
}
