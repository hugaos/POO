package aula05;

import java.util.Scanner;

class Calendario {
    private int year;
    private int firstDay;
    private int[][] events;
    private String[] monthDays = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };

    public Calendario(int year, int firstDay) {
        this.year = year;
        this.firstDay = firstDay;
        this.events = new int[12][31];
    }

    public int getYear(int year) {
        return year;
    }

    public int getFirstWeekdayOfYear(int firstDay) {
        return firstDay;
    }

    public int firstWeekdayOfMonth(int month) {
        int dayOfYear = 0;
        for (int i = 1; i < month; i++) {
            dayOfYear += DateYMD.monthDays(i, year);
        }
        return (firstDay + dayOfYear) % 7;
    }

    public void addEvent(DateYMD date) {
        int month = date.getmonth();
        int dayOfMonth = date.getday();
        int index = firstWeekdayOfMonth(month) + dayOfMonth - 1;
        this.events[month - 1][index] += 1;
    }

    public void removeEvent(DateYMD date) {
        int month = date.getmonth();
        int dayOfMonth = date.getday();
        int index = firstWeekdayOfMonth(month) + dayOfMonth - 1;
        this.events[month - 1][index] -= 1;
        if (this.events[month - 1][index] < 0) {
            this.events[month - 1][index] = 0;
        }
    }

    public void printMonth(int month) {
        System.out.printf("%12s %-10s\n", monthDays[month - 1], year);
        System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");

        for (int l = 0; l < 6; l++) {
            for (int c = 1; c < 8; c++) {
                if ((l == 0 && c < firstDay) || ((l * 7 + (c - firstDay + 1)) > DateYMD.monthDays(month, year))) {
                    System.out.printf("%3s", " ");
                } else {
                    System.out.printf("%3d", (l * 7 + (c - firstDay + 1)));
                }
            }
            System.out.println();
        }
    }

    public void printCalendario() {
        for (int i = 0; i <= 11; i++) {
            System.out.printf("%12s %-10s\n", monthDays[i], year);
            System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");

            for (int l = 0; l < 6; l++) {
                for (int c = 1; c < 8; c++) {
                    if ((l == 0 && c < firstDay) || ((l * 7 + (c - firstDay + 1)) > DateYMD.monthDays(i, year))) {
                        System.out.printf("%3s", " ");
                    } else {
                        System.out.printf("%3d", (l * 7 + (c - firstDay + 1)));
                    }
                }
                System.out.println();
            }
        }
    }
}

public class Exercicio5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opt;
        Calendario data = null;
        int year;
        int month;
        int firstDay;

        do {
            System.out.println();
            System.out.println("1 - create new calendar");
            System.out.println("2 - print calendar month");
            System.out.println("3 - print calendar");
            System.out.println("4 - add event");
            System.out.println("5 - remove event");
            System.out.println("0 - exit");
            System.out.println();
            opt = sc.nextInt();

            switch (opt) {
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    System.out.print("Insira um ano: ");
                    year = sc.nextInt();
                    System.out.print("Insira o primeiro dia da semana do mês: ");
                    System.out.printf(" %9s | %9s | %9s | %9s | %9s | %9s | %9s \n", "1=Domingo", "2=Segunda",
                            "3=Terça", "4=Quarta", "5=Quinta", "6=Sexta", "7=Sábado");
                    firstDay = sc.nextInt();
                    if (firstDay >= 1 && firstDay <= 7) {
                        data = new Calendario(year, firstDay);
                    } else {
                        System.out.println("Insira um dia da semana válido!");
                    }
                    break;
                case 2:
                    System.out.print("Insira um mês: ");
                    month = sc.nextInt();
                    if (DateYMD.validMonth(month)) {
                        data.printMonth(month);
                    } else {
                        System.out.println("Insira um mês válido!");
                    }
                    break;
                case 3:
                    data.printCalendario();
                    break;
                case 4:
                    if (data == null)
                        System.out.println("Insira um calendário primeiro!");
                    else {
                        System.out.println("Ano? ");
                        int ano = sc.nextInt();
                        System.out.println("Mês?");
                        int mes = sc.nextInt();
                        System.out.println("Dia? ");
                        int dia = sc.nextInt();
                        DateYMD date = new DateYMD(dia, mes, ano);
                        data.addEvent(date);
                        break;
                    }

                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        } while (opt != 0);
        sc.close();
    }
}
