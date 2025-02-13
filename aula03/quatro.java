package aula03;

import java.util.Scanner;

public class quatro {

    public static double NotaFinal(double notaT, double notaP) {
        if (notaT < 7.0 || notaP < 7.0) {
            return 66;
        } else {
            return (int) Math.round(0.4 * notaT + 0.6 * notaP);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos alunos tem a turma?");
        int alunos = sc.nextInt();
        System.out.printf("%6s %6s %6s\n", "NotaT", "NotaP", "Pauta");

        double[][] pauta = new double[alunos][2];

        for (int i = 1; i <= alunos; i++) {
            pauta[i][0] = Math.round(Math.random() * 200) / 10.0;
            pauta[i][1] = Math.round(Math.random() * 200) / 10.0;
            double notat = pauta[i][0];
            double notap = pauta[i][1];
            double notaf = NotaFinal(notat, notap);
            System.out.printf("%6.1f %6.1f %6.0f\n", notat, notap, notaf);
        }
        sc.close();
    }

}
