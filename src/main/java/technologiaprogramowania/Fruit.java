package technologiaprogramowania;

public class Fruit {
    final private String name;
    final private double pricePerKilogram;
    private int quantity;

    public Fruit(String name, double pricePerKilogram, int quantity) {
        this.name = name;
        this.pricePerKilogram = pricePerKilogram;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPricePerKilogram() {
        return pricePerKilogram;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " (Cena za kg: " + pricePerKilogram + " zl, ilosc: " + quantity + " kg)";
    }
}
