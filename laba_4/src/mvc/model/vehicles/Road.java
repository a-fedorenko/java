package mvc.model.vehicles;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Car<?>> carsInRoad = new ArrayList<>();

    /**
     * Підраховує загальну кількість людей у всіх автомобілях на дорозі
     */
    public int getCountOfHumans() {
        int count = 0;
        for (Car<?> car : carsInRoad) {
            count += car.getOccupiedCount();
        }
        return count;
    }

    /**
     * Додає автомобіль на дорогу
     * @param car будь-який об'єкт, що успадковує Car
     */
    public void addCarToRoad(Car<?> car) {
        carsInRoad.add(car);
    }
}