import mvc.model.people.*;
import mvc.model.vehicles.Taxi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TaxiTest {
    @Test
    @DisplayName("Таксі приймає мікс усіх можливих типів людей")
    void testMixOfPassengers() throws Exception {
        Taxi taxi = new Taxi("Toyota", 10);
        
        assertDoesNotThrow(() -> taxi.board(new Passenger("Цивільний")));
        assertDoesNotThrow(() -> taxi.board(new Policeman("Коп")));
        assertDoesNotThrow(() -> taxi.board(new Fireman("Рятувальник")));
        
        assertEquals(3, taxi.getOccupiedCount());
    }

    @Test
    @DisplayName("Висадка пасажира двічі (повторна висадка)")
    void testUnboardTwice() throws Exception {
        Taxi taxi = new Taxi("Renault", 2);
        Passenger p = new Passenger("Olena");
        
        taxi.board(p);
        taxi.unboard(p);
        
        assertThrows(Exception.class, () -> taxi.unboard(p));
    }
}