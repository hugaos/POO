package ap2;

public abstract class StorageUnit {
    private String local;
    private int[] dim;
    private int preco;

    public StorageUnit(String local, int[] dim, int preco) {
        this.local = local;
        this.dim = dim;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public int[] getDim() {
        return dim;
    }

    public int getPreco() {
        return preco;
    };

    public abstract String getType();
}
