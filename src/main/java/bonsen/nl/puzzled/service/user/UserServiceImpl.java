package bonsen.nl.puzzled.service.user;

import bonsen.nl.puzzled.exceptions.*;
import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.AddressRepository;
import bonsen.nl.puzzled.repository.AuthorityRepository;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Set<String> getUsers() {
        Collection<User> allUsers = userRepository.findAll();
        Set<String> allUsernames = new HashSet<>();
        for (User user : allUsers) {
            allUsernames.add(user.getUsername());
        }
        return allUsernames;
    }

    @Override
    public User getUser(String username) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public String createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

    @Override
    public boolean deleteUser(String username) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            for (Puzzle puzzle: user.getPuzzles()) {
                puzzleRepository.deleteById(puzzle.getId());
            }
            userRepository.deleteById(username);
            return !userRepository.existsById(username);
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public boolean updateUser(String username, User newUser) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setFirstname(newUser.getFirstname());
            user.setLastname(newUser.getLastname());
            user.addAddress(newUser.getAddress());
            userRepository.save(user);
            return true;
        }
        throw new RecordNotFoundException();
    }

    @Override
    public Set<Authority> getAuthorities(String username) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            return user.getAuthorities();
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public User addAuthority(User user, String authority) {
        if (user != null) {
            Authority newAuthority = new Authority(user.getUsername(), authority);
            authorityRepository.save(newAuthority);
            user.addAuthority(newAuthority);
            return user;
        }
        throw new BadRequestException();
    }

    @Override
    public boolean removeAuthority(String username, String authority) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
            user.removeAuthority(authorityToRemove);
            userRepository.save(user);
            return true;
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public Address getAddress(String id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            return address;
        }
        throw new AddressNotFoundException(id);
    }

    @Override
    public boolean addAddress(String username, String addressId) {
        User user = userRepository.findById(username).orElse(null);
        Address address = addressRepository.findById(addressId).orElse(null);

        if (user != null) {
            if (address != null) {
                user.addAddress(address);
                userRepository.save(user);
                return true;
            }
            throw new AddressNotFoundException(addressId);
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public String getPuzzles(String username) {
        User user = userRepository.findByUsername(username);
        Collection<Puzzle> puzzleCollection = puzzleRepository.getPuzzlesByOwner(user);
        JSONArray jsonArray = new JSONArray(puzzleCollection);
        return jsonArray.toString();
    }

    @Override
    public boolean addPuzzle(String username, Puzzle puzzle) {
        User user = userRepository.findById(username).orElse(null);
        if (user != null) {
            user.addPuzzle(puzzle);
            userRepository.save(user);
            return true;
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public boolean removePuzzle(String username, String puzzleId) {
        User user = userRepository.findById(username).orElse(null);
        Puzzle puzzle = puzzleRepository.findById(puzzleId).orElse(null);

        if (user != null) {
            if (puzzle != null) {
                user.removePuzzle(puzzle);
                userRepository.save(user);
                return true;
            }
            throw new PuzzleNotFoundException(puzzleId);
        }
        throw new UsernameNotFoundException(username);
    }
}