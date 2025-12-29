import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<JournalEntry> journal = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ЖУРНАЛ КУРАТОРА ---");
            System.out.println("1. Додати нову нотатку");
            System.out.println("2. Переглянути всі записи");
            System.out.println("0. Вийти");
            
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                addEntry();
            } else if (choice.equals("2")) {
                showAllEntries();
            } else if (choice.equals("0")) {
                System.out.println("Роботу завершено.");
                break;
            } else {
                System.out.println("Невірний пункт меню!");
            }
        }
    }

    private static void addEntry() {
        System.out.println("\nВведіть дані студента:");
        
        String lastName = inputWithRetry("Прізвище:");
        String firstName = inputWithRetry("Ім'я:");
        String birthDate = inputWithRetry("Дата народження (дд.мм.рррр):");
        String phone = inputWithRetry("Телефон:");
        String address = inputWithRetry("Домашня адреса (вул., буд., кв.):");

        JournalEntry newEntry = new JournalEntry(lastName, firstName, birthDate, phone, address);

        if (journal.contains(newEntry)) {
            System.out.println("Помилка: такий запис вже існує в журналі!");
        } else {
            journal.add(newEntry);
            System.out.println("Запис успішно додано до журналу.");
        }
    }

    private static String inputWithRetry(String label) {
        while (true) {
            System.out.print(label + " ");
            String result = scanner.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.out.println("Помилка: Дані не можуть бути порожніми. Спробуйте ще раз.");
        }
    }

    private static void showAllEntries() {
        if (journal.isEmpty()) {
            System.out.println("\nЖурнал наразі не містить жодного запису.");
        } else {
            System.out.println("\n--- СПИСОК НОТАТОК У ЖУРНАЛІ ---");
            for (JournalEntry entry : journal) {
                System.out.println(entry);
            }
        }
    }
}