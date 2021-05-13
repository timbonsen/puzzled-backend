package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import bonsen.nl.puzzled.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

@Service
public class PuzzleServiceImpl implements PuzzleService {

    private static final String storageLocation = "D:/Werk/NOVI/Eindopdracht/PuzzleImages/Uploaded/";

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String createPuzzle(Puzzle puzzle, String username) {
        File image = puzzle.getImage();
        image = new File(storageLocation);
        Puzzle newPuzzle = puzzleRepository.save(puzzle);
        User owner = userRepository.findByUsername(username);
        newPuzzle.setOwner(owner);
        newPuzzle.setImage(image);

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
    public Collection<Puzzle> getPuzzlesByOwner(String username) {
        return puzzleRepository.getPuzzlesByOwner(username);
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
