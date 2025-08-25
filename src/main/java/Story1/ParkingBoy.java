package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList;
    private Integer boyState; // 0：not clever, 1: clever, 2: super

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Integer getBoyState() {
        return boyState;
    }

    public void setBoyState(Integer boyState) {
        this.boyState = boyState;
    }



    public ParkingBoy(List<ParkingLot> parkingLotList, Integer boyState) {
        this.parkingLotList = parkingLotList;
        this.boyState = boyState;
    }


    public Ticket park(List<ParkingLot> parkingLotList, Car car, int boyState) throws NoAvaialblePositionException {
        switch (boyState) {
            case 0: {
                for (ParkingLot parkingLot : parkingLotList) {
                    if (parkingLot.getCapacity() > 0) {
                        return parkingLot.park(car);
                    }
                }
            }
            case 1: {
                Optional<ParkingLot> optionalParkingLot = parkingLotList.stream()
                        .max(Comparator.comparingInt(ParkingLot::getCapacity));
                if (optionalParkingLot.isPresent()) {
                    ParkingLot parkingLot = optionalParkingLot.get();
                    if (parkingLot.getCapacity() > 0) {
                        return parkingLot.park(car);
                    }
                }
            }
            case 2: {
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
