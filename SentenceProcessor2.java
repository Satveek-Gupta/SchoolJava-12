import java.util.Scanner;

public class SentenceProcessor2 {

    // Function to remove extra spaces between words in a sentence
    public static String removeExtraSpaces(String sentence) {
        return sentence.trim().replaceAll("\\s+", " ");
    }

    // Function to delete a word at a specific position in the sentence
    public static String deleteWord(String sentence, int position) {
        String[] words = sentence.split(" ");
        
        if (position < 1 || position > words.length) {
            return "Invalid position.";
        }
        
        StringBuilder newSentence = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (i != position - 1) {
                newSentence.append(words[i]).append(" ");
            }
        }
        
        return newSentence.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the sentence
        System.out.println("Enter a sentence terminated by '.', '?', or '!':");
        String sentence = scanner.nextLine();

        // Check if the sentence ends with '.', '?', or '!'
        if (!sentence.endsWith(".") && !sentence.endsWith("?") && !sentence.endsWith("!")) {
            System.out.println("Invalid sentence termination.");
            return;
        }

        // Remove extra spaces
        sentence = removeExtraSpaces(sentence);
        System.out.println("Sentence after removing extra spaces: " + sentence);

        // Input the word position to delete
        System.out.println("Enter the word position to delete:");
        int position = scanner.nextInt();
        scanner.nextLine();  // consume the newline

        // Delete the word and display the new sentence
        String newSentence = deleteWord(sentence, position);
        System.out.println("Sentence after deleting the word at position " + position + ": " + newSentence);

        scanner.close();
    }
}
