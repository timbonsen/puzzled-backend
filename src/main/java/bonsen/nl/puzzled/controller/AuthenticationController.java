package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.exceptions.EmailAlreadyExistsException;
import bonsen.nl.puzzled.exceptions.UsernameAlreadyExistsException;
import bonsen.nl.puzzled.exceptions.UsernameNotFoundException;
import bonsen.nl.puzzled.exceptions.WrongPasswordException;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.payload.request.AuthenticationRequest;
import bonsen.nl.puzzled.payload.response.AuthenticationResponse;
import bonsen.nl.puzzled.service.user.CustomUserDetailsService;
import bonsen.nl.puzzled.service.user.UserService;
import bonsen.nl.puzzled.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    JwtUtil jwtUtl;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        if (!userService.userExists(username)) {
            throw new UsernameNotFoundException(username);
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }
        catch (Exception ex) {
            throw new WrongPasswordException();
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        final String jwt = jwtUtl.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userService.userExists(user.getUsername())) {
            throw new UsernameAlreadyExistsException(user.getUsername());
        } else if (userService.emailExists(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        } else {
            String encodedPassword = userService.encodePassword(user.getPassword());
            user.setPassword(encodedPassword);
            User authorizedUser = userService.addAuthority(user, "ROLE_USER");
            String newUsername = userService.createUser(authorizedUser);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                    .buildAndExpand(newUsername).toUri();

            return ResponseEntity.created(location).build();
        }
    }
}