package Story1;


import UserDefinedException.NoAvaialblePositionException;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        assertEquals(oldSize + 1, parkingLot.getCarSet().size());
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
        assertEquals(oldSize - 1, parkingLot.getCarSet().size());
    }

    @Test
    public void test_wrong_ticket() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        Ticket ticket = new Ticket("150", false, new Car("150"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingLot.fetch(ticket, parkingLot));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void test_null_ticket() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingLot.fetch(null, parkingLot));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void test_used_ticket() {
        String[] carIds = {"100", "200", "300", "400"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        Ticket ticket = new Ticket("100", true, new Car("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingLot.fetch(ticket, parkingLot));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void test_park_car_without_position() {
        String[] carIds = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        NoAvaialblePositionException exception = assertThrows(NoAvaialblePositionException.class, () -> parkingLot.park(car));
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void test_boy_park_car() throws NoAvaialblePositionException {
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        String[] carIds = {};
        Set<String> carSet = new HashSet<>(Arrays.asList(carIds));
        int oldSize = carSet.size();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(10 - carSet.size(), carSet);
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList, 0);
        Ticket ticket = parkingBoy.park(parkingBoy.getParkingLotList(), car, parkingBoy.getBoyState());
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
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList, 0);
        Car fetchCar = parkingBoy.fetch(ticket, parkingBoy.getParkingLotList());
        assertNotNull(fetchCar);
        assertEquals(oldSize - 1, parkingLot.getCarSet().size());
    }

    @Test
    public void test_not_clever_boy_park_car() throws NoAvaialblePositionException {
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        String[] carIds1 = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
        Set<String> carSet1 = new HashSet<>(Arrays.asList(carIds1));
        String[] carIds2 = {};
        Set<String> carSet2 = new HashSet<>(Arrays.asList(carIds2));
        int oldSize = carSet2.size();
        ParkingLot parkingLot1 = new ParkingLot(10 - carSet1.size(), carSet1);
        ParkingLot parkingLot2 = new ParkingLot(10 - carSet2.size(), carSet2);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList, 0);
        Ticket ticket = parkingBoy.park(parkingBoy.getParkingLotList(), car, parkingBoy.getBoyState());
        assertNotNull(ticket);
        assertEquals(oldSize + 1, parkingLot2.getCarSet().size());
    }

    @Test
    public void test_clever_boy_park_car() throws NoAvaialblePositionException {
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        String[] carIds1 = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
        Set<String> carSet1 = new HashSet<>(Arrays.asList(carIds1));
        String[] carIds2 = {"100", "200", "300"};
        Set<String> carSet2 = new HashSet<>(Arrays.asList(carIds2));
        int oldSize = carSet2.size();
        String[] carIds3 = {"100", "200", "300", "400", "500", "600"};
        Set<String> carSet3 = new HashSet<>(Arrays.asList(carIds3));
        ParkingLot parkingLot1 = new ParkingLot(10 - carSet1.size(), carSet1);
        ParkingLot parkingLot2 = new ParkingLot(10 - carSet2.size(), carSet2);
        ParkingLot parkingLot3 = new ParkingLot(10 - carSet2.size(), carSet3);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot1, parkingLot2, parkingLot3);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList, 1);
        Ticket ticket = parkingBoy.park(parkingBoy.getParkingLotList(), car, parkingBoy.getBoyState());
        assertNotNull(ticket);
        assertEquals(oldSize + 1, parkingLot2.getCarSet().size());
    }

    @Test
    public void test_super_boy_park_car() throws NoAvaialblePositionException {
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        String[] carIds1 = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
        Set<String> carSet1 = new HashSet<>(Arrays.asList(carIds1));
        String[] carIds2 = {"100", "200", "300"};
        Set<String> carSet2 = new HashSet<>(Arrays.asList(carIds2));
        int oldSize = carSet2.size();
        String[] carIds3 = {"100", "200", "300", "400", "500", "600"};
        Set<String> carSet3 = new HashSet<>(Arrays.asList(carIds3));
        ParkingLot parkingLot1 = new ParkingLot(10 - carSet1.size(), carSet1);
        ParkingLot parkingLot2 = new ParkingLot(10 - carSet2.size(), carSet2);
        ParkingLot parkingLot3 = new ParkingLot(10 - carSet2.size(), carSet3);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot1, parkingLot2, parkingLot3);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList, 2);
        Ticket ticket = parkingBoy.park(parkingBoy.getParkingLotList(), car, parkingBoy.getBoyState());
        assertNotNull(ticket);
        assertEquals(oldSize + 1, parkingLot2.getCarSet().size());
    }




}
