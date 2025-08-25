package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.List;

public class NotCleverBoyStrategy implements BoyParkCarStrategy{
    @Override
    public Ticket parkCar(List<ParkingLot> parkingLotList, Car car) throws NoAvaialblePositionException {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getCapacity() > 0) {
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
