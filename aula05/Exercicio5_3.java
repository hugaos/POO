package aula05;

class RealEstate {
    private Property[] properties;
    private int propertyCount;

    public RealEstate() {
        this.properties = new Property[5];
        this.propertyCount = 0;
    }

    public void newProperty(String locality, int rooms, double price) {
        Property property = new Property(this.propertyCount + 1000, locality, rooms, price);
        this.properties[this.propertyCount] = property;
        this.propertyCount++;
    }

    public void sell(int id) {
        Property property = findProperty(id);
        if (property != null) {
            property.setAvailable(false);
            System.out.println("Imóvel " + id + " vendido.");
        }
    }

    public void setAuction(int id, DateYMD start, int duration) {
        Property property = findProperty(id);
        if (property != null) {
            property.setAuction(start, duration);
        }
    }

    private Property findProperty(int id) {
        for (int i = 0; i < this.propertyCount; i++) {
            if (this.properties[i].getId() == id) {
                return this.properties[i];
            }
        }
        System.out.println("Imóvel " + id + " não existe.");
        return null;
    }

    public String toString() {
        String result = "";
        result += "Propriedades:\n";
        for (int i = 0; i < this.propertyCount; i++) {
            result += this.properties[i].toString() + "\n";
        }
        return result;
    }
}

class Property {
    private int id;
    private int rooms;
    private String locality;
    private double price;
    private boolean available;
    private DateYMD auctionStart;
    private int auctionDuration;
    private int day, month, year;

    public Property(int id, String locality, int rooms, double price) {
        this.id = id;
        this.locality = locality;
        this.rooms = rooms;
        this.price = price;
        this.available = true;
        this.auctionStart = null;
        this.auctionDuration = 0;
    }

    public int getId() {
        return this.id;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        if (!available) {
            this.auctionStart = null;
            this.auctionDuration = 0;
            System.out.println("Imóvel " + this.id + " não está disponível.");
        }
    }

    public void setAuction(DateYMD start, int duration) {
        if (this.available) {
            this.auctionStart = start;
            this.auctionDuration = duration;
            this.day = start.getday();
            this.month = start.getmonth();
            this.year = start.getyear();
        }
    }

    public String toString() {
        String result = "";
        result += "Imóvel: " + this.id + "; quartos: " + this.rooms + "; localidade: " + this.locality +
                "; preço: " + this.price + "; disponível: " + (this.available ? "sim" : "não");
        if (this.auctionStart != null) {
            DateYMD data = new DateYMD(this.day, this.month, this.year);
            for (int i = 0; i < this.auctionDuration; i++) {
                data.increment();
            }
            result += "; leilão " + this.auctionStart.toString() + " : "
                    + data.toString();
        }
        return result;
    }
}

public class Exercicio5_3 {
    public static void main(String[] args) {
        RealEstate imobiliaria = new RealEstate();
        imobiliaria.newProperty("Glória", 2, 30000);
        imobiliaria.newProperty("Vera Cruz", 1, 25000);
        imobiliaria.newProperty("Santa Joana", 3, 32000);
        imobiliaria.newProperty("Aradas", 2, 24000);
        imobiliaria.newProperty("São Bernardo", 2, 20000);

        imobiliaria.sell(1001);
        imobiliaria.setAuction(1002, new DateYMD(21, 3, 2023), 4);
        imobiliaria.setAuction(1003, new DateYMD(1, 4, 2023), 3);
        imobiliaria.setAuction(1001, new DateYMD(1, 4, 2023), 4);
        imobiliaria.setAuction(1010, new DateYMD(1, 4, 2023), 4);

        System.out.println(imobiliaria);

    }
}
