package Story1;


import UserDefinedException.NoAvaialblePositionException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void test_park_car() throws NoAvaialblePositionException {
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        String[] carIds = {};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        int oldSize = carSet.size();
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
        assertEquals(oldSize + 1,parkingLot.getCarSet().size());
    }

    @Test
    public void test_fetch_car() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        int oldSize = carSet.size();
        String carId = "100";
        Car car = new Car(carId);
        Ticket ticket = new Ticket("100", false, car);
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        Car fetchCar = parkingLot.fetch(ticket, parkingLot);
        assertNotNull(fetchCar);
        assertEquals(oldSize - 1,parkingLot.getCarSet().size());
    }

    @Test
    public void test_wrong_ticket() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        Ticket ticket = new Ticket("150", false, new Car("150"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->  parkingLot.fetch(ticket, parkingLot));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void test_null_ticket() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->  parkingLot.fetch(null, parkingLot));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void test_used_ticket() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        Ticket ticket = new Ticket("100", true, new Car("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->  parkingLot.fetch(ticket, parkingLot));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void test_park_car_without_position() {
        String[] carIds = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        NoAvaialblePositionException exception = assertThrows(NoAvaialblePositionException.class, () ->  parkingLot.park(car));
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void test_boy_park_car() throws NoAvaialblePositionException {
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        String[] carIds = {};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        int oldSize = carSet.size();
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(parkingLot, car);
        assertNotNull(ticket);
        assertEquals(oldSize + 1, parkingLot.getCarSet().size());
    }

    @Test
    public void test_boy_fetch_car() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        int oldSize = carSet.size();
        String carId = "100";
        Car car = new Car(carId);
        Ticket ticket = new Ticket("100", false, car);
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car fetchCar = parkingBoy.fetch(ticket, parkingLot);
        assertNotNull(fetchCar);
        assertEquals(oldSize - 1, parkingLot.getCarSet().size());
    }

}
