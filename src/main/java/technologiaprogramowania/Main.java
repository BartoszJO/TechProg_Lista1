package technologiaprogramowania;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


// Glowna metoda
public class Main {

    public static void main(String[] args) {

        // Utworzenie listy owocow dostepnych w sklepie
        List<Fruit> availableFruits = new ArrayList<>();

        // Dodanie 3 owocow do listy wraz z ich wlasnosciami
        availableFruits.add(new Fruit("Jablko", 2.0, 10));
        availableFruits.add(new Fruit("Banan", 1.5, 15));
        availableFruits.add(new Fruit("Pomarancza", 2.5, 8));

        // Inicjalizacja sklepu do ktorego przekazujemy dostepne owoce jako argument
        Shop fruitShop = new Shop(availableFruits);

        // Wywolujemy metode getShoppingCart() na obiekcie klasy Shop o nazwie fruitShop
        // Innymi slowy tworzymy nowa zmienna shoppingCart, ktora przechowuje referencje do koszyka
        // skojarzonego ze sklepem fruitShop
        // fruitShop --> klasa Shop --> metoda getShoppingCart()
        ShoppingCart shoppingCart = fruitShop.getShoppingCart();

        // Linijka umozliwajaca uzytkownikowi na wpisanie odpowiedzi w konsoli
        Scanner scanner = new Scanner(System.in);

        // Zmienna zachowujaca wybor uzytkownika, pozniej przypisana do scannera
        int choice;
        do {
            System.out.println("\nSklep z owocami - wybierz opcje: ");
            System.out.println("1. Wyswietl dostepne owoce");
            System.out.println("2. Dodaj owoc do koszyka");
            System.out.println("3. Wyswietl zawartosc koszyka");
            System.out.println("4. Dokonaj zakupu");
            System.out.println("5. Wyjscie");
            System.out.println("--> Wybierz opcję: ");
            System.out.println(availableFruits.get(0)); // wywoluje sie metoda toString() w Fruit.java
            System.out.println(availableFruits.get(1)); // -||-

            try {

                // Przypisujemy odpiwiedz uzytkownika do zmiennej choice (typu int)
                choice = scanner.nextInt();
                scanner.nextLine(); // przejscie na nowa linie, any moc pobierac kolejne wpisy uzytkownika

                switch (choice) {

                    // Obsluga wyswietlenia dostepnych owocow w sklepie
                    case 1:
                        fruitShop.displayAvailableFruits();
                        break;

                    // Obsluga dodawania owocu
                    case 2:
                        System.out.print("Podaj nazwe owocu (jablko, banan lub pomarancza): ");
                        String fruitName = scanner.nextLine(); // dla Stringa --> nextLine()
                        System.out.print("Podaj ilość (kg): ");
                        int quantity = scanner.nextInt(); // dla inta --> nextInt()

                        // Przeszukaj dostępne owoce w poszukiwaniu owocu o podanej nazwie
                        Fruit foundFruit = null; // null nie jest konieczny

                        // W petli zmienna fruit przyjmuje wartosc kolejnego elementu listy availableFruits
                        for (Fruit fruit : availableFruits) {
                            if (fruit.getName().equalsIgnoreCase(fruitName)) {
                                foundFruit = fruit;
                                break;
                            }
                        }

                        // Jesli znaleziony owoc bylby nullem, to znaczy, ze nie znalezniono owocu o danej nazwie
                        if (foundFruit != null) {

                            // Warunek sprawdzajacy, czy jest wystarczajaco owocow w sklepie
                            if (quantity <= foundFruit.getQuantity()) {
                                fruitShop.addToCart(foundFruit, quantity); // dodanie owocu do koszyka(konkretny owoc i jego ilosc)
                            } else {

                                // jesli jest mniej owocow niz chce kupic uzytkownik
                                System.out.println("Nie mamy tyle owocow :(");
                            }
                        } else {

                            // Gdy podano zla nazwe owocu
                            System.out.println("\nNie znaleziono owocu o nazwie: " + fruitName);
                        }

                        // Informacja zwrotna dla uzytkownika
                        System.out.println("\nDodano produkt do koszyka :)");

                        break;

                    // Pokazanie zawartosci koszyka
                    case 3:
                        shoppingCart.showCart();
                        break;

                    // Przetwarzanie platnosci za zakupy
                    case 4:
                        fruitShop.processPurchase();
                        break;

                    // Podziekowanie za zakupy
                    case 5:
                        System.out.println("Dziekujemy za zakupy!");
                        break;

                    // W razie nieprawidlowosci w odpowiedzi uzytkownika
                    default:
                        System.out.println("Nieprawidlowa operacja. Wybierz ponownie.");
                }

            // Obsluga wyjatku (np. dla podania "aaa", jako odpowiedz zamiast liczby z zakresu 1-5)
            } catch (InputMismatchException e) {
                System.out.println("Blad: Wprowadzono nieprawidlowy format danych. Wproadz liczbe ze zbioru od 1 do 5.");
                scanner.nextLine(); // przejscie do kolejnej linijki wpisywanej przez uzytkownika
                choice = 0; // zabezpieczenie przed niekonczaca sie petla
            }

        // Warunek reguluje, czy program ma dalej dzialac, czy nie
        // podanie 5 w panelu uzytkownika powoduje zakonczenie zakupow
        } while (choice != 5);
        scanner.close();
    }

}
