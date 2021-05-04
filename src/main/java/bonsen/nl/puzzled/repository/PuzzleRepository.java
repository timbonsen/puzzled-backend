package bonsen.nl.puzzled.repository;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PuzzleRepository extends JpaRepository<Puzzle, String> {

/*    List<Puzzle> findAllByCategory(String category);
    List<Puzzle> findAllByEanCode(String eanCode);
    List<Puzzle> findAllByTitle(String title);
    List<Puzzle> findAllByPuzzleBrand(String puzzleBrand);

    Optional<Puzzle> findById();*/
}
