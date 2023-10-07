package technologiaprogramowania;

import java.util.List;

public class Shop {

    private List<Fruit> availableFruits;
    private ShoppingCart shoppingCart;

    public Shop(List<Fruit> availablrFruits) {
        this.availableFruits = availablrFruits;
        this.shoppingCart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void displayAvailableFruits() {
        // Wyswietlenie dostepnych owocow
        System.out.println("\nDostepne owoce w sklepie: ");
        for (Fruit fruit : availableFruits) {
            System.out.println(fruit.toString());
        }
    }

    public void addToCart(Fruit fruit, int quantity) {
        shoppingCart.addItem(fruit, quantity);
    }

    public void processPurchase() {
        System.out.println("Przetwarzanie zakupow...");
        double totalAmount = shoppingCart.sumOfPrices();
        System.out.println("Calkowita wartosc zakupow: " + totalAmount + " zl");
        System.out.println("Platnosc potwierdzona $$$");
    }

}
