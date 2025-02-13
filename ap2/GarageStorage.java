package ap2;

public class GarageStorage extends StorageUnit {
    private String local;
    private int[] dim;
    private int preco;

    public GarageStorage(String local, int[] dim, int preco) {
        super(local, dim, preco);
    }

    public String getType() {
        return "GarageStorage";
    }
}
