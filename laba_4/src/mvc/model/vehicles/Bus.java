package mvc.model.vehicles;

import mvc.model.people.Human;

public class Bus extends Vehicle<Human> {
    public Bus(String modelName, int maxSeats) {
        super(modelName, maxSeats);
    }
}