package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class PuzzleServiceImpl implements bonsen.nl.puzzled.service.PuzzleService {

    private PuzzleRepository puzzleRepository;

    @Override
    public String createPuzzle(Puzzle puzzle) {
        return null;
    }

    @Override
    public void updatePuzzle(UUID id, Puzzle puzzle) {

    }

    @Override
    public void deletePuzzle(UUID id) {

    }

    @Override
    public Collection<Puzzle> getPuzzles() {
        return null;
    }

    @Override
    public Optional<Puzzle> getPuzzle(UUID id) {
        return puzzleRepository.findById(id);
    }

    @Override
    public boolean puzzleExists(UUID id) {
        return false;
    }
}
