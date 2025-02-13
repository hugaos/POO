package aula03;

import java.util.Scanner;

public class cinco {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int mes = valNumb("Mês: ", 1, 12);
        int ano = valNumb("Ano:", 0, 9999);
        int diaInicial = valNumb("Primeiro dia do mês (1 = Su, 2 = Mo, 3 = Tu, 4 = We, 5 = Th, 6 = Fr, 7 = Sa): ", 1,
                7);

        printCalendar(mes, ano, diaInicial);

    }

    public static int valNumb(String s, int min, int max) {
        int num;

        do {
            System.out.print(s);
            num = sc.nextInt();
        } while (num > max || num < min);

        return num;
    }

    public static int getDias(int mes, int ano) {
        int dias;
        int[] lista = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (mes == 2) {
            if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
                dias = 29;
            } else {
                dias = 28;
            }
        } else {
            dias = lista[mes - 1];
        }

        return dias;
    }

    public static String getName(int mes) {

        String[] lista = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };

        String name = lista[mes - 1];

        return name;
    }

    public static void printCalendar(int mes, int ano, int dia1) {

        int dias = getDias(mes, ano);
        String nomeMes = getName(mes);

        System.out.printf("%12s %-10s\n", nomeMes, ano);

        System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");

        for (int l = 0; l < 6; l++) {
            for (int c = 1; c < 8; c++) {
                if ((l == 0 && c < dia1) || ((l * 7 + (c - dia1 + 1)) > dias)) {
                    System.out.printf("%3s", " ");
                } else {
                    System.out.printf("%3d", (l * 7 + (c - dia1 + 1)));
                }
            }
            System.out.println();
        }
    }
}
