package Story1;

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

    public Ticket park(Car car) {
        if(this.capacity == 0){
            return null;
        }
        this.capacity--;
        return new Ticket(car.getId(), false, car);
    }

    public Car fetch(Ticket ticket, ParkingLot parkingLot) {
        if (ticket == null || ticket.getUsed()) {
            return null;
        }
        if (!parkingLot.getCarSet().contains(ticket.getCar().getId())){
            throw new NullPointerException("Unrecognized parking ticket.");
        }
        this.capacity++;
        ticket.setUsed(true);
        parkingLot.getCarSet().remove(ticket.getCar().getId());
        return ticket.getCar();
    }
}
