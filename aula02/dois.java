package aula02;

import java.util.Scanner;

public class dois {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Temperatura em Celsius?");
        double cel = sc.nextDouble();
        double fah = 1.8 * cel + 32;
        System.out.print(cel + "ºC em fahrenheit são:" + fah);
        sc.close();
    }
}
