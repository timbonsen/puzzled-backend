package bonsen.nl.puzzled.model;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private Address address;

    @BeforeEach
    void setUp() {
        this.address = new Address("Pandastraat","19","1234AB","Pandastad","Pandaland");
        this.user = new User("user","password", "user@puzzled.nl","User", "Userson", address);
    }

    @Test
    void testGetUsername() {
        String expectedUsername = "user";
        String actualUsername = this.user.getUsername();
        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    void testGetPassword() {
        String expectedPassword = "password";
        String actualPassword = this.user.getPassword();
        assertEquals(expectedPassword, actualPassword);
    }

    @Test
    void testGetEmailAddress() {
        String expectedEmailAddress = "user@puzzled.nl";
        String actualEmailAddress = this.user.getEmailAddress();
        assertEquals(expectedEmailAddress, actualEmailAddress);
    }

    @Test
    void testGetFirstName() {
        String expectedFirstName = "User";
        String actualFirstName = this.user.getFirstName();
        assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    void testGetLastName() {
        String expectedLastName = "Userson";
        String actualLastName = this.user.getLastName();
        assertEquals(expectedLastName, actualLastName);
    }

    @Test
    void testGetFullName() {
        String expectedFullName = "User Userson";
        String actualFullName = this.user.getFullName();
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testGetAddress() {
        Object expectedAddress = this.address;
        Object actualAddress = this.user.getAddress();
        assertEquals(expectedAddress, actualAddress);
    }

    @Test
    void testGetAuthorities() {
        Set<Authority> actualAuthority = this.user.getAuthorities();
        assertNotNull(actualAuthority);
    }

    @Test
    void testGetPuzzles() {
        Set<Puzzle> expectedPuzzles = new HashSet<>();
        Set<Puzzle> actualPuzzles = this.user.getPuzzles();
        assertEquals(expectedPuzzles, actualPuzzles);
    }

    @Test
    void testSetPassword() {
        String expectedPassword = "paasword";
        this.user.setPassword("paasword");
        String actualPassword = this.user.getPassword();
        assertEquals(expectedPassword, actualPassword);
    }

    @Test
    void testSetEmailAddress() {
        String expectedEmailAddress = "user@puzzled.nl";
        this.user.setEmailAddress("user@puzzled.nl");
        String actualEmailAddress = this.user.getEmailAddress();
        assertEquals(expectedEmailAddress, actualEmailAddress);
    }

    @Test
    void testSetFirstName() {
        String expectedFirstName = "Evert";
        this.user.setFirstName("Evert");
        String actualFirstName = this.user.getFirstName();
        assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    void testSetLastName() {
        String expectedLastName = "Userszoon";
        this.user.setLastName("Userszoon");
        String actualLastName = this.user.getLastName();
        assertEquals(expectedLastName, actualLastName);
    }

    @Test
    void testSetAddress() {
        String expectedAddressStreetName = "Berenstraat";
        Address newAddress = new Address("Berenstraat", "19","1234AC","Berenstad", "Berenland");
        this.user.addAddress(newAddress);
        String actualAddressStreetName = this.user.getAddress().getStreetName();
        assertEquals(expectedAddressStreetName, actualAddressStreetName);
    }


}
