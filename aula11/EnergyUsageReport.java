package aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EnergyUsageReport {
    private Map<Integer, Customer> customers;

    public EnergyUsageReport() {
        customers = new HashMap<>();
    }

    public void load(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0].trim());
                List<Double> readings = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    readings.add(Double.parseDouble(parts[i].trim()));
                }
                customers.put(id, new Customer(id, readings));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro não encontrado.");
        }
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public void removeCustomer(int id) {
        customers.remove(id);
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    public double calculateTotalUsage(int id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            return 0;
        }
        double total = 0;
        for (double reading : customer.getMeterReadings()) {
            total += reading;
        }
        return total;
    }

    public void generateReport(String filename) {
        System.out.println("Relatório de Consumo de Energia");
        for (Customer customer : customers.values()) {
            double total = calculateTotalUsage(customer.getCustomerId());
            System.out.println("Cliente " + customer.getCustomerId() + ": " + total);
        }
    }
}
