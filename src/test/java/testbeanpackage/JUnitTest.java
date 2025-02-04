package testbeanpackage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.CartService;

public class JUnitTest {
    private CartService cartService;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
    }

    @Test
    void testAddToCart() {
        cartService.addToCart(12345L, "Test Book", 200.0);
        assertEquals(1, cartService.getCartCount());
    }

    @Test
    void testCartCountAfterAddingSameBook() {
        cartService.addToCart(12345L, "Test Book", 15.99);
        cartService.addToCart(12345L, "Test Book", 23.00);
        assertEquals(2, cartService.getCartCount());
    }
}

