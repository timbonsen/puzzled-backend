package bonsen.nl.puzzled.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(String id) {
        super("Cannot find address " + id);
    }
}
