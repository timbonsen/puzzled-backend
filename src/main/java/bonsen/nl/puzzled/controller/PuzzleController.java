package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/puzzles")
public class PuzzleController {

    @Autowired
    private PuzzleService puzzleService;

    @GetMapping(value = "/")
    public ResponseEntity<Object> getPuzzles() { return ResponseEntity.ok().body(puzzleService.getPuzzles()); }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPuzzle(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(puzzleService.getPuzzle(id));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> createPuzzle(@RequestBody Puzzle puzzle) {
        String newPuzzle = puzzleService.createPuzzle(puzzle);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPuzzle).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePuzzle(@PathVariable("id") UUID id, @RequestBody Puzzle puzzle) {
        puzzleService.updatePuzzle(id, puzzle);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePuzzle(@PathVariable("id") UUID id) {
        puzzleService.deletePuzzle(id);
        return ResponseEntity.noContent().build();
    }

}
