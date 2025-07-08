package services;

import books.Book;
import exceptions.BookNotFoundException;
import exceptions.OutOfStockException;

public class Bookstore {
    private Inventory inventory;

    public Bookstore(Inventory inventory) {
        this.inventory = inventory;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.getBook(isbn);
        if (book == null) throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");

        if (!book.isAvailable(quantity))
            throw new OutOfStockException("Not enough quantity for ISBN: " + isbn);

        book.deliver(email, address, quantity);
        return book.getPrice() * quantity;
    }
}
