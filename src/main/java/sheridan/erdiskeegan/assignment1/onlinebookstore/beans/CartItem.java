package sheridan.erdiskeegan.assignment1.onlinebookstore.beans;


import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
public class CartItem {


    private Long bookISBN;
    private String bookTitle;
    private int quantity;
}
