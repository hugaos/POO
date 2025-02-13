package aula03;

import utils.UserInput;
import java.util.Scanner;

public class um {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número? - ");
        int num = sc.nextInt();
        int soma = 0;
        while (num < 0) {
            System.out.print("Número? - ");
            num = sc.nextInt();
        }
        for (int i = 2; i <= num; i++)
            if (UserInput.Primo(i)) {
                soma += i;
            }
        System.out.println(soma);
        sc.close();
    }

}
