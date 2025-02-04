package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;


import lombok.*;

@Getter
@Setter
@Data
public class CartItem {


    private Long bookISBN;
    private String bookTitle;
    private double bookPrice;
    private int quantity;

    public CartItem(Long bookISBN, String bookTitle, double bookPrice, int quantity) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
    }
}
