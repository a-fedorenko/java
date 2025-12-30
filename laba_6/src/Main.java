import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        Scanner scanner = new Scanner(System.in);

        translator.addWord("I", "Я");
        translator.addWord("have", "маю");
        translator.addWord("cat", "кота");
        translator.addWord("his", "його");
        translator.addWord("name", "ім'я");
        translator.addWord("is", "є");

        while (true) {
            System.out.println("\n--- МЕНЮ ПЕРЕКЛАДАЧА ---");
            System.out.println("1. Перекласти фразу");
            System.out.println("2. Додати слово до словника");
            System.out.println("3. Показати словник");
            System.out.println("0. Вихід");
            System.out.print("Вибір: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Введіть фразу англійською: ");
                String phrase = scanner.nextLine();
                String result = translator.translatePhrase(phrase);
                System.out.println("Переклад: " + result);

            } else if (choice.equals("2")) {
                System.out.print("Введіть англійське слово: ");
                String en = scanner.nextLine();
                System.out.print("Введіть український переклад: ");
                String ua = scanner.nextLine();
                translator.addWord(en, ua);
                System.out.println("Слово додано!");

            } else if (choice.equals("3")) {
                translator.showDictionary();

            } else if (choice.equals("0")) {
                break;
            }
        }
        scanner.close();
    }
}