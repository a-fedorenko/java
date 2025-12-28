package mvc.view;

public class TransportView {
    public void printMenu() {
        System.out.println("\nВиберіть один з пунктів");
        System.out.println("1. Показати людей на дорозі");
        System.out.println("2. Зберегти пасажирів у файл");
        System.out.println("3. Прочитати з файлу");
        System.out.println("0. Вихід");
    }

    public void displayMessage(String msg) { System.out.println(msg); }
}