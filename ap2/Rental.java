package ap2;

import java.time.LocalDate;

public class Rental {
    private Client client;
    private StorageUnit unit;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(Client client, StorageUnit unit, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.unit = unit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return client.toString() + " - [" + startDate + " : " + endDate + "] " + unit.getType() + " located in "
                + unit.getLocal() + ", with dimensions " + unit.getDim()[0] + "x" + unit.getDim()[1] + unit.getDim()[2]
                + ", " + unit.getPreco() + "/day";
    }
}
