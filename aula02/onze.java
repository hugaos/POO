package aula02;

import java.util.Scanner;

public class onze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Intervalo? (x-y)");
        System.out.println("Valor?");
        int val = sc.nextInt();
        val = val / 3;

        sc.close();
    }
}
