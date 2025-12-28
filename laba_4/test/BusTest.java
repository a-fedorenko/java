import mvc.model.people.Passenger;
import mvc.model.vehicles.Bus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BusTest {
    @Test
    @DisplayName("Виключна ситуація: Перевищення максимальної місткості")
    void testCapacityExceeded() throws Exception {
        Bus bus = new Bus("Sprinter", 2);
        bus.board(new Passenger("Ivan"));
        bus.board(new Passenger("Oleg"));

        Exception ex = assertThrows(Exception.class, () -> bus.board(new Passenger("Anna")));
        assertEquals("У транспортному засобі 'Sprinter' немає вільних місць!", ex.getMessage());
    }

    @Test
    @DisplayName("Виключна ситуація: Висадка пасажира з порожнього автобуса")
    void testUnboardFromEmptyBus() {
        Bus bus = new Bus("Solaris", 10);
        Passenger p = new Passenger("Stepan");

        assertThrows(Exception.class, () -> bus.unboard(p), "Має кинути помилку, бо автобус порожній");
    }

    @Test
    @DisplayName("Виключна ситуація: Висадка пасажира, який сидить в іншому авто")
    void testUnboardWrongPassenger() throws Exception {
        Bus bus1 = new Bus("Bus 1", 5);
        Bus bus2 = new Bus("Bus 2", 5);
        Passenger p = new Passenger("Andriy");

        bus1.board(p);
        
        assertThrows(Exception.class, () -> bus2.unboard(p), "Bus 2 не може висадити пасажира з Bus 1");
    }
}