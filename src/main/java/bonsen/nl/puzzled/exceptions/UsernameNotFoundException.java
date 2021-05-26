package bonsen.nl.puzzled.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String username) {
        super("Cannot find user " + username);
    }

}