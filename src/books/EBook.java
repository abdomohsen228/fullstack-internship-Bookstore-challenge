package books;

import services.MailService;

public class EBook extends Book {
    private String fileType;
    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        this.fileType = fileType;
    }
    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }
    @Override
    public void deliver(String email, String address, int quantity) {
        MailService.send(email, this);
    }
}
