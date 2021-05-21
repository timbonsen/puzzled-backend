package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PuzzleRepository extends JpaRepository<Puzzle, String> {

    Collection<Puzzle> getPuzzlesByOwner(User owner);
/*    List<Puzzle> findAllByCategory(String category);
    List<Puzzle> findAllByEanCode(String eanCode);
    List<Puzzle> findAllByTitle(String title);
    List<Puzzle> findAllByPuzzleBrand(String puzzleBrand);

    Optional<Puzzle> findById();*/
}
