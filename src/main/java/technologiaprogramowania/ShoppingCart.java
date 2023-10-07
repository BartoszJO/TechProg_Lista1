package technologiaprogramowania;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    final private List<Fruit> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Fruit fruit, int quantity) {
        // Dodawanie owocu do koszyka
        if (fruit != null && quantity > 0 && fruit.getQuantity() >= quantity) {
            Fruit cartItem = new Fruit(fruit.getName(), fruit.getPricePerKilogram(), quantity);
            items.add(cartItem);
            fruit.setQuantity(fruit.getQuantity() - quantity);
        }
    }

    public double sumOfPrices() {
        double sum = 0.0;
        for (Fruit item : items) {
            sum += item.getPricePerKilogram() * item.getQuantity();
        }
        return sum;
    }

    public void showCart() {
        System.out.println("Calkowita wartosc koszyka: " + sumOfPrices() + " zl");
    }

}
