package bonsen.nl.puzzled.service.user;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    String createUser(User user);
    void updateUser(String username, User user);
    void deleteUser(String username);
    Collection<User> getUsers();
    User getUser(String username);
    boolean userExists(String username);

    Set<Authority> getAuthorities(String username);
    void addAuthority(String username, String authority);
    void removeAuthority(String username, String authority);

    Optional<Address> getAddress(String id);
    void addAddress(String username, Address address);

    String getPuzzles(String username);
    void addPuzzle(String username, Puzzle puzzle);
    void removePuzzle(String username, String puzzleId);
}