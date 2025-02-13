package aula02;

import java.util.Scanner;

public class cinco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        double v1, d1, v2, d2;
        System.out.print("Velocidade 1: ");
        v1 = sc.nextDouble();
        while (n < 1) {
            if (v1 > 0) {
                break;
            } else {
                System.out.print("Velocidade 1: ");
                v1 = sc.nextDouble();
            }
        }
        System.out.print("Distância 1: ");
        d1 = sc.nextDouble();
        while (n < 1) {
            if (d1 > 0) {
                break;
            } else {
                System.out.print("Distância 1: ");
                d1 = sc.nextDouble();
            }
        }
        System.out.print("Velocidade 2: ");
        v2 = sc.nextDouble();
        while (n < 1) {
            if (v2 > 0) {
                break;
            } else {
                System.out.print("Velocidade 2: ");
                v2 = sc.nextDouble();
            }
        }
        System.out.print("Distância 2: ");
        d2 = sc.nextDouble();
        while (n < 1) {
            if (d2 > 0) {
                break;
            } else {
                System.out.print("Distância 2: ");
                d2 = sc.nextDouble();
            }
        }
        double v = (v1 * v2 * (d1 + d2)) / (d1 * v2 + d2 * v1);
        System.out.print("Velocidade média final: " + v);

        sc.close();
    }
}
