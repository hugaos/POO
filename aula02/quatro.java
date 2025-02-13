package aula02;

import java.util.Scanner;

public class quatro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Montante investido?");
        double inv = sc.nextDouble();
        System.out.print("Taxa de juros?");
        double taxa = (sc.nextDouble()) / 100;
        int n = 0;
        while (n <= 2) {
            inv += inv * taxa;
            n += 1;
        }
        System.out.println("Ao fim de 3 meses, o montante será " + inv + " EUR");
        sc.close();
    }

}
