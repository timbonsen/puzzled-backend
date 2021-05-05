package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/puzzles")
public class PuzzleController {

    @Autowired
    private PuzzleService puzzleService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/")
    public ResponseEntity<Object> getPuzzles() { return ResponseEntity.ok().body(puzzleService.getPuzzles()); }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPuzzle(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(puzzleService.getPuzzle(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/addpuzzle")
    public ResponseEntity<Object> createPuzzle(@RequestBody Puzzle puzzle) {
        String newPuzzle = puzzleService.createPuzzle(puzzle);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPuzzle).toUri();

        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePuzzle(@PathVariable("id") String id, @RequestBody Puzzle puzzle) {
        puzzleService.updatePuzzle(id, puzzle);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePuzzle(@PathVariable("id") String id) {
        puzzleService.deletePuzzle(id);
        return ResponseEntity.noContent().build();
    }

}
