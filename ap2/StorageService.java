package ap2;

import java.util.Collection;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class StorageService implements StorageServiceInterface {
    private String nome;
    private String addr;
    private List<Rental> rentals;
    private Map<Client, Rental> clientMap;
    private List<Client> clients;
    private List<StorageUnit> storages;
    private List<String> rent;

    public StorageService(String nome, String addr) {
        this.nome = nome;
        this.addr = addr;
    }

    public boolean registerClient(int taxId, String name, String type) {
        Client client = new Client(taxId, name, type);
        for (Client c : clients) {
            if (c.equals(client)) {
                return false;
            } else {
                clients.add(client);
                return true;
            }
        }
        clients.add(client);
        return true;
    };

    public Client getClient(int taxId) {
        for (Client c : clients) {
            if (taxId == c.getnif()) {
                return c;
            }
        }
        return null;
    };

    public void addStorageUnit(StorageUnit storageUnit) {
        storages.add(storageUnit);
    };

    public void addStorageUnits(Collection<StorageUnit> storageUnits) {
        for (StorageUnit s : storageUnits) {
            storages.add(s);
        }
    };

    public boolean checkAvailable(StorageUnit storageUnit, LocalDate startDate, LocalDate endDate) {
        return true;
    };

    public List<StorageUnit> findAvailableUnits(String unitType, LocalDate fromDate, int duration,
            int[] minDimensions) {

    };

    public boolean rentStorageUnit(Client client, StorageUnit unit, LocalDate startDate, int duration) {
        if (client.getType() == "PERSONAL" && unit.getType() == "WareHouse") {
            return false;
        }
        LocalDate endDate = startDate;
        Rental rental = new Rental(client, unit, startDate, endDate);
        rentals.add(rental);
        clientMap.put(client, rental);
        return true;
    };

    public double calculateTotalCost(StorageUnit unit, int duration) {

    };

    public List<String> listRentals() {
        for (Rental r : rentals) {
            rent.add(r.toString());
        }
        return rent;
    };

}
