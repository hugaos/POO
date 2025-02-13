package aula07;

public class circulo extends Forma {
    private double raio;

    public circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio > 0)
            this.raio = raio;
    }

    public double area() {
        return (Math.PI * (Math.pow(this.raio, 2)));
    }

    public double perimetro() {
        return (2 * Math.PI * this.raio);
    }

    @Override
    public String toString() {
        return "Circulo [raio=" + raio + ", Area=" + area() + ", Perimetro=" + perimetro() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof circulo)) {
            return false;
        }
        circulo Circulo = (circulo) o;
        return Double.compare(this.raio, Circulo.raio) == 0;
    }
}
