package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.exceptions.BadRequestException;
import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.puzzle.PuzzleBuilder;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.service.address.AddressService;
import bonsen.nl.puzzled.service.image.ImageService;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
import bonsen.nl.puzzled.service.user.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PuzzleService puzzleService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/address")
    public ResponseEntity<Object> createAddress(@PathVariable("username") String username, @RequestBody Address address) {
        addressService.createAddress(address);
        userService.addAddress(username, address);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{username}/address")
    public ResponseEntity<Object> updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/puzzles")
    public ResponseEntity<Object> getPuzzles(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getPuzzles(username));
    }

    @PostMapping(value = "/{username}/upload")
    public ResponseEntity<Object> createPuzzle(
            @PathVariable("username") String username,
            @RequestBody String puzzleInput
            ) throws JSONException {
/*        System.out.println("Dit krijg je binnen: " + puzzleInput);*/
        JSONObject puzzleObject = new JSONObject(puzzleInput);
/*        System.out.println(puzzleObject);
        System.out.println(puzzleObject.getString("eanCode"));*/
        Puzzle newPuzzle = new Puzzle(
                puzzleObject.getString("title"),
                puzzleObject.getString("eanCode"),
                puzzleObject.getInt("numberOfPieces"),
                puzzleObject.getString("puzzleBrand"),
                puzzleObject.getDouble("puzzleWidth"),
                puzzleObject.getDouble("puzzleHeight"),
                puzzleObject.getBoolean("activated"),
                puzzleObject.getString("tag1"));
        String imageId = puzzleObject.getString("imageId");
        System.out.println("Dit is de nieuwe puzzel: " + newPuzzle.getEanCode());
        String newPuzzleId = puzzleService.createPuzzle(newPuzzle, username, imageId);
        userService.addPuzzle(username, newPuzzle);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPuzzleId).toUri();

        return ResponseEntity.created(location).body(newPuzzleId);
    }

    @DeleteMapping(value = "/{username}/delete-puzzle")
    public ResponseEntity<Object> removePuzzle(
            @PathVariable("username") String username,
            @RequestBody String puzzleId) {
        userService.removePuzzle(username, puzzleId);

        return ResponseEntity.noContent().build();
    }
}