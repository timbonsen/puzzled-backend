package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
@RequestMapping(value = "/puzzles")
public class PuzzleController {

    @Autowired
    private PuzzleService puzzleService;

    @GetMapping(value = "/")
    public ResponseEntity<Object> getAllPuzzles() { return ResponseEntity.ok().body(puzzleService.getPuzzles()); }

    @GetMapping(value = "/category/{searchBy}")
    public ResponseEntity<Object> getPuzzlesByCategory(@PathVariable("searchBy") String searchBy) {
        return ResponseEntity.ok().body(puzzleService.getPuzzlesByCategory(searchBy));
    }

    @GetMapping(value = "/brand/{searchBy}")
    public ResponseEntity<Object> getPuzzlesByBrand(@PathVariable("searchBy") String searchBy) {
        return ResponseEntity.ok().body(puzzleService.getPuzzlesByBrand(searchBy));
    }

    @GetMapping(value = "/number-of-pieces/{searchBy}")
    public ResponseEntity<Object> getPuzzlesByNumberOfPieces(@PathVariable("searchBy") int searchBy) {
        return ResponseEntity.ok().body(puzzleService.getPuzzlesByNumberOfPieces(searchBy));
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
