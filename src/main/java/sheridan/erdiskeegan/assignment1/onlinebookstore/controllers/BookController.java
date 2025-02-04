package sheridan.erdiskeegan.assignment1.onlinebookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.Book;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.BookList;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.CartItem;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.CartService;


import java.util.List;

@Controller
public class BookController {

    private final BookList bookList = new BookList();

    @Autowired
    private CartService cartService;

    @GetMapping("/available-books")
    public String showAvailableBooks(Model model) {
        List<Book> books = bookList.getAvailableBooks();
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        return "availableBooks";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {

      model.addAttribute("newBook", new Book());
      return "addBookForm";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("newBook") Book newBook) {
        bookList.addBook(newBook);
        return "redirect:/available-books";
    }

    @GetMapping("/shopping-books")
    public String showShoppingBooks(Model model) {
        List<Book> books = bookList.getAvailableBooks();
        model.addAttribute("books", books);
        model.addAttribute("cart", cartService.getCart());
        model.addAttribute("cartCount", cartService.getCartCount());
        return "shoppingBooks";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam Long bookISBN, @RequestParam String bookTitle, @RequestParam double bookPrice) {
        cartService.addToCart(bookISBN, bookTitle, bookPrice);
        return "redirect:/shopping-books";
    }

    @GetMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam Long bookISBN) {
        cartService.removeFromCart(bookISBN);
        return "redirect:/shopping-books";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        List<CartItem> cartItems = cartService.getCart();


        double subtotal = cartItems.stream()
                .mapToDouble(item -> item.getQuantity() * item.getBookPrice())
                .sum();


        double saleTax = subtotal * 0.13;
        double total = subtotal + saleTax;


        model.addAttribute("cartItems", cartItems);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("saleTax", saleTax);
        model.addAttribute("total", total);

        return "checkout";
    }
}