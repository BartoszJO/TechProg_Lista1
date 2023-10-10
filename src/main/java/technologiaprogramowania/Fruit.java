package technologiaprogramowania;

// Klasa owocow
public class Fruit {
    final private String name; // zmienne sa dostepne tylko wewnatrz klasy, aby po zainicjowaniu nazwy nie mozna juz go zmienic

    final private double pricePerKilogram;
    private int quantity;

    // Konstruktor klasy Fruit
    public Fruit(String name, double pricePerKilogram, int quantity) {
        this.name = name;
        this.pricePerKilogram = pricePerKilogram;
        this.quantity = quantity;
    }

    // Metody zwracajace wartosci zmiennych
    public String getName() {
        return name;
    }

    public double getPricePerKilogram() {
        return pricePerKilogram;
    }

    public int getQuantity() {
        return quantity;
    }

    // Ustawianie nowej wartosci zmeinnej quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Nadpisana metoda toString(), aby zwracane wartości były czytelne
    @Override
    public String toString() {
        return name + " (Cena za kg: " + pricePerKilogram + " zl, ilosc: " + quantity + " kg)";
    }
}
