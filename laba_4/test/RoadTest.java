import mvc.model.people.Passenger;
import mvc.model.people.Policeman;
import mvc.model.vehicles.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class RoadTest {
    @Test
    @DisplayName("Підрахунок людей на порожній дорозі")
    void testEmptyRoad() {
        Road road = new Road();
        assertEquals(0, road.getCountOfHumans(), "На порожній дорозі має бути 0 людей");
    }

    @Test
    @DisplayName("Складний підрахунок: різні авто з різною кількістю пасажирів")
    void testComplexRoadCounting() throws Exception {
        Road road = new Road();
        
        Taxi t1 = new Taxi("Taxi 1", 4);
        t1.board(new Passenger("A"));
        t1.board(new Passenger("B"));
        
        PoliceCar pc = new PoliceCar("Police", 2);
        pc.board(new Policeman("C"));
        
        FireTruck ft = new FireTruck("Fire", 2);
        
        road.addCarToRoad(t1);
        road.addCarToRoad(pc);
        road.addCarToRoad(ft);
        
        assertEquals(3, road.getCountOfHumans(), "Загалом має бути 3 людини");
    }

    @Test
    @DisplayName("Додавання одного і того ж авто двічі")
    void testAddSameCarTwice() {
        Road road = new Road();
        Taxi t = new Taxi("Lanos", 4);
        
        road.addCarToRoad(t);
        road.addCarToRoad(t);
        
        assertEquals(2, road.carsInRoad.size());
    }
}