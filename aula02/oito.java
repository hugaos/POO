package aula02;

import java.util.Scanner;
import java.lang.Math;

public class oito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double cA, cB;
        System.out.print("Cateto A: ");
        cA = sc.nextDouble();
        while (true) {
            if (cA > 0) {
                break;
            } else {
                System.out.print("Cateto A: ");
                cA = sc.nextDouble();
            }
        }
        ;
        System.out.print("Cateto B: ");
        cB = sc.nextDouble();
        while (true) {
            if (cB > 0) {
                break;
            } else {
                System.out.print("Cateto B: ");
                cB = sc.nextDouble();
            }
        }
        double h = Math.sqrt(Math.pow(cA, 2) + Math.pow(cB, 2));
        double ang = Math.toDegrees(Math.acos(cA / h));
        System.out.println(
                "O valor da hipotenusa é " + h + " e o ângulo entre A e a hipotenusa é ded " + ang + " graus.");

        sc.close();
    }
}
