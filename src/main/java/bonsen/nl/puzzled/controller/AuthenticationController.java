package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.exceptions.UsernameNotFoundException;
import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.payload.request.AuthenticationRequest;
import bonsen.nl.puzzled.payload.response.AuthenticationResponse;
import bonsen.nl.puzzled.service.address.AddressService;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
public class AuthenticationController {

    private static final String storageLocation = "D:/Werk/NOVI/Eindopdracht/PuzzleImages";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PuzzleService puzzleService;

    @Autowired
    JwtUtil jwtUtl;


    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok().body(principal);
    }


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtUtl.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        String newUsername = userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping(value = "/{username}/address")
    public ResponseEntity<Object> createAddress(@PathVariable("username") String username, @RequestBody Address address) {
        addressService.createAddress(address);
        userService.addAddress(username, address);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{username}/upload")
    public ResponseEntity<Object> createPuzzle(
            @PathVariable("username") String username,
            @RequestBody Puzzle puzzle,
            @RequestParam("image") MultipartFile multipartFile) throws IOException
    {
        multipartFile.transferTo(new File(storageLocation + multipartFile.getOriginalFilename()));
        String newPuzzle = puzzleService.createPuzzle(puzzle, multipartFile.getOriginalFilename(), username);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPuzzle).toUri();

        return ResponseEntity.created(location).build();
    }
}