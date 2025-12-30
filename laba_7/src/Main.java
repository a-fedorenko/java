import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String input = "I have a cat, his 123 name is Pat. He sits on a mat and wears a hat.";
        
        String[] result = findIncreasingCharWords(input);

        System.out.println("Вхідний рядок: [" + input + "]");
        System.out.println("\nСлова з літерами у порядку зростання:");
        
        Arrays.stream(result).forEach(word -> System.out.println("-> " + word));
    }

    public static String[] findIncreasingCharWords(String text) {
        if (text == null || text.trim().isEmpty()) return new String[0];

        return Arrays.stream(text.split("\\s+"))
                .map(word -> word.replaceAll("[^a-zA-Zа-яА-Я]", ""))
                .filter(word -> !word.isEmpty() && word.matches("[a-zA-Zа-яА-Я]+"))
                .filter(word -> {
                    if (word.length() == 1) return true;
                    return IntStream.range(0, word.length() - 1)
                            .allMatch(i -> word.charAt(i) <= word.charAt(i + 1));
                })
                .toArray(String[]::new);
    }
}