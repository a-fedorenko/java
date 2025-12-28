package mvc.model.vehicles;

import mvc.model.people.Human;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    private String modelName;
    private int maxSeats;
    private List<T> passengers = new ArrayList<>();

    public Vehicle(String modelName, int maxSeats) {
        this.modelName = modelName;
        this.maxSeats = maxSeats;
    }

    public void board(T human) throws Exception {
        if (passengers.size() >= maxSeats) {
            throw new Exception("У транспортному засобі '" + modelName + "' немає вільних місць!");
        }
        passengers.add(human);
    }

    public void unboard(T human) throws Exception {
        if (!passengers.remove(human)) {
            throw new Exception("Пасажира " + human.getName() + " немає в салоні '" + modelName + "'!");
        }
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public List<T> getPassengers() {
        return passengers;
    }

    public int getOccupiedCount() {
        return passengers.size();
    }
}
