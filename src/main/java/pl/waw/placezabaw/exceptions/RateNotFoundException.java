package pl.waw.placezabaw.exceptions;

public class RateNotFoundException extends Exception {
    public RateNotFoundException() {
    }

    public RateNotFoundException(String message) {
        super(message);
    }
}
