package mvc.controller;

import mvc.model.vehicles.*;
import mvc.model.people.*;
import mvc.view.TransportView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportController {
    private Road road;
    private TransportView view;
    private final String FILE_NAME = "passengers.dat";

    public TransportController() {
        this.road = new Road();
        this.view = new TransportView();
        setupInitialData();
    }

    /**
     * Початкове наповнення даними згідно з умовами завдання
     */
    private void setupInitialData() {
        try {
            FireTruck ft = new FireTruck("Scania", 2);
            ft.board(new Fireman("Василь"));
            road.addCarToRoad(ft);
            
            Taxi taxi = new Taxi("Toyota", 4);
            taxi.board(new Policeman("Петро"));
            taxi.board(new Passenger("Марія"));
            road.addCarToRoad(taxi);

            Bus bus = new Bus("Mercedes", 20);
            bus.board(new Passenger("Олексій"));
        } catch (Exception e) { 
            view.displayMessage("Помилка при ініціалізації: " + e.getMessage()); 
        }
    }

    /**
     * Збереження пасажирів у файл (ObjectOutputStream)
     */
    public void savePassengers(List<? extends Human> list, String file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(list);
            view.displayMessage("Дані успішно збережено у файл: " + file);
        } catch (IOException e) { 
            view.displayMessage("Помилка запису: " + e.getMessage()); 
        }
    }

    /**
     * Читання пасажирів з файлу (ObjectInputStream)
     */
    @SuppressWarnings("unchecked")
    public void loadPassengers(String file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            List<Human> loaded = (List<Human>) in.readObject();
            view.displayMessage("--- Завантажені пасажири з файлу ---");
            if (loaded.isEmpty()) {
                view.displayMessage("Файл порожній.");
            } else {
                for (Human h : loaded) {
                    view.displayMessage("- " + h.toString());
                }
            }
        } catch (FileNotFoundException e) {
            view.displayMessage("Файл не знайдено. Спочатку збережіть дані (пункт 2).");
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Помилка читання: " + e.getMessage());
        }
    }

    /**
     * Основний цикл програми (Меню)
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                view.printMenu();
                if (!scanner.hasNextLine()) break;
                
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        view.displayMessage("Загальна кількість людей у машинах на дорозі: " + road.getCountOfHumans());
                        break;
                    case "2":
                        List<Human> allOnRoad = new ArrayList<>();
                        for (Vehicle<?> car : road.carsInRoad) {
                            allOnRoad.addAll(car.getPassengers());
                        }
                        savePassengers(allOnRoad, FILE_NAME);
                        break;
                    case "3":
                        loadPassengers(FILE_NAME);
                        break;
                    case "0":
                        view.displayMessage("Завершення роботи.");
                        return;
                    default:
                        view.displayMessage("Невірний вибір. Спробуйте ще раз (0-3).");
                        break;
                }
            }
        }
    }
}