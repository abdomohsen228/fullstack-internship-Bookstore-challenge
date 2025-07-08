package exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String msg) {
        super("Quantum Bookstore - " + msg);
    }
}
