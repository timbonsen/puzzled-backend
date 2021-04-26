package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.model.puzzle.Puzzle;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface PuzzleService {
    public abstract String createPuzzle(Puzzle puzzle);
    public abstract void updatePuzzle(UUID id, Puzzle puzzle);
    public abstract void deletePuzzle(UUID id);
    public abstract Collection<Puzzle> getPuzzles();
    public abstract Optional<Puzzle> getPuzzle(UUID id);
    public abstract boolean puzzleExists(UUID id);
}
