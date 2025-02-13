package aula02;

import java.util.Scanner;

public class seis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s, m, h, seg;
        System.out.print("Segundos: ");
        seg = sc.nextInt();
        h = seg / 3600;
        m = seg / 60 - h * 60;
        s = seg % 3600 - m * 60;
        System.out.printf("%02d:%02d:%02d", h, m, s);

        sc.close();
    }
}
