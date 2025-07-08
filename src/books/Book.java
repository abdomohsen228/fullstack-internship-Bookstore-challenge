package books;

public abstract class Book {
    protected String isbn, title, author;
    protected int publishedYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishedYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }
    public abstract boolean isAvailable(int quantity);
    public abstract void deliver(String email, String address, int quantity);
    public String getIsbn() { return isbn; }
    public int getPublishedYear() { return publishedYear; }
    public double getPrice() { return price; }
}
