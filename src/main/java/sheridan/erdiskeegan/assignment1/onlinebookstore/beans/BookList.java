package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;


import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

    @Component
    public class BookList {
         List<Book> availableBooks = new ArrayList<>();

        public BookList() {
            availableBooks.add(new Book("978-0134685991", "Effective Java", "Joshua Bloch", 45.99));
            availableBooks.add(new Book("978-0596009205", "Head First Java", "Kathy Sierra", 38.99));
        }

        public List<Book> getAvailableBooks() {
            return availableBooks;
        }

        public void addBook(Book book) {
            availableBooks.add(book);
        }
    }


