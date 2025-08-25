package Story1;

public class Ticket {

    private String id;
    private Boolean isUsed;
    private Car car;

    public Ticket(String id, boolean isUsed, Car car) {
        this.id = id;
        this.isUsed = isUsed;
        this.car = car;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", isUsed=" + isUsed +
                ", car=" + car +
                '}';
    }
}
