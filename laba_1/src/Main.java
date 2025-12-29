import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String input = "I have a cat, his name is Pat. He sits on a mat and wears a hat.";
        String[] result = findUniqueCharWords(input);

        System.out.println("Input sentence: " + input);
        System.out.println("\nWords with unique characters:");
        for (String word : result) {
            System.out.println("-> " + word);
        }
    }

    public static String[] findUniqueCharWords(String text) {
        if (text == null || text.isEmpty()) return new String[0];

        String[] words = text.split("\\s+");
        List<String> resultList = new ArrayList<>();

        for (String word : words) {
            if (hasAllUniqueChars(word)) {
                resultList.add(word);
            }
        }

        return resultList.toArray(new String[0]);
    }

    private static boolean hasAllUniqueChars(String word) {
        Set<Character> chars = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (!chars.add(c)) {
                return false;
            }
        }
        return true;
    }
}