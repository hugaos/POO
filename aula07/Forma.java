package aula07;

public abstract class Forma {
    private String cor;

    public abstract double area();
    public abstract double perimetro();

    public Forma(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String equals(Forma forma) {
        if (cor.equals(forma.getCor())) {
            return "Figuras iguais";
        } else {
            return "Figuras diferentes";
        }
    }

    @Override
    public String toString() {
        return "Cor: " + getCor();
    }
}
