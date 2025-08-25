package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.List;

public interface BoyParkCarStrategy {
    Ticket parkCar(List<ParkingLot> parkingLotList, Car car) throws NoAvaialblePositionException;
}
