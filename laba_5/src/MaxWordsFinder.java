import java.io.*;

public class MaxWordsFinder {
    public static void main(String[] args) {
        String filePath = "input.txt";
        String maxWordsLine = "";
        int maxCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
    
                String[] words = currentLine.trim().split("\\s+");
                if (currentLine.trim().isEmpty()) continue;

                if (words.length > maxCount) {
                    maxCount = words.length;
                    maxWordsLine = currentLine;
                }
            }
            System.out.println("Рядок з максимальною кількістю слів (" + maxCount + "):");
            System.out.println(maxWordsLine);
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}