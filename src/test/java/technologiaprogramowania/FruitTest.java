package technologiaprogramowania;

import org.junit.Test;
import static org.junit.Assert.*;

public class FruitTest {
    @Test
    public void testFruitConstructor() {
        Fruit fruit = new Fruit("Jablko", 2.0, 10);
        assertEquals("Jablko", fruit.getName());
        assertEquals(2.0, fruit.getPricePerKilogram(), 0.001); // Dopuszczalny blad dla porownania liczb zmiennoprzecinkowych
        assertEquals(10, fruit.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        Fruit fruit = new Fruit("Jablko", 2.0, 10);
        fruit.setQuantity(5);
        assertEquals(5, fruit.getQuantity());
    }

}
