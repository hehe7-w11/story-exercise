package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CleverBoyStrategy implements BoyParkCarStrategy{
    @Override
    public Ticket parkCar(List<ParkingLot> parkingLotList, Car car) throws NoAvaialblePositionException {
        Optional<ParkingLot> optionalParkingLot = parkingLotList.stream()
                .max(Comparator.comparingInt(ParkingLot::getCapacity));
        if (optionalParkingLot.isPresent()) {
            ParkingLot parkingLot = optionalParkingLot.get();
            if (parkingLot.getCapacity() > 0) {
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
