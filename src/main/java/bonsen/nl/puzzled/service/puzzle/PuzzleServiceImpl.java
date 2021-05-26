package bonsen.nl.puzzled.service.puzzle;

import bonsen.nl.puzzled.exceptions.BadRequestException;
import bonsen.nl.puzzled.exceptions.PuzzleNotFoundException;
import bonsen.nl.puzzled.exceptions.UsernameNotFoundException;
import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.ImageRepository;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Transactional
@Service
public class PuzzleServiceImpl implements PuzzleService {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String createPuzzle(Puzzle puzzle) {
        Puzzle newPuzzle = puzzleRepository.save(puzzle);
        return newPuzzle.getId();
    }

    @Override
    public boolean setImage(Puzzle puzzle, String imageId) {
        Image puzzleImage = imageRepository.findById(imageId).orElse(null);
        if (puzzleImage != null) {
            puzzle.setImage(puzzleImage);
            return true;
        }
        throw new BadRequestException();
    }

    @Override
    public boolean setOwner(Puzzle puzzle, String username) {
        User owner = userRepository.findById(username).orElse(null);
        if (owner != null) {
            puzzle.setOwner(owner);
            return true;
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public boolean updatePuzzle(String id, Puzzle updatedPuzzle) {
        Puzzle oldPuzzle = puzzleRepository.findById(id).orElse(null);
        if (oldPuzzle != null) {
            puzzleRepository.save(updatedPuzzle);
            return true;
        }
        throw new PuzzleNotFoundException(id);
    }

    @Override
    public boolean deletePuzzle(String id) {
        Puzzle puzzle = puzzleRepository.findById(id).orElse(null);
        if (puzzle != null) {
            puzzleRepository.deleteById(id);
            return true;
        }
        throw new PuzzleNotFoundException(id);
    }

    @Override
    public Collection<Puzzle> getPuzzles() {
        return puzzleRepository.findAllByIdIsNotNull();
    }

    @Override
    public Collection<Puzzle> getPuzzlesByCategory(String tag1) {
        return puzzleRepository.findAllByTag1(tag1);
    }

    @Override
    public Collection<Puzzle> getPuzzlesByBrand(String brand) {
        return puzzleRepository.findAllByPuzzleBrand(brand);
    }

    @Override
    public Collection<Puzzle> getPuzzlesByNumberOfPieces(int numberOfPieces) {
        return puzzleRepository.findAllByNumberOfPieces(numberOfPieces);
    }

    @Override
    public Collection<Puzzle> getPuzzlesByOwner(String username) {
        User user = userRepository.findByUsername(username);
        return puzzleRepository.getPuzzlesByOwner(user);
    }

    @Override
    public Puzzle getPuzzle(String id) {
        Puzzle puzzle = puzzleRepository.findById(id).orElse(null);
        if (puzzle == null) {
            throw new PuzzleNotFoundException(id);
        }
        return puzzle;
    }

    @Override
    public boolean puzzleExists(String id) {
        return puzzleRepository.existsById(id);
    }
}
