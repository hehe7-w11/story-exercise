package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList;
    private Boolean isClever;

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }


    public Boolean getClever() {
        return isClever;
    }

    public void setClever(Boolean clever) {
        isClever = clever;
    }


    public ParkingBoy(List<ParkingLot> parkingLotList, Boolean isClever) {
        this.parkingLotList = parkingLotList;
        this.isClever = isClever;
    }


    public Ticket park(List<ParkingLot> parkingLotList, Car car, Boolean isClever) throws NoAvaialblePositionException {
        if (!isClever) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.getCapacity() > 0) {
                    return parkingLot.park(car);
                }
            }
        } else {
            Optional<ParkingLot> optionalParkingLot = parkingLotList.stream()
                    .max(Comparator.comparingInt(ParkingLot::getCapacity));
            if (optionalParkingLot.isPresent()) {
                ParkingLot parkingLot = optionalParkingLot.get();
                if (parkingLot.getCapacity() > 0) {
                    return parkingLot.park(car);
                }
            }
        }
        return null;
    }


    public Car fetch(Ticket ticket, List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getCarSet().contains(ticket.getCar().getId())) {
                return parkingLot.fetch(ticket, parkingLot);
            }
        }
        return null;
    }
}
