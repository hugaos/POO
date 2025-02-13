package aula02;

import java.util.Scanner;
import java.lang.Math;

public class sete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1, y1, x2, y2;
        System.out.print("x1: ");
        x1 = sc.nextDouble();
        System.out.print("y1: ");
        y1 = sc.nextDouble();
        System.out.print("x2: ");
        x2 = sc.nextDouble();
        System.out.print("y2: ");
        y2 = sc.nextDouble();
        double dis = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        System.out.print("Distância: " + dis);

        sc.close();
    }
}