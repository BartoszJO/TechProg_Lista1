package technologiaprogramowania;

import java.util.List;

// Klasa sklepu z owocami
public class Shop {

    // Deklaracja zmiennej w liscie obiektow klasy Fruit oraz nowej zmiennej typu ShoppingCart,
    // ktora jest instancja klasy ShoppingCart
    final private List<Fruit> availableFruits;
    final private ShoppingCart shoppingCart;

    // Konstruktor klasy Shop, który jako argument przyjmuje liste dostepnych owocow
    public Shop(List<Fruit> availableFruits) {
        this.availableFruits = availableFruits;
        this.shoppingCart = new ShoppingCart(); // nowy obiekt klasy ShoppingCart
    }

    // Metoda zwracajaca koszyk zakupów
    // Metoda jest prosta metoda dostepowa (getter), ktora jest uzywana do
    // uzyskania obiektu koszyka zakupowego z klasy Shop
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    // Metoda zwracajaca dostepne w sklepie owoce
    public void displayAvailableFruits() {
        // Wyswietlenie dostepnych owocow
        System.out.println("\nDostepne owoce w sklepie: ");

        // Petla for-each w ktora przechodzi przez kazdy element listy availableFruits. W kazdej iteracji
        // petli "fruit" bedzie referencja do obiektu klasy Fruit
        for (Fruit fruit : availableFruits) {
            System.out.println(fruit.toString()); // uzycie nadpisanej metody toString()
        }
    }

    // Metoda dodajaca owoc i jego ilosc do koszyka
    public void addToCart(Fruit fruit, int quantity) {
        shoppingCart.addItem(fruit, quantity);
    }

    // Metoda procesujaca platnosc zakupow
    public void processPurchase() {
        System.out.println("Przetwarzanie zakupow...");

        // Wyswietlenie calkowitej ceny zakupow poprzez metode sumOfPrices()
        double totalAmount = shoppingCart.sumOfPrices();
        System.out.println("Calkowita wartosc zakupow: " + totalAmount + " zl");
        System.out.println("Platnosc potwierdzona $$$");
    }

}
