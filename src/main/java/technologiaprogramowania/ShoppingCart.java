package technologiaprogramowania;

import java.util.ArrayList;
import java.util.List;

// Klasa dla koszyka zakupow
public class ShoppingCart {

    // Tworzymy liste obiektow klasy Fruit

    final private List<Fruit> items;

    // Konstruktor tworzy nowa instancje obiektu AL i przypisuje ja do pola items
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // Metoda pozwalajaca na dodawanie produktow do koszyka
    // najpierw sprawdzamy w warunku, czy obiekt fruit nie jest pusty oraz czy ma jakies ?pola?
    // (sprawdzenie, czy obiekt zostal odpowiednio zainicjowany oraz czy jest po porstu obiektem)
    // nastepnie, czy jego ilsoc jest dodatnia (nie mozemy dodac czegos czego nie ma)
    // Na koniec sprawdzamy, czy ilosc jaka chcemy dodac jest dostepna w sklepie

    // Metoda w porownaniu do metody addToCart() w Shop.java sluzy glownie do operacji zwiazanych na
    // samym koszyku zakupowym (przykladowo ostania linijka metody), a metoda addToCart(), sluzy
    // do dodania produktu do koszyka
    // !!! metoda addToCart() korzysta z metody addItem() !!!
    public void addItem(Fruit fruit, int quantity) {
        // Dodawanie owocu do koszyka
        if (fruit != null && quantity > 0 && fruit.getQuantity() >= quantity) {

            // Tworzymy nowy obiekt klasy Fruit i pobieramy jego nazwe, cene oraz ilosc
            Fruit cartItem = new Fruit(fruit.getName(), fruit.getPricePerKilogram(), quantity);

            // Dodajemy owoc do listy
            items.add(cartItem);

            // Ustawiamy ilosc owocow, odejmujac ich dodana do kosza ilosc
            fruit.setQuantity(fruit.getQuantity() - quantity);
        }
    }

    // Metoda obliczajaca cene wszystkich produkctow
    // w petli for each przechodzimy przez wszystkie produkty i dodejmy ich cene do zmiennej sum
    public double sumOfPrices() {
        double sum = 0.0;
        for (Fruit item : items) {
            sum += item.getPricePerKilogram() * item.getQuantity(); // cena razy ilosc = cena za calosc dla owocu
        }
        return sum;
    }

    // Metoda pokazuje calkowita wartosc koszyka
    public void showCart() {
        System.out.println("Calkowita wartosc koszyka: " + sumOfPrices() + " zl");
    }

}
