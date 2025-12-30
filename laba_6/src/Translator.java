import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> dictionary = new HashMap<>();

    public void addWord(String english, String ukrainian) {
        dictionary.put(english.toLowerCase().trim(), ukrainian.trim());
    }

    public String translatePhrase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return "";

        String[] words = phrase.split("\\s+");
        StringBuilder translation = new StringBuilder();

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            
            String translated = dictionary.getOrDefault(cleanWord, "[" + word + "]");
            
            translation.append(translated).append(" ");
        }

        return translation.toString().trim();
    }

    public void showDictionary() {
        dictionary.forEach((en, ua) -> System.out.println(en + " - " + ua));
    }
}
