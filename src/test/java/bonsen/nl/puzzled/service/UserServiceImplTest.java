package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.AddressRepository;
import bonsen.nl.puzzled.repository.AuthorityRepository;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import bonsen.nl.puzzled.service.user.UserService;
import bonsen.nl.puzzled.service.user.UserServiceImpl;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private final UserService userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private PuzzleRepository puzzleRepository;

    private Puzzle puzzle;
    private User user;
    private Address address;
    private String encodedPassword = "encodedPassword";
    private String id;
    private Authority userAuthority;
    private Authority adminAuthority;
    private JSONArray jsonArray;

    @BeforeEach
    void setUp() {
        address = new Address("Pandastraat", "19", "1234AB", "Pandastad", "Pandaland");
        user = new User("user", "password", "user@puzzled.nl", "User", "Userson", null);
        puzzle = new Puzzle("Pinnokio's Dream", "87 10400 31114 0", 500, "Disney", 12.5, 10.1, false, "Disney");
        puzzle.setOwner(user);
        id = address.getId();
        userAuthority = new Authority(user.getUsername(), "ROLE_USER");
        adminAuthority = new Authority(user.getUsername(), "ROLE_ADMIN");
        user.addAuthority(userAuthority);
        user.addAuthority(adminAuthority);
        user.addPuzzle(puzzle);
        jsonArray = new JSONArray(user.getPuzzles());
    }

    @Test
    void test_encodePassword() {
        Mockito.when(passwordEncoder.encode(user.getPassword())).thenReturn(encodedPassword);

        String testEncodedPassword = userService.encodePassword(user.getPassword());

        Assertions.assertNotSame(testEncodedPassword, user.getPassword());
        Assertions.assertNotNull(testEncodedPassword);
        Assertions.assertEquals(testEncodedPassword, encodedPassword);
    }

    @Test
    void test_userExists() {
        Mockito.when(userRepository.existsById(user.getUsername())).thenReturn(true);

        boolean response = userService.userExists(user.getUsername());

        Assertions.assertTrue(response);
    }

    @Test
    void test_emailExists() {
        Mockito.when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        boolean response = userService.emailExists(user.getEmail());

        Assertions.assertTrue(response);
    }

    @Test
    void test_getUser() {
        Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

        User responseUser = userService.getUser(user.getUsername());

        Assertions.assertEquals(responseUser, user);
        Assertions.assertNotNull(responseUser);
    }

    @Test
    void test_createUser() {
        Mockito.when(userRepository.save(user)).thenReturn(user);

        String responseUsername = userService.createUser(user);

        Assertions.assertNotNull(responseUsername);
        Assertions.assertSame(responseUsername, user.getUsername());
    }

    @Test
    void test_deleteUser() {
        Mockito.when(userRepository.existsById(user.getUsername())).thenReturn(false);

        boolean hasWorked = userService.deleteUser(user.getUsername());

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_updateUser() {
        Mockito.when(userRepository.existsById(user.getUsername())).thenReturn(true);
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));

        boolean hasWorked = userService.updateUser(user.getUsername(), user);

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_getAddress() {
        Mockito.when(addressRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(address));

        Address responseAddress = userService.getAddress(address.getId());

        Assertions.assertNotNull(responseAddress);
        Assertions.assertSame(responseAddress, address);
    }

    @Test
    void test_addAddress() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));
        Mockito.when(addressRepository.findById(address.getId())).thenReturn(java.util.Optional.ofNullable(address));

        boolean hasWorked = userService.addAddress(user.getUsername(), address.getId());

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_getAuthorities() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));

        Set<Authority> responseAuthorities = userService.getAuthorities(user.getUsername());

        Assertions.assertNotNull(responseAuthorities);
        Assertions.assertSame(responseAuthorities, user.getAuthorities());
    }

    @Disabled
    @Test
    void test_addAuthority() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));

        boolean hasWorked = userService.addAuthority(user.getUsername(), userAuthority.getAuthority());

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_removeAuthority() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));

        boolean hasWorked = userService.removeAuthority(user.getUsername(), "ROLE_USER");

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_getPuzzles() {
        Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
        Mockito.when(puzzleRepository.getPuzzlesByOwner(user)).thenReturn(user.getPuzzles());

        String responseString = userService.getPuzzles(user.getUsername());

        Assertions.assertEquals(responseString, jsonArray.toString());
        Assertions.assertNotNull(responseString);
    }

    @Test
    void test_addPuzzle() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));

        boolean hasWorked = userService.addPuzzle(user.getUsername(), puzzle);

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_removePuzzle() {
        Mockito.when(userRepository.findById(user.getUsername())).thenReturn(java.util.Optional.ofNullable(user));
        Mockito.when(puzzleRepository.findById(puzzle.getId())).thenReturn(java.util.Optional.ofNullable(puzzle));

        boolean hasWorked = userService.removePuzzle(user.getUsername(), puzzle.getId());

        Assertions.assertTrue(hasWorked);
    }
}
