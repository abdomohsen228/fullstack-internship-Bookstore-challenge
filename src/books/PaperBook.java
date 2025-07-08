package books;

import services.ShippingService;

public class PaperBook extends Book {
    private int stock;
    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }
    @Override
    public boolean isAvailable(int quantity) {
        if (stock >= quantity) {
            return true;
        }
        return false;
    }
    @Override
    public void deliver(String email, String address, int quantity) {
        stock -= quantity;
        ShippingService.ship(address, this, quantity);
    }
}
