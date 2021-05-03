package bonsen.nl.puzzled.model;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.puzzleTags.PuzzleTags;
import bonsen.nl.puzzled.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleTagsTest {

    private PuzzleTags puzzleTags;
    private Puzzle puzzle;
    private User owner;
    private Address address;

    @BeforeEach
    void setUp() {
        this.address = new Address("Pandastraat","19","1234AB","Pandastad","Pandaland");
        this.owner = new User("user","password", "user@puzzled.nl","User", "Userson", address);
        this.puzzle = new Puzzle("Pinnokio's Dream", "87 10400 31114 0",500,"Disney",12.5,10, false, owner);
        this.puzzleTags = new PuzzleTags("Disney", "Nature", "Architecture", puzzle);
    }

    @Test
    void testGetTag1() {
        String expectedTag1 = "Disney";
        String actualTag1 = this.puzzleTags.getTag1();
        assertEquals(expectedTag1, actualTag1);
    }

    @Test
    void testGetTag2() {
        String expectedTag2 = "Nature";
        String actualTag2 = this.puzzleTags.getTag2();
        assertEquals(expectedTag2, actualTag2);
    }

    @Test
    void testGetTag3() {
        String expectedTag3 = "Architecture";
        String actualTag3 = this.puzzleTags.getTag3();
        assertEquals(expectedTag3, actualTag3);
    }

    @Test
    void testGetPuzzle() {
        Object expectedPuzzle = this.puzzle;
        Object actualPuzzle = this.puzzleTags.getPuzzle();
        assertEquals(expectedPuzzle, actualPuzzle);
    }

    @Test
    void testSetTag1() {
        String expectedTag1 = "Marvel";
        this.puzzleTags.setTag1("Marvel");
        String actualTag1 = this.puzzleTags.getTag1();
        assertEquals(expectedTag1, actualTag1);
    }

    @Test
    void testSetTag2() {
        String expectedTag2 = "Marvel";
        this.puzzleTags.setTag2("Marvel");
        String actualTag2 = this.puzzleTags.getTag2();
        assertEquals(expectedTag2, actualTag2);
    }

    @Test
    void testSetTag3() {
        String expectedTag3 = "Marvel";
        this.puzzleTags.setTag3("Marvel");
        String actualTag3 = this.puzzleTags.getTag3();
        assertEquals(expectedTag3, actualTag3);
    }
}
