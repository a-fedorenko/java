package mvc.model.vehicles;

import mvc.model.people.Human;

public class Taxi extends Car<Human> {
    public Taxi(String modelName, int maxSeats) {
        super(modelName, maxSeats);
    }
}