package aula02;

import java.util.Scanner;

public class um {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Km?");
        double kil = sc.nextDouble();
        double mi;
        mi = kil / 1.609;
        System.out.printf(kil + "km são %,.3f milhas", mi);
        sc.close();
    }
}
