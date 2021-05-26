package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.exceptions.PuzzleNotFoundException;
import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.ImageRepository;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import bonsen.nl.puzzled.service.puzzle.PuzzleService;
import bonsen.nl.puzzled.service.puzzle.PuzzleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PuzzleServiceImplTest {

    @InjectMocks
    private final PuzzleService puzzleService = new PuzzleServiceImpl();

    @Mock
    private PuzzleRepository puzzleRepository;

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private UserRepository userRepository;

    private Puzzle puzzle;
    private Image image;
    private User user;
    private String wrongId = "wrongId";

    @BeforeEach
    void setUp() {
        puzzle = new Puzzle("Pinnokio's Dream", "87 10400 31114 0", 500, "Disney", 12.5, 10.1, false, "Disney");
        image = new Image();
        user = new User("user", "password", "user@puzzled.nl", "User", "Userson", null);
    }

    @Test
    void test_createPuzzle() {
        Mockito.when(puzzleRepository.save(puzzle)).thenReturn(puzzle);

        String responsePuzzleId = puzzleService.createPuzzle(puzzle);

        Assertions.assertSame(responsePuzzleId, puzzle.getId());
        Assertions.assertNotNull(responsePuzzleId);
    }

    @Test
    void test_setImage() {
        Mockito.when(imageRepository.findById(image.getId())).thenReturn(java.util.Optional.ofNullable(image));

        boolean hasWorked = puzzleService.setImage(puzzle, image.getId());

        Assertions.assertSame(puzzle.getImage(), image);
        Assertions.assertNotNull(puzzle.getImage());
        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_setOwner() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(Optional.ofNullable(user));

        boolean hasWorked = puzzleService.setOwner(puzzle, user.getUsername());

        Assertions.assertSame(puzzle.getOwner(), user);
        Assertions.assertNotNull(puzzle.getOwner());
        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_getPuzzle() {
        Mockito.when(puzzleRepository.findById(puzzle.getId())).thenReturn(java.util.Optional.ofNullable(puzzle));

        Puzzle responsePuzzle = puzzleService.getPuzzle(puzzle.getId());

        Assertions.assertSame(responsePuzzle, puzzle);
        Assertions.assertNotNull(responsePuzzle);
    }

    @Test
    void test_puzzleExists() {
        Mockito.when(puzzleRepository.existsById(puzzle.getId())).thenReturn(true);

        boolean response = puzzleService.puzzleExists(puzzle.getId());

        Assertions.assertTrue(response);
    }

    @Test
    void test_updatePuzzle() {
        Mockito.when(puzzleRepository.findById(puzzle.getId())).thenReturn(Optional.ofNullable(puzzle));

        boolean hasWorked = puzzleService.updatePuzzle(puzzle.getId(), puzzle);

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_deletePuzzle() {
        Mockito.when(puzzleRepository.findById(puzzle.getId())).thenReturn(Optional.ofNullable(puzzle));

        boolean hasWorked = puzzleService.deletePuzzle(puzzle.getId());

        Assertions.assertTrue(hasWorked);
    }
}
