package books;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, author, year, price);
    }
    @Override
    public boolean isAvailable(int quantity) {
        return false;
    }
    @Override
    public void deliver(String email, String address, int quantity) {
        throw new UnsupportedOperationException("Showcase books are not for sale.");
    }
}
