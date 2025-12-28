package mvc.model.vehicles;

import mvc.model.people.Human;

public abstract class Car<T extends Human> extends Vehicle<T> {
    public Car(String modelName, int maxSeats) {
        super(modelName, maxSeats);
    }
}