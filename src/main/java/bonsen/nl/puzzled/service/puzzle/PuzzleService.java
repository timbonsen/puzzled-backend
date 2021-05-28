package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.model.puzzle.Puzzle;

import java.util.Collection;
import java.util.Optional;

public interface PuzzleService {
    String createPuzzle(Puzzle puzzle);
    boolean setOwner(Puzzle puzzle, String username);
    boolean setImage(Puzzle puzzle, String imageId);
    boolean updatePuzzle(String id, Puzzle updatedPuzzle);
    boolean deletePuzzle(String id);
    boolean deletePuzzlesFromUser(String username);
    Collection<Puzzle> getPuzzles();
    Collection<Puzzle> getPuzzlesByCategory(String tag1);
    Collection<Puzzle> getPuzzlesByBrand(String brand);
    Collection<Puzzle> getPuzzlesByNumberOfPieces(int numberOfPieces);
    Collection<Puzzle> getPuzzlesByOwner(String username);
    Puzzle getPuzzle(String id);
    boolean puzzleExists(String id);
}
