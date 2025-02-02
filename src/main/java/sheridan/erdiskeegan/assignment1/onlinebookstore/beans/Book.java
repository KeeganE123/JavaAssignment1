package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;

public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;

    public Book(String bookISBN, String bookTitle, String bookAuthor, Double bookPrice) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    public String getBookISBN() { return bookISBN; }
    public String getBookTitle() { return bookTitle; }
    public String getBookAuthor() { return bookAuthor; }
    public Double getBookPrice() { return bookPrice; }
}

