package bonsen.nl.puzzled.service.user;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import java.util.Set;

public interface UserService {

    String createUser(User user);
    boolean updateUser(String username, User user);
    boolean deleteUser(String username);
    Set<String> getUsers();
    User getUser(String username);

    boolean userExists(String username);
    boolean emailExists(String email);

    String encodePassword(String password);

    Set<Authority> getAuthorities(String username);
    User addAuthority(User user, String authorityRole);
    boolean removeAuthority(String username, String authority);

    Address getAddress(String id);
    boolean addAddress(String username, String addressId);

    String getPuzzles(String username);
    boolean addPuzzle(String username, Puzzle puzzle);
    boolean removePuzzle(String username, String puzzleId);
}