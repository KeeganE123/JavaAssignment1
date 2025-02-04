package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;


import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.CartItem;



@Getter
@Service
public class CartService {

    public final List<CartItem> cart = new ArrayList<>();



    public void addToCart(Long bookISBN, String bookTitle, double bookPrice) {
        for (CartItem item : cart) {
            if (item.getBookISBN().equals(bookISBN)) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        cart.add(new CartItem(bookISBN, bookTitle, bookPrice, 1));
    }

    public int getCartCount() {
        return cart.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public void removeFromCart(Long bookISBN) {
        cart.removeIf(item -> item.getBookISBN().equals(bookISBN));
    }


    public void clearCart() {
        cart.clear();
    }
}