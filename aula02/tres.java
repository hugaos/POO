package aula02;

import java.util.Scanner;

public class tres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Temperatura Inicial(ºC)?");
        double tempi = sc.nextDouble();
        System.out.print("Temperatura Final(ºC)?");
        double tempf = sc.nextDouble();
        System.out.print("Quantidade de água (kg)?");
        double quant = sc.nextDouble();
        double Q = quant * (tempf - tempi) * 4184;
        System.out.println("A temperatura necessária seria de " + Q + "J");
        sc.close();
    }

}
