package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import bonsen.nl.puzzled.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PuzzleServiceImpl implements PuzzleService {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String createPuzzle(Puzzle puzzle, String fileName, String username) {
        Puzzle newPuzzle = puzzleRepository.save(puzzle);
        newPuzzle.setImageFileName(fileName);
        User owner = userRepository.findByUsername(username);
        newPuzzle.setOwner(owner);

        return newPuzzle.getId();
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
