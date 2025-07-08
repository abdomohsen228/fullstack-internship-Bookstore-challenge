package services;

import books.Book;
import java.util.*;

public class Inventory {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
    public void removeBook(String isbn) {
        books.remove(isbn);
    }
    public List<Book> removeOutdatedBooks(int yearsLimit, int currentYear) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            if (currentYear - entry.getValue().getPublishedYear() > yearsLimit) {
                removed.add(entry.getValue());
                iterator.remove();
            }
        }
        return removed;
    }
}
