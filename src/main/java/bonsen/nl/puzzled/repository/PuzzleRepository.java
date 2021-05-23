package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PuzzleRepository extends JpaRepository<Puzzle, String> {

    Collection<Puzzle> getPuzzlesByOwner(User owner);
    Collection<Puzzle> findAllByTag1(String tag1);
    Collection<Puzzle> findAllByPuzzleBrand(String puzzleBrand);
    Collection<Puzzle> findAllByNumberOfPieces(int numberOfPieces);
}
