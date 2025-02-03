package sheridan.erdiskeegan.assignment1.onlinebookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.Book;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.BookList;

import java.util.List;


@Controller
public class BookController {

    @GetMapping("/available-books")
    public String showAvailableBooks(Model model) {
        List<Book> books = BookList.getAvailableBooks();
        model.addAttribute("books", books);
        return "availableBooks";
    }

    @GetMapping("/")
    public String homePage() {
        return "index";  // Load the home page
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam("bookTitle") String bookTitle,
                          @RequestParam("bookAuthor") String bookAuthor,
                          @RequestParam("bookPrice") Double bookPrice) {
        Book newBook = new Book(bookTitle, bookAuthor, bookPrice);
        BookList.addBook(newBook);
        return "redirect:/available-books";
    }
}