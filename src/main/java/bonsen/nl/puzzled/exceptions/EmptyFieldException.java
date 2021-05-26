package bonsen.nl.puzzled.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyFieldException extends RuntimeException {

    public EmptyFieldException() {
        super("Field cannot be empty");
    }
}
