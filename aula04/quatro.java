package aula04;

import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        // TODO: acumular distância percorrida
        kms = kms + distance;
    }

}

public class quatro {
    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        // TODO: pede dados dos carros ao utilizador e acrescenta ao vetor
        // registo de carros termina quando o utilizador inserir uma linha vazia
        // devolve número de carros registados
        System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
        String input = sc.nextLine();
        String[] caract = input.split(" ");
        int numCars = 0;
        Car[] carros = new Car[10];
        while (input != "" && numCars < carros.length) {
            if (caract.length < 4)
                System.out.println("Dados não correspondem ao formato pretendido.");
            else {
                int year = Integer.parseInt(caract[caract.length - 2]);
                int kms = Integer.parseInt(caract[caract.length - 1]);
                if (caract[caract.length - 2].length() == 4 && year > 0) {
                    if (kms > 0) {
                        String make = caract[0];
                        String model = caract[1];
                        for (int i = 2; i < caract.length - 2; i++) {
                            model += " " + caract[i];
                        }
                        numCars += 1;
                        cars[numCars - 1] = new Car(make, model, year, kms);
                    } else {
                        System.out.println("Dados não correspondem ao formato pretendido.");
                    }
                } else {
                    System.out.println("Dados não correspondem ao formato pretendido.");
                }
            }
            System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
            input = sc.nextLine();
            caract = input.split(" ");

        }
        return numCars;
    }

    static void registerTrips(Car[] cars, int numCars) {
        // TODO: pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia
        System.out.print("Registe uma viagem no formato \"carro:distância\": ");
        String input = sc.nextLine();
        while (input != "") {
            String[] parts = input.split(":");
            int index = Integer.parseInt(parts[0]);
            int distance = Integer.parseInt(parts[1]);
            if (index < 0 || index >= numCars || distance < 0) {
                System.out.println("Dados mal formatados.");
            } else {
                cars[index].drive(distance);
            }
            System.out.print("Registe uma viagem no formato \"carro:distância\": ");
            input = sc.nextLine();

        }
    }

    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        // TODO: lista todos os carros registados
        // Exemplo de resultado
        // Carros registados:
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println(cars[i].make + " " + cars[i].model + ", " +
                        cars[i].year + ", kms: " + cars[i].kms);
            }
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars > 0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}
