import mvc.model.people.Fireman;
import mvc.model.vehicles.FireTruck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class FireTruckTest {
    @Test
    @DisplayName("Успішна посадка та висадка кількох пожежників")
    void testFireTruckFlow() throws Exception {
        FireTruck ft = new FireTruck("MAN", 3);
        Fireman f1 = new Fireman("Пожежник 1");
        Fireman f2 = new Fireman("Пожежник 2");

        ft.board(f1);
        ft.board(f2);
        assertEquals(2, ft.getOccupiedCount());

        ft.unboard(f1);
        assertEquals(1, ft.getOccupiedCount());
        assertEquals(f2, ft.getPassengers().get(0));
    }

    @Test
    @DisplayName("Перевірка getMaxSeats та getOccupiedCount")
    void testSeatsCounters() throws Exception {
        FireTruck ft = new FireTruck("ZIL", 5);
        assertEquals(5, ft.getMaxSeats());
        assertEquals(0, ft.getOccupiedCount());
        
        ft.board(new Fireman("Max"));
        assertEquals(1, ft.getOccupiedCount());
    }
}