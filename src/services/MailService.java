package services;


import books.EBook;

public class MailService {
    public static void send(String email, EBook book) {
        System.out.println("Quantum Bookstore - Sending " + book.getIsbn() + " to " + email);
    }
}