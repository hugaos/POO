package utils;

public class UserInput {
    public static boolean Primo(int num) {
        if (num <= 1)
            return false;

        for (int a = 2; a < num; a++) {
            if (num % a == 0)
                return false;
        }
        return true;
    }

    public static boolean valTriang(double l1, double l2, double l3) {
        double i1 = Math.abs(l2 - l3);
        double i2 = Math.abs(l1 - l3);
        double i3 = Math.abs(l1 - l2);

        if (l1 > 0 && l2 > 0 && l3 > 0) {
            if (i1 < l1 && l1 < l2 + l3 && i2 < l2 && l2 < l1 + l3 && i3 < l3 && l3 < l2 + l1) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    public static boolean validMonth(int month) {
        int m = month;

        if (m <= 12 && m >= 1) {
            return true;
        } else
            return false;
    }

    public static boolean leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else
            return false;
    }

    public static boolean valid(int day, int month, int year) {
        if (year > 0 && validMonth(month) && day > 0 && day <= 31) {
            if (leapYear(year)) {
                if (month == 2 && day <= 29)
                    return true;
                else
                    return false;
            } else {
                if (month == 2 && day > 28) {
                    return false;
                } else
                    return true;
            }
        } else
            return false;
    }
}
