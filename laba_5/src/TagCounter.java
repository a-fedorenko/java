import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class TagCounter {
    public static void main(String[] args) {
        String urlString = "https://www.google.com";
        Map<String, Integer> tagMap = new HashMap<>();

        try {
            URL url = new URI(urlString).toURL();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                Pattern pattern = Pattern.compile("<([a-zA-Z0-9]+)");
                
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String tag = matcher.group(1).toLowerCase();
                        tagMap.put(tag, tagMap.getOrDefault(tag, 0) + 1);
                    }
                }
            }

            System.out.println("URL: " + urlString);
            System.out.println("\nТеги за алфавітом");
            tagMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(e -> System.out.printf("%-10s : %d\n", e.getKey(), e.getValue()));

            System.out.println("\nТеги за частотою появи");
            tagMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(e -> System.out.printf("%-10s : %d\n", e.getKey(), e.getValue()));

        } catch (Exception e) {
            System.err.println("Помилка при роботі з URL: " + e.getMessage());
        }
    }
}