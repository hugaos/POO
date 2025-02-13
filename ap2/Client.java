package ap2;

public class Client {
    private int nif;
    private String nome;
    private String tipo;

    public Client(int nif, String nome, String tipo) {
        this.nif = nif;
        this.nome = nome;
        this.tipo = tipo;

    }

    public String getName() {
        return this.nome;
    }

    public int getnif() {
        return this.nif;
    }

    public String getType() {
        return this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return Integer.compare(this.nif, client.nif) == 0;
    }

    @Override
    public String toString() {
        return nome + "[ " + tipo + ": " + nif + "]";
    }
}
