package bonsen.nl.puzzled.model;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuzzleTest {

    /*private Puzzle puzzle;*/
    private User ownerA;
    private User ownerB;
    private Address address;

    @BeforeEach
    void setUp() {
        this.address = new Address("Pandastraat", "19", "1234AB", "Pandastad", "Pandaland");
        this.ownerA = new User("user", "password", "user@puzzled.nl", "User", "Userson", address);
        this.ownerB = new User("henk", "password", "henk@puzzled.nl", "Henk", "Kramer", address);
        /*this.puzzle = new Puzzle("Pinnokio's Dream", "87 10400 31114 0", 500, "Disney", 12.5, 10.1, false, "Disney", "Nature", "Architecture", ownerA);*/
    }

    /*@Test
    void testGetId() {
        assertNotNull(this.puzzle.getId());
    }*/

    /*@Test
    void testGetTitle() {
        String expectedTitle = "Pinnokio's Dream";
        String actualTitle = this.puzzle.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }*/

    /*@Test
    void testGetEanCode() {
        String expectedEanCode = "87 10400 31114 0";
        String actualEanCode = this.puzzle.getEanCode();
        assertEquals(expectedEanCode, actualEanCode);
    }*/

    /*@Test
    void testGetNumberOfPieces() {
        int expectedNumberOfPieces = 500;
        int actualNumberOfPieces = this.puzzle.getNumberOfPieces();
        assertEquals(expectedNumberOfPieces, actualNumberOfPieces);
    }*/

    /*@Test
    void testGetPuzzleBrand() {
        String expectedPuzzleBrand = "Disney";
        String actualPuzzleBrand = this.puzzle.getPuzzleBrand();
        assertEquals(expectedPuzzleBrand, actualPuzzleBrand);
    }*/

    /*@Test
    void testGetWidth() {
        double expectedWidth = 12.5;
        double actualWidth = this.puzzle.getWidth();
        assertEquals(expectedWidth, actualWidth);
    }*/

    /*@Test
    void testGetHeight() {
        double expectedHeight = 10.1;
        double actualHeight = this.puzzle.getHeight();
        assertEquals(expectedHeight, actualHeight);
    }*/

    /*@Test
    void testGetReserved() {
        boolean expectedReserved = false;
        boolean actualReserved = this.puzzle.isReserved();
        assertEquals(expectedReserved, actualReserved);
    }*/

    /*@Test
    void testGetOwner() {
        Object expectedOwner = this.ownerA;
        Object actualOwner = this.puzzle.getOwner();
        assertEquals(expectedOwner, actualOwner);
    }*/

    /*@Test
    void testSetTitle() {
        String expectedTitle = "Marvel's Dream";
        this.puzzle.setTitle("Marvel's Dream");
        String actualTitle = this.puzzle.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }*/

    /*@Test
    void testSetNumberOfPieces() {
        int expectedNumberOfPieces = 1000;
        this.puzzle.setNumberOfPieces(1000);
        int actualNumberOfPieces = this.puzzle.getNumberOfPieces();
        assertEquals(expectedNumberOfPieces, actualNumberOfPieces);
    }*/

    /*@Test
    void testSetPuzzleBrand() {
        String expectedPuzzleBrand = "Jumbo";
        this.puzzle.setPuzzleBrand("Jumbo");
        String actualPuzzleBrand = this.puzzle.getPuzzleBrand();
        assertEquals(expectedPuzzleBrand, actualPuzzleBrand);
    }*/

    /*@Test
    void testSetReserved() {
        this.puzzle.setReserved(true);
        assertTrue(this.puzzle.isReserved());
    }*/

    /*@Test
    void testSetOwner() {
        User expectedOwner = ownerB;
        this.puzzle.setOwner(ownerB);
        User actualOwner = this.puzzle.getOwner();
        assertEquals(expectedOwner, actualOwner);
    }*/
}
