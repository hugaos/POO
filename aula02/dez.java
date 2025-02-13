package aula02;

import java.lang.String;
import java.util.Scanner;

public class dez {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Números: ");
        String numeros = sc.nextLine();
        int[] nums = new int[numeros.length()];
        for (int i = 0; i < numeros.length(); i++) {
            nums[i] = Integer.parseInt(numeros.charAt(i) + "");
        }
        int quantidade = 1;
        double maximo = nums[0];
        double minimo = nums[0];
        double soma = nums[0];
        for (int i = 1; i < nums.length; i++) {
            double numero = nums[i];
            if (numero > maximo) {
                maximo = numero;
            }
            if (numero < minimo) {
                minimo = numero;
            }
            soma += numero;
            quantidade++;
        }
        System.out.println("Valor máximo: " + maximo);
        System.out.println("Valor mínimo: " + minimo);
        System.out.println("Média: " + (soma / quantidade));
        System.out.println("Total de Números Lidos: " + quantidade);
        sc.close();
    }

}
