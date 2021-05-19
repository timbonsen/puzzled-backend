package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.model.puzzle.Puzzle;

import java.util.Collection;
import java.util.Optional;

public interface PuzzleService {
    String createPuzzle(Puzzle puzzle, String username, String imageId);
    void updatePuzzle(String id, Puzzle puzzle);
    void deletePuzzle(String id);
    Collection<Puzzle> getPuzzles();
    Collection<Puzzle> getPuzzlesByOwner(String username);
    Optional<Puzzle> getPuzzle(String id);
    boolean puzzleExists(String id);
}
