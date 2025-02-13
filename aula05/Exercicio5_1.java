package aula05;

import utils.UserInput;
import java.util.Scanner;

class DateYMD {

    private int day, month, year;

    public DateYMD(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getday() {
        return day;
    }

    public int getmonth() {
        return month;
    }

    public int getyear() {
        return year;
    }

    public void set(int day, int month, int year) throws Exception {
        if (UserInput.valid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new Exception("Insira uma data válida");
        }
    }

    public String toString() {
        return String.format("%04d" + "-" + "%02d" + "-" + "%02d", year, month, day);
    }

    public void increment() {
        day += 1;
        if (!UserInput.valid(day, month, year)) {
            month += 1;
            day = 1;
            if (!validMonth(month)) {
                month = 1;
                year += 1;
            }
        }
    }

    public void decrement() {
        day -= 1;
        if (!UserInput.valid(day, month, year)) {
            month -= 1;
            day = monthDays(month, year);
            if (!validMonth(month)) {
                month = 12;
                year -= 1;
            }
        }
    }

    public static boolean validMonth(int month) {
        if (month <= 12 && month >= 1) {
            return true;
        } else
            return false;
    }

    public static int monthDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            case 2:
                if (UserInput.leapYear(year)) {
                    return 29;
                } else
                    return 28;

            default:
                return 30;
        }
    }

}

public class Exercicio5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        DateYMD data = null;
        do {
            System.out.println();
            System.out.println("1- create new date");
            System.out.println("2- show current date");
            System.out.println("3- increment date");
            System.out.println("4- decrement date");
            System.out.println("0- exit");

            System.out.println();
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Day? ");
                    int day = sc.nextInt();
                    System.out.println("Month? ");
                    int month = sc.nextInt();
                    System.out.println("Year? ");
                    int year = sc.nextInt();
                    try {
                        data = new DateYMD(day, month, year);
                        data.set(day, month, year);
                    } catch (Exception e) {
                        data = null;
                        System.out.println("Data inválida!");
                    }
                    break;
                case 2:
                    if (data == null)
                        System.out.println("Insira uma data primeiro.");
                    else
                        System.out.println(data);
                    break;
                case 3:
                    data.increment();
                    break;
                case 4:
                    data.decrement();
                    break;
                case 0:
                    System.out.println("Terminando...");
                    break;
                default:
                    System.out.println("Escolhe uma opção valida");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}
