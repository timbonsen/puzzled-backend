package bonsen.nl.puzzled.exceptions;

public class EmptyFieldException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmptyFieldException() {
        super("Field cannot be empty");
    }
}
