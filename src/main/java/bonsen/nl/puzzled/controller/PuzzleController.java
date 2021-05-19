package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
@RequestMapping(value = "/users/puzzles")
public class PuzzleController {

    @Autowired
    private PuzzleService puzzleService;

    @GetMapping(value = "/")
    public ResponseEntity<Object> getPuzzles() { return ResponseEntity.ok().body(puzzleService.getPuzzles()); }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPuzzle(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(puzzleService.getPuzzle(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePuzzle(@PathVariable("id") String id, @RequestBody Puzzle puzzle) {
        puzzleService.updatePuzzle(id, puzzle);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePuzzle(@PathVariable("id") String id) {
        puzzleService.deletePuzzle(id);
        return ResponseEntity.noContent().build();
    }

}
