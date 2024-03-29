import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantSystemTest {

    @Test
    public void testOrderTotalCost() {
        Order order = new Order();
        order.addMenuItem(new Chicken(new Cheese(new Tomato(new Burger()))));
        order.addMenuItem(new Fries());
        order.addMenuItem(new Hotdog());

        assertEquals(20.0, order.getTotalCost(), 0.01);
    }

    @Test
    public void testDiscountApplication() {
        LoyaltySystem loyaltyDiscount = new LoyaltySystem("Gold");
        double discountedCost = loyaltyDiscount.applyDiscount(20.0);

        assertEquals(17.0, discountedCost, 0.01);
    }

    @Test
    public void testBurgerCostAndDescription() {
        Food burger = new Burger();
        assertEquals(7.0, burger.getCost(), 0.01);
        assertEquals("Burger", burger.getDescription());
    }

    @Test
    public void testChickenToppingCostAndDescription() {
        Food toppingChicken = new Chicken(new Burger());
        assertEquals(10.0, toppingChicken.getCost(), 0.01);
        assertEquals("Burger \n- Chicken (topping)", toppingChicken.getDescription());
    }

    @Test
    public void testCheeseToppingCostAndDescription() {
        Food toppingCheese = new Cheese(new Burger());
        assertEquals(9.0, toppingCheese.getCost(), 0.01);
        assertEquals("Burger \n- Cheese (topping)", toppingCheese.getDescription());
    }

    @Test
    public void testTomatoToppingCostAndDescription() {
        Food toppingTomato = new Tomato(new Burger());
        assertEquals(8.0, toppingTomato.getCost(), 0.01);
        assertEquals("Burger \n- Tomato (topping)", toppingTomato.getDescription());
    }

    @Test
    public void testHotdogCostAndDescription() {
        Food hotdog = new Hotdog();
        assertEquals(4.0, hotdog.getCost(), 0.01);
        assertEquals("Hotdog", hotdog.getDescription());
    }

    @Test
    public void testFriesCostAndDescription() {
        Food fries = new Fries();
        assertEquals(3.0, fries.getCost(), 0.01);
        assertEquals("Fries", fries.getDescription());
    }
}
