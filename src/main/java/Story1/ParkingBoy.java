package Story1;

import UserDefinedException.NoAvaialblePositionException;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(ParkingLot parkingLot, Car car) throws NoAvaialblePositionException {
        return parkingLot.park(car);
    }


    public Car fetch(Ticket ticket, ParkingLot parkingLot) {
        return parkingLot.fetch(ticket, parkingLot);
    }
}
