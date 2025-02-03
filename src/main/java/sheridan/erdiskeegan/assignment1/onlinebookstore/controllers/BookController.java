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

import java.util.List;


@Controller
public class BookController {

    private final BookList bookList = new BookList();

    @GetMapping("/available-books")
    public String showAvailableBooks(Model model) {
        List<Book> books = bookList.getAvailableBooks();
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        return "availableBooks";
    }

    @GetMapping("/")
    public String homePage() {
        return "index";  // Load the home page
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {

      model.addAttribute("newBook", new Book());
      return "addBookForm";


    };

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("newBook") Book newBook) {
        bookList.addBook(newBook);
        return "redirect:/available-books";
    }
}