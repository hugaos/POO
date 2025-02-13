package ap2;

public class WarehouseStorage extends StorageUnit {
    private String local;
    private int[] dim;
    private int preco;

    public WarehouseStorage(String local, int[] dim, int preco) {
        super(local, dim, preco);
    }

    public String getType() {
        return "WareHouse unit";

    }

}
