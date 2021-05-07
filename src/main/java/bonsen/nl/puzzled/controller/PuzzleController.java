package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;

@RestController
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
@RequestMapping(value = "/puzzles")
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
