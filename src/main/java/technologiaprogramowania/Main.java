package technologiaprogramowania;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Fruit> availableFruits = new ArrayList<>();
        availableFruits.add(new Fruit("Jablko", 2.0, 10));
        availableFruits.add(new Fruit("Banan", 1.5, 15));
        availableFruits.add(new Fruit("Pomarancza", 2.5, 8));

        Shop fruitShop = new Shop(availableFruits);
        ShoppingCart shoppingCart = fruitShop.getShoppingCart();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nSklep z owocami - wybierz opcje: ");
            System.out.println("1. Wyswietl dostepne owoce");
            System.out.println("2. Dodaj owoc do koszyka");
            System.out.println("3. Wyswietl zawartosc koszyka");
            System.out.println("4. Dokonaj zakupu");
            System.out.println("5. Wyjscie");
            System.out.println("--> Wybierz opcję: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine(); // przejscie na nowa linie, any moc pozniej pobierac kolejne wpisy uzytkownika

                switch (choice) {
                    case 1:
                        fruitShop.displayAvailableFruits();
                        break;
                    case 2:
                        System.out.print("Podaj nazwe owocu (jablko, banan lub pomarancza): ");
                        String fruitName = scanner.nextLine();
                        System.out.print("Podaj ilość (kg): ");
                        int quantity = scanner.nextInt();

                        // Przeszukaj dostępne owoce w poszukiwaniu owocu o podanej nazwie
                        Fruit foundFruit = null;
                        for (Fruit fruit : availableFruits) {
                            if (fruit.getName().equalsIgnoreCase(fruitName)) {
                                foundFruit = fruit;
                                break;
                            }
                        }

                        System.out.println("\nDodano produkt do koszyka :)");

                        if (foundFruit != null) {
                            if (quantity <= foundFruit.getQuantity()) {
                                fruitShop.addToCart(foundFruit, quantity);
                            } else {
                                System.out.println("Nie mamy tyle owocow :(");
                            }
                        } else {
                            System.out.println("\nNie znaleziono owocu o nazwie: " + fruitName);
                        }

                        break;
                    case 3:
                        shoppingCart.showCart();
                        break;
                    case 4:
                        fruitShop.processPurchase();
                        break;
                    case 5:
                        System.out.println("Dziekujemy za zakupy!");
                        break;
                    default:
                        System.out.println("Nieprawidlowa operacja. Wybierz ponownie.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Blad: Wprowadzono nieprawidlowy format danych. Wproadz liczbe ze zbioru od 1 do 5.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 5);
        scanner.close();
    }

}
