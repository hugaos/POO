import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContactManager implements ContactManagerInterface {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void load(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+", 5);
                String name = parts[0] + " " + parts[1];
                int number = Integer.parseInt(parts[2]);
                String email = parts[3];
                LocalDate birthdate = LocalDate.parse(parts[4]);
                Contact person = new Contact(number, name, number, email, birthdate);
                contacts.add(person);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro não encontrado.");
        }
    };

    public void save(String filePath);

    public boolean validateEmail(String email) {
        if (email.endsWith("@ua.pt"))
            return true;
        else
            return false;
    };

    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 9) {
            return true;
        } else
            return false;
    };

    public boolean addContact(Contact person) {
        String email = person.getemail();
        String number = person.getNumber();
        for (Contact contact : contacts) {
            if (contact.equals(person)) {
                return false;
            } else
                return true;
        }
        if (validateEmail(email) && validatePhoneNumber(number)) {
            contacts.add(person);
            return true;
        } else
            return false;
    };

    public boolean removeContact(Contact person) {
        return contacts.remove(person);
    };

    public Contact searchContactByname(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    };

    public Contact searchContactByEmail(String email) {
        for (Contact contact : contacts) {
            if (contact.getemail().equalsIgnoreCase(email)) {
                return contact;
            }
        }
        return null;
    };

    public Contact searchContactByPhoneNumber(int phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getNumber().equals(String.valueOf(phoneNumber))) {
                return contact;
            }
        }
        return null;
    };

    public void listAllContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Contact " + (i + 1) + ": " + contacts.get(i));
        }
    };

    public List<Contact> getContacts() {
        return contacts;
    }

    public void listContactsByName();

    public void listContactsByPhoneNumber();

    public void listContactsByBirthDate();

    public void listContactsByEmail();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        String filePath = "C:/Users/sousa/Desktop/POO/POO/src/aula13/contactos.txt";
        contactManager.load(filePath);
        int opt;
        do {
            System.out.println();
            System.out.println("1 - adicionar contacto");
            System.out.println("2 - modificar contacto");
            System.out.println("3 - apagar contacto");
            System.out.println("4 - procurar contacto por nome");
            System.out.println("5 - procurar contacto por telemóvel");
            System.out.println("6- procurar por email");
            System.out.println("7- Listar contactos");
            System.out.println("0 - exit");
            System.out.println();
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Nome- ");
                    String name = sc.next();
                    System.out.println("Número- ");
                    int number = sc.nextInt();
                    System.out.println("E-mail- ");
                    String email = sc.next();
                    System.out.println("Data de nascimento(yyyy-mm-dd)- ");
                    String birthDate = sc.next();
                    LocalDate date = LocalDate.parse(birthDate);
                    if (contactManager.addContact(new Contact(name, number, email, date))) {
                        System.out.println("Sucesso!");
                    } else
                        System.out.println(
                                "Erro, ou o contacto já existe ou os valores do email e número são invalidos.");
                    break;
                case 3:
                    contactManager.listAllContacts();
                    System.out.println("Que contacto deseja apagar? ");
                    int n = sc.nextInt();
                    if (n >= 1 && n <= contactManager.getContacts().size()) {
                        contactManager.getContacts().remove(n - 1);
                        System.out.println("Contacto removido com sucesso.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Nome?");
                    String nome = sc.nextLine();
                    contactManager.searchContactByname(nome);

                case 5:
                    System.out.println("Email?");
                    String mail = sc.nextLine();
                    contactManager.searchContactByEmail(mail);

                case 6:
                    System.out.println("numero?");
                    int num = sc.nextInt();
                    contactManager.searchContactByPhoneNumber(num);
                case 7:
                    contactManager.listAllContacts();

            }
        } while (opt != 0);
        sc.close();
    }
}
