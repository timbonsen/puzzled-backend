package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.payload.response.ResponseMessage;
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

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllPuzzles() {
        return ResponseEntity.ok().body(puzzleService.getPuzzles());
    }

    @GetMapping(value = "/tags/{searchBy}")
    public ResponseEntity<Object> getPuzzlesByCategory(@PathVariable("searchBy") String searchBy) {
        return ResponseEntity.ok().body(puzzleService.getPuzzlesByCategory(searchBy));
    }

    @GetMapping(value = "/brands/{searchBy}")
    public ResponseEntity<Object> getPuzzlesByBrand(@PathVariable("searchBy") String searchBy) {
        return ResponseEntity.ok().body(puzzleService.getPuzzlesByBrand(searchBy));
    }

    @GetMapping(value = "/pieces/{searchBy}")
    public ResponseEntity<Object> getPuzzlesByNumberOfPieces(@PathVariable("searchBy") int searchBy) {
        return ResponseEntity.ok().body(puzzleService.getPuzzlesByNumberOfPieces(searchBy));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPuzzle(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(puzzleService.getPuzzle(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePuzzle(@PathVariable("id") String id, @RequestBody Puzzle puzzle) {
        puzzleService.updatePuzzle(id, puzzle);
        return ResponseEntity.ok().body(new ResponseMessage("Puzzle successfully updated"));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePuzzle(@PathVariable("id") String id) {
        String message;
        try {
            puzzleService.deletePuzzle(id);
            message = "Puzzle successfully deleted";
        } catch (Exception e) {
            message = "Could not delete the puzzle";
        }
        return ResponseEntity.ok().body(new ResponseMessage(message));
    }

}
