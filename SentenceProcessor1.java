import java.util.Scanner;

public class SentenceProcessor1 {
    
    // Function to count vowels in a word
    public static int countVowels(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    // Function to count consonants in a word
    public static int countConsonants(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c >= 'a' && c <= 'z' && !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sentence
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine().trim();

        // Validate sentence termination
        if (sentence.isEmpty() || (!sentence.endsWith(".") && !sentence.endsWith("?"))) {
            System.out.println("Invalid Input.");
            return;
        }

        // Split the sentence into words
        String[] words = sentence.substring(0, sentence.length() - 1).split("\\s+");

        // Capitalize the first letter of each word and construct the formatted sentence
        StringBuilder formattedSentence = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            formattedSentence.append(words[i]).append(" ");
        }

        // Display the formatted sentence
        System.out.println("Formatted Sentence:");
        System.out.println(formattedSentence.toString().trim());

        // Display the word, vowel count, and consonant count
        System.out.println("\nWORD\t\tVOWELS\tCONSONANTS");
        for (String word : words) {
            int vowels = countVowels(word);
            int consonants = countConsonants(word);
            System.out.println(word + "\t\t" + vowels + "\t\t" + consonants);
        }

        scanner.close();
    }
}