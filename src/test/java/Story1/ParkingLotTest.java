package Story1;


import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    public void test_park_car(){
        String carId = UUID.randomUUID().toString();
        Car car = new Car(carId);
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);
//        System.out.println(ticket.toString());
        assertNotNull(ticket);
    }

    @Test
    public void test_fetch_car(){
        String carId = "100";
        Car car = new Car(carId);
        Ticket ticket = new Ticket("100", false, car);
        ParkingLot parkingLot = new ParkingLot();
        Car fetchCar = parkingLot.fetch(ticket);
        assertNotNull(fetchCar);
    }
}
