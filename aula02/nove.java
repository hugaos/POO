package aula02;

import java.util.Scanner;

public class nove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Valor de N?");
        int n = sc.nextInt();
        String nums = "";

        while (n >= 0) {
            if (n == 0) {
                nums += n + ".";
            } else if (n % 10 == 0) {
                nums += n + System.lineSeparator();
            } else {
                nums += n + ", ";
            }
            n -= 1;
        }
        System.out.println(nums);
        sc.close();
    }
}
