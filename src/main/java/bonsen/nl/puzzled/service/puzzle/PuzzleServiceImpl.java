package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.ImageRepository;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PuzzleServiceImpl implements PuzzleService {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public String createPuzzle(Puzzle puzzle, String username, String imageId) {
        Puzzle newPuzzle = puzzleRepository.save(puzzle);
        User owner = userRepository.findByUsername(username);
        System.out.println("De eigenaar van de puzzel: " + owner.getUsername());
        newPuzzle.setOwner(owner);
        Image puzzleImage = imageRepository.findById(imageId).get();
        System.out.println("De image ID is: " + puzzleImage.getId());
        newPuzzle.setImage(puzzleImage);

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
