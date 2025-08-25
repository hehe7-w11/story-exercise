package Story1;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
        this.capacity--;
        return new Ticket(car.getId(), false, car);
    }

    public Car fetch(Ticket ticket, Set<String> carSet) {
        if (!carSet.contains(ticket.getCar().getId())) {
            return null;
        }
        this.capacity++;
        ticket.setUsed(true);
        return ticket.getCar();
    }
}
