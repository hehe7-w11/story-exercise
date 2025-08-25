package UserDefinedException;

public class NoAvaialblePositionException extends Exception {
    public NoAvaialblePositionException(String message) {
        super(message);
    }
}