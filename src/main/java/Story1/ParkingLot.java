package Story1;

import UserDefinedException.NoAvaialblePositionException;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class ParkingLot {
    private Integer capacity;
    private Set<String> carSet;

    public ParkingLot(int capacity, Set<String> carSet) {
        this.capacity = capacity;
        this.carSet = carSet;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public Set<String> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<String> carSet) {
        this.carSet = carSet;
    }

    public Ticket park(Car car) throws NoAvaialblePositionException {
        if(this.capacity == 0){
            throw new NoAvaialblePositionException("No available position.");
        }
        this.capacity--;
        this.getCarSet().add(car.getId());
        return new Ticket(car.getId(), false, car);
    }

    public Car fetch(Ticket ticket, ParkingLot parkingLot) {
        if (parkingLot.getCarSet().isEmpty()){
            return null;
        }
        if (ticket == null || !parkingLot.getCarSet().contains(ticket.getCar().getId()) || ticket.getUsed()){
            throw new IllegalArgumentException("Unrecognized parking ticket.");
        }
        this.capacity++;
        ticket.setUsed(true);
        parkingLot.getCarSet().remove(ticket.getCar().getId());
        return ticket.getCar();
    }
}
