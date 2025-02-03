package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    @Getter
    private static List<Book> availableBooks = new ArrayList<>();

    static {
        availableBooks.add(new Book("Introduction to Java Language", "Kathy Sierra and Bert Bates", 12.0));
                availableBooks.add(new Book("Introduction to Spring Boot", "Joshua Bloch", 15.0));
        availableBooks.add(new Book("Introduction to Spring MVC", "Cay S. Horstmann", 20.0));
        availableBooks.add(new Book("Introduction to C", "Kathy Sierra", 25.0));
        availableBooks.add(new Book("Introduction to C++", "Bruce Eckel", 30.0));
        availableBooks.add(new Book("Introduction to C#", "Brian Goetz", 40.0));
        availableBooks.add(new Book("Introduction to Python", "Elisabeth Robson", 50.50));
        availableBooks.add(new Book("Introduction to HTML5", "Y. Daniel Liang", 60.0));
        availableBooks.add(new Book("Java for Beginners", "Eric Freeman", 70.0));
        availableBooks.add(new Book("HTML for Beginners", "Herbert Schildt", 59.99));
    }


    public static void addBook(Book book) {
        availableBooks.add(book);
    }
}
