import java.util.Scanner;

public class SentenceProcessor {
    
    // Function to check if a character is a vowel
    public static boolean isVowel(char c) {
        return "AEIOU".indexOf(c) != -1;
    }
    
    // Function to check if a word begins and ends with a vowel
    public static boolean beginsAndEndsWithVowel(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input sentence
        System.out.println("Enter a sentence (terminated by '.', '?' or '!' and in UPPER CASE):");
        String sentence = scanner.nextLine().trim();
        
        // Ensure the sentence ends with '.', '?' or '!'
        if (sentence.length() == 0 || ".!?".indexOf(sentence.charAt(sentence.length() - 1)) == -1) {
            System.out.println("Invalid sentence termination.");
            return;
        }
        
        // Split the sentence into words
        String[] words = sentence.substring(0, sentence.length() - 1).split("\\s+"); // Remove punctuation and split
        
        int vowelWordCount = 0;
        StringBuilder vowelWords = new StringBuilder();
        StringBuilder otherWords = new StringBuilder();
        
        // Process each word
        for (String word : words) {
            if (beginsAndEndsWithVowel(word)) {
                vowelWordCount++;
                vowelWords.append(word).append(" ");
            } else {
                otherWords.append(word).append(" ");
            }
        }
        
        // Output the results
        System.out.println("NUMBER OF WORDS BEGINNING AND ENDING WITH A VOWEL = " + vowelWordCount);
        System.out.println(vowelWords.toString().trim() + " " + otherWords.toString().trim());
        
        scanner.close();
    }
}
