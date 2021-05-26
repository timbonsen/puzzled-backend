package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.exceptions.*;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exceptionResponse(RecordNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exceptionResponse(BadRequestException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<Object> exceptionResponse(UsernameNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<Object> exceptionResponse(BadCredentialsException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = AddressNotFoundException.class)
    public ResponseEntity<Object> exceptionResponse(AddressNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = PuzzleNotFoundException.class)
    public ResponseEntity<Object> exceptionResponse(PuzzleNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = EmptyFieldException.class)
    public ResponseEntity<Object> exceptionResponse(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

    @GetMapping(value = "/exception/{exception-id}")
    public void getSpecificException(@PathVariable("exception-id") String exception) {
        if ("addressNotFound".equals(exception)) {
            throw new AddressNotFoundException("testId");
        } else if ("badCredentials".equals(exception)) {
            throw new bonsen.nl.puzzled.exceptions.BadCredentialsException();
        } else if ("badRequest".equals(exception)) {
            throw new BadRequestException();
        } else if ("emptyField".equals(exception)) {
            throw new EmptyFieldException();
        } else if ("puzzleNotFound".equals(exception)) {
            throw new PuzzleNotFoundException("testId");
        } else if ("recordNotFound".equals(exception)) {
            throw new RecordNotFoundException();
        } else if ("usernameNotFound".equals(exception)) {
            throw new UsernameNotFoundException("testUsername");
        }
    }
}