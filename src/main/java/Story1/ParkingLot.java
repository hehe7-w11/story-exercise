package Story1;
import java.util.UUID;

public class ParkingLot {
    public int capacity = 10;

    public Ticket park(Car car) {
        this.capacity --;
        return new Ticket(car.getId(),false, car);
    }

    public Car fetch(Ticket ticket) {
        this.capacity ++;
        ticket.setUsed(true);
        return ticket.getCar();
    }
}
