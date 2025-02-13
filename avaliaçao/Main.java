import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fighter[] fighters = new Fighter[10];

        int choice = 0;
        do {
            System.out.println("Game menu:");
            System.out.println("1. Generate fighters");
            System.out.println("2. Show all fighters");
            System.out.println("3. Start fight between selected fighters");
            System.out.println("4. Start fight between random fighters");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        int tipo = (int) Math.round(Math.random() * 10);
                        if (tipo <= 5) {
                            int range = (int) Math.round(Math.random() * 10);
                            Boxer boxer = new Boxer("Lutador" + (i + 1), 100, 0, 0, range);
                            fighters[i] = boxer;
                        } else {
                            int speed = (int) Math.round(Math.random() * 10);
                            Wrestler wrestler = new Wrestler("Lutador" + (i + 1), 100, 0, 0, speed);
                            fighters[i] = wrestler;
                        }

                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        System.out.println(fighters[i]);
                    }
                    break;
                case 3:
                    System.out.println("Número do primeiro Lutador? ");
                    int num1 = scanner.nextInt();
                    System.out.println("Número do segundo lutador? ");
                    int num2 = scanner.nextInt();
                    while (fighters[num1 - 1].isAlive() || fighters[num2 - 2].isAlive()) {
                        fighters[num1 - 1].attack(fighters[num2 - 1]);
                        fighters[num2 - 1].attack(fighters[num1 - 1]);
                    }
                    break;
                case 4:
                    // simulate a fight between random fighters
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }
}
