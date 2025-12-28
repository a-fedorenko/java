package mvc.model;

import mvc.model.people.Human;
import java.io.*;
import java.util.List;

public class FileHandler {
    /**
     * Зберігає список пасажирів у бінарний файл.
     * Використовує Wildcard (? extends Human), щоб приймати списки будь-яких людей.
     */
    public static void saveToFile(List<? extends Human> humans, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(humans);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні у файл: " + e.getMessage());
        }
    }

    /**
     * Читає список пасажирів з файлу.
     */
    @SuppressWarnings("unchecked")
    public static List<Human> loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Human>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при читанні з файлу: " + e.getMessage());
            return null;
        }
    }
}