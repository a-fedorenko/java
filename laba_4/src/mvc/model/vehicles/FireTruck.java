package mvc.model.vehicles;

import mvc.model.people.Fireman;

public class FireTruck extends Car<Fireman> {
    public FireTruck(String modelName, int maxSeats) {
        super(modelName, maxSeats);
    }
}