package aula04;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class CashRegister {

    // TODO: completar implementação da classe
    private Product[] products;
    private int count;

    public CashRegister() {
        products = new Product[50];
        count = 0;
    }

    public void addProduct(Product p) {
        products[count] = p;
        count++;
    }

    public double getTotalValue() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getTotalValue();
        }
        return total;
    }

    public String toString() {
        String tabela = "";
        tabela += String.format("%-15s%-10s%-10s%s%n", "Product", "Price", "Quantity", "Total");
        for (int i = 0; i < count; i++) {
            tabela += String.format("%-15s%-10.2f%-10d%.2f%n", products[i].getName(), products[i].getPrice(),
                    products[i].getQuantity(), products[i].getTotalValue());
        }
        tabela += String.format("%-36s%.2f", "Total value:", getTotalValue());
        return tabela;
    }

}

public class dois {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));

        // TODO: Listar o conteúdo e valor total
        System.out.println(cr);

    }
}
