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
    public void updatePuzzle(String id, Puzzle puzzle) {

    }

    @Override
    public void deletePuzzle(String id) {

    }

    @Override
    public Collection<Puzzle> getPuzzles() {
        return null;
    }

    @Override
    public Optional<Puzzle> getPuzzle(String id) {
        return puzzleRepository.findById(id);
    }

    @Override
    public boolean puzzleExists(String id) {
        return false;
    }
}
