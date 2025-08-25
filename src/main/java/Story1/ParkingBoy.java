package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static Story1.BoyParkCarStrategyEnum.getStrategy;

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
        BoyParkCarStrategy strategy = getStrategy(boyState);
        if (strategy != null){
            return strategy.parkCar(parkingLotList, car);
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
