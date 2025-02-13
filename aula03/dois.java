package aula03;

import java.util.Scanner;

public class dois {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Montante investido (múltiplo de 1000) ? ");
        double saldo = sc.nextDouble();

        while (saldo < 0 || saldo % 1000 != 0) {
            System.out.println("Montante investido (múltiplo de 1000) ? ");
            saldo = sc.nextInt();
        }
        System.out.println("Taxa de juros mensal? ");
        double taxa = sc.nextDouble();

        while (taxa < 0 || taxa > 5) {
            System.out.println("Taxa de juros mensal? ");
            taxa = sc.nextDouble();
        }
        for (int i = 1; i <= 12; i++) {
            saldo += saldo * (taxa / 100);
            System.out.printf("Mês %d , Montante- %.2f%", i, saldo);
        }
        sc.close();
    }
}
