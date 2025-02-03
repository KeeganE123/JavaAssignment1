package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;

import lombok.Getter;

import java.util.Random;

@Getter
public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;


    public Book(String bookTitle, String bookAuthor, Double bookPrice) {
        this.bookISBN = generateRandomISBN();
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    private String generateRandomISBN() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }


}