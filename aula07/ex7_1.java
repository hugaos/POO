package aula07;

import java.util.Scanner;
import utils.UserInput;

public class ex7_1 {
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
