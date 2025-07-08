package services;

import books.PaperBook;

public class ShippingService {
    public static void ship(String address, PaperBook book, int quantity) {
        System.out.println("Quantum Bookstore - Shipping " + quantity + "x " + book.getIsbn() + " to " + address);
    }
}
