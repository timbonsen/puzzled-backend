package bonsen.nl.puzzled.exceptions;

public class AtLeastOneTagException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AtLeastOneTagException() {
        super("At least one tag should be declared!");
    }
}
