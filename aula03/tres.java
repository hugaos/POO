package aula03;

import java.util.Scanner;

public class tres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rng;
        int numero;
        int tentativas;
        String resposta;
        do {
            tentativas = 0;
            rng = (int) Math.round(Math.random() * 100);
            do {
                System.out.print("Número entre 1 e 100: ");
                numero = sc.nextInt();
                tentativas++;

                if (numero > rng) {
                    System.out.println("Demasiado alto");
                } else if (numero < rng) {
                    System.out.println("Demasiado baixo");
                }
            } while (numero != rng);
            System.out.println("Acertaste!");
            System.out.println("Usaste " + tentativas + " tentativas.");
            System.out.println("Pretende continuar? Prima (S)im");
            resposta = sc.next();
        } while (resposta.toUpperCase().equals("S") || resposta.toUpperCase().equals("SIM"));

        System.out.println("Jogo terminado");
        sc.close();
    }
}
