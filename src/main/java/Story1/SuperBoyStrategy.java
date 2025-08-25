package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperBoyStrategy implements BoyParkCarStrategy{
    @Override
    public Ticket parkCar(List<ParkingLot> parkingLotList, Car car) throws NoAvaialblePositionException {
        Optional<ParkingLot> optionalParkingLot = parkingLotList.stream()
                .max(Comparator.comparingDouble(lot -> {
                    int parkedCars = lot.getCarSet().size();
                    int total = lot.getCapacity() + parkedCars;
                    // 避免除以0（容量为0且无车的情况）
                    return total == 0 ? 0.0 : (double) lot.getCapacity() / total;
                }));
        if (optionalParkingLot.isPresent()) {
            ParkingLot parkingLot = optionalParkingLot.get();
            if (parkingLot.getCapacity() > 0) {
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
