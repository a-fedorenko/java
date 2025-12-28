package mvc.model.vehicles;

import mvc.model.people.Policeman;

public class PoliceCar extends Car<Policeman> {
    public PoliceCar(String modelName, int maxSeats) {
        super(modelName, maxSeats);
    }
}