package exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String msg) {
        super("Quantum Bookstore - " + msg);
    }
}