package pl.waw.placezabaw.exceptions;

public class PlaygroundNotFoundException extends Exception {
    public PlaygroundNotFoundException() {
    }

    public PlaygroundNotFoundException(String message) {
        super(message);
    }
}
