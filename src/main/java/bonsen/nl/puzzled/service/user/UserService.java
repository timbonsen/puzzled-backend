package bonsen.nl.puzzled.service.user;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    public abstract String createUser(User user);
    public abstract void updateUser(String username, User user);
    public abstract void deleteUser(String username);
    public abstract Collection<User> getUsers();
    public abstract User getUser(String username);
    public abstract boolean userExists(String username);
    public abstract Set<Authority> getAuthorities(String username);
    public abstract void addAuthority(String username, String authority);
    public abstract void removeAuthority(String username, String authority);
    public abstract Optional<Address> getAddress(String id);
    public abstract void addAddress(String username, Address address);
    public abstract Set<Puzzle> getPuzzles(String username);
    public abstract void addPuzzle(String username, Puzzle puzzle);
    public abstract void removePuzzle(String username, String puzzleId);
}