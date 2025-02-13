package aula04;

import java.util.Scanner;
import utils.UserInput;

class circulo {
    private double raio;

    public circulo(double raio) {
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

class triangulo {
    private double l1, l2, l3;

    public triangulo(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public double getL1() {
        return l1;
    }

    public double getL2() {
        return l2;
    }

    public double getL3() {
        return l3;
    }

    public void setL1(double l1) {
        this.l1 = l1;
    }

    public void setL2(double l2) {
        this.l2 = l2;
    }

    public void setL3(double l3) {
        this.l3 = l3;
    }

    public String toString() {
        return "Triangulo [lado1=" + l1 + ", lado2=" + l2 + ", lado3=" + l3 + ", Perimetro=" + Perimetro() + ", Area="
                + Area() + "]";
    }

    public double Perimetro() {
        return (l1 + l2 + l3);
    }

    public double Area() {
        double p = this.Perimetro() / 2;
        return Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof triangulo)) {
            return false;
        }
        triangulo Triangulo = (triangulo) o;
        return this.l1 == Triangulo.l1 && this.l2 == Triangulo.l2 && this.l3 == Triangulo.l3;
    }
}

class retangulo {
    private double c;
    private double a;

    public retangulo(double c, double a) {
        this.c = c;
        this.a = a;
    }

    public double getC() {
        return c;
    }

    public double getA() {
        return a;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public String toString() {
        return "Retangulo [comprimento=" + c + ", altura=" + a + ", Area=" + Area() + ", Perimetro=" + Perimetro()
                + "]";
    }

    public double Area() {
        return (a * c);
    }

    public double Perimetro() {
        return (2 * a + 2 * c);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof retangulo)) {
            return false;
        }
        retangulo Retangulo = (retangulo) o;
        return this.c == Retangulo.c && this.a == Retangulo.a;
    }
}

public class um {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        Object[] figuras = new Object[10];
        do {
            System.out.println();
            System.out.println("1- Criar Circulo");
            System.out.println("2- Criar Triângulo");
            System.out.println("3- Criar Retângulo");
            System.out.println("4- Listar Figuras");
            System.out.println("5- Comparar Duas Figuras");

            System.out.println();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    double raio;
                    do {
                        System.out.println("Insira a medida do raio-");
                        raio = sc.nextDouble();
                        circulo circulo = new circulo(raio);
                        for (int i = 0; i < figuras.length; i++) {
                            if (figuras[i] == null) {
                                figuras[i] = circulo;
                                break;
                            }
                        }
                    } while (raio <= 0);
                    break;

                case 2:
                    double l1, l2, l3;
                    do {
                        System.out.println("Insira a medida do lado 1");
                        l1 = sc.nextDouble();
                        System.out.println("Insira a medida do lado 2");
                        l2 = sc.nextDouble();
                        System.out.println("Insira a medida do lado 3");
                        l3 = sc.nextDouble();
                        triangulo triangulo = new triangulo(l1, l2, l3);
                        if (UserInput.valTriang(l1, l2, l3))
                            for (int i = 0; i < figuras.length; i++) {
                                if (figuras[i] == null) {
                                    figuras[i] = triangulo;
                                    break;

                                }
                            }
                        else
                            System.out.println(
                                    "Os valores dos lados têm de ser positivos e satisfazer a desigualdade triangular.");

                    } while (!UserInput.valTriang(l1, l2, l3));
                    break;
                case 3:
                    double c, a;
                    do {
                        System.out.println("Insira o comprimento do retângulo- ");
                        c = sc.nextDouble();
                        System.out.println("Insira a altura do retângulo- ");
                        a = sc.nextDouble();
                        retangulo retangulo = new retangulo(c, a);
                        for (int i = 0; i < figuras.length; i++) {
                            if (figuras[i] == null) {
                                figuras[i] = retangulo;
                                break;
                            }
                        }
                    } while (c <= 0 || a <= 0);

                case 4:
                    for (int i = 0; i < figuras.length; i++) {
                        if (figuras[i] != null)
                            System.out.println(i + "- " + figuras[i]);
                    }
                    break;

                case 5:
                    System.out.println("Digite o índice da primeira figura:");
                    int indice1 = sc.nextInt();
                    System.out.println("Digite o índice da segunda figura:");
                    int indice2 = sc.nextInt();

                    if (figuras[indice1] != null && figuras[indice2] != null
                            && figuras[indice1].getClass() == figuras[indice2].getClass()) {
                        boolean saoIguais = figuras[indice1].equals(figuras[indice2]);
                        if (saoIguais) {
                            System.out.println("As duas figuras são iguais.");
                        } else {
                            System.out.println("As duas figuras são diferentes.");
                        }
                    } else {
                        System.out.println("Índices inválidos ou figuras de tipos diferentes.");
                    }

            }
        } while (op != 0);
        sc.close();
    }
}
