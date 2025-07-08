import books.*;
import services.*;
import exceptions.*;
import java.util.*;

public class BookstoreTest {
    public static void main(String[] args) {
        System.out.println("Quantum Bookstore - Running full test suite...");

        Inventory inventory = new Inventory();
        Bookstore bookstore = new Bookstore(inventory);

        Book paperBook1 = new PaperBook("ISBN001", "Clean Code", "Robert C. Martin", 2008, 150.0, 3);
        Book paperBook2 = new PaperBook("ISBN002", "Design Patterns", "Erich Gamma", 1994, 200.0, 1);
        Book eBook1     = new EBook("ISBN003", "Effective Java", "Joshua Bloch", 2018, 120.0, "EPUB");
        Book showcase   = new ShowcaseBook("ISBN004", "AI Research Highlights", "MIT AI Lab", 2020, 0.0);

        inventory.addBook(paperBook1);
        inventory.addBook(paperBook2);
        inventory.addBook(eBook1);
        inventory.addBook(showcase);

        try {
            System.out.println("buying 2 copies of 'Clean Code'");
            double paid = bookstore.buyBook("ISBN001", 2, "abdo1@example.com", "123 shubra Street");
            System.out.println("Quantum Bookstore - Paid: " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buying 1 copy of 'Effective Java'");
            double paid = bookstore.buyBook("ISBN003", 1, "mohsen@example.com", "");
            System.out.println("Quantum Bookstore - Paid: " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buying 2 copies of 'Design Patterns' (only 1 in stock)");
            bookstore.buyBook("ISBN002", 2, "ty@example.com", "Overflow Lane");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buying 1 copy of 'Design Patterns' (exact stock)");
            double paid = bookstore.buyBook("ISBN002", 1, "e@examomple.com", "One Time Ave");
            System.out.println("Quantum Bookstore - Paid: " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Attempting to buy Showcase Book");
            bookstore.buyBook("ISBN004", 1, "", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buying with non-existing ISBN");
            bookstore.buyBook("ISBN999", 1, "", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Attempting to buy 0 quantity of 'Clean Code'");
            bookstore.buyBook("ISBN001", 0, "", "");
        } catch (Exception e) {
            System.out.println("Quantum Bookstore - Invalid quantity (should handle in UI or logic): " + e.getMessage());
        }


        System.out.println("Removing outdated books (older than 10 years from 2025)");
        List<Book> removed = inventory.removeOutdatedBooks(10, 2025);
        for (Book b : removed) {
            System.out.println("Removed: " + b);
        }
        System.out.println("Quantum Bookstore - Total removed: " + removed.size());

        System.out.println(" Testing duplicate ISBN entry");
        inventory.addBook(new PaperBook("ISBN001", "Refactoring", "Martin Fowler", 2012, 140, 5));
        Book bookAfterOverride = inventory.getBook("ISBN001");
        System.out.println("Quantum Bookstore - Book with ISBN001 after override: " + bookAfterOverride);

        System.out.println("Quantum Bookstore - All tests completed.");
    }
}
