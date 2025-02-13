package aula06;

import utils.UserInput;

public class DateYMD implements Comparable<DateYMD> {

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

    @Override
    public int compareTo(DateYMD o) {
        // TODO Auto-generated method stub
        if (this.year != o.year) {
            return Integer.compare(this.year, o.year);
        } else if (this.month != o.month) {
            return Integer.compare(this.month, o.month);
        } else {
            return Integer.compare(this.day, o.day);
        }
    }

}
