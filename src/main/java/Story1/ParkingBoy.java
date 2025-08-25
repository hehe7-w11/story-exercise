package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList;

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }


    public Ticket park(List<ParkingLot> parkingLotList, Car car) throws NoAvaialblePositionException {
        for(ParkingLot parkingLot : parkingLotList){
            if(parkingLot.getCapacity() > 0){
               return parkingLot.park(car);
            }
        }
        return null;
    }


    public Car fetch(Ticket ticket, List<ParkingLot> parkingLotList) {
        for(ParkingLot parkingLot : parkingLotList){
            if(parkingLot.getCarSet().contains(ticket.getCar().getId())){
                return parkingLot.fetch(ticket, parkingLot);
            }
        }
        return null;
    }
}
