package ap2;

public class LockerStorage extends StorageUnit {
    private String local;
    private int[] dim;
    private int preco;

    public LockerStorage(String local, int[] dim, int preco) {
        super(local, dim, preco);
    }

    public String getType() {
        return "LockerStorage";
    }
}
