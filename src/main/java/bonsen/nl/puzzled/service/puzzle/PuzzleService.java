package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.model.puzzle.Puzzle;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface PuzzleService {
    public abstract String createPuzzle(Puzzle puzzle, String fileName, String username);
    public abstract void updatePuzzle(String id, Puzzle puzzle);
    public abstract void deletePuzzle(String id);
    public abstract Collection<Puzzle> getPuzzles();
    public abstract Optional<Puzzle> getPuzzle(String id);
    public abstract boolean puzzleExists(String id);
}
