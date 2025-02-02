package sheridan.erdiskeegan.assignment1.onlinebookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.Book;
import sheridan.erdiskeegan.assignment1.onlinebookstore.beans.BookList;

@Controller
public class BookController {
    private final BookList bookList;

    public BookController(BookList bookList) {
        this.bookList = bookList;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("books", bookList.getAvailableBooks());
        return "index";
    }

    @GetMapping("/available-books")
    public String viewAvailableBooks(Model model) {
        model.addAttribute("books", bookList.getAvailableBooks());
        return "available_books";
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam("bookISBN") String bookISBN,
                          @RequestParam("bookTitle") String bookTitle,
                          @RequestParam("bookAuthor") String bookAuthor,
                          @RequestParam("bookPrice") Double bookPrice){
        Book newBook = new Book(bookISBN, bookTitle, bookAuthor, bookPrice);
        bookList.addBook(newBook);
        return "redirect:/available-books";
    }
}
