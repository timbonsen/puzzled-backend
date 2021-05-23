package bonsen.nl.puzzled.service.user;

import bonsen.nl.puzzled.exceptions.RecordNotFoundException;
import bonsen.nl.puzzled.exceptions.UsernameNotFoundException;
import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import bonsen.nl.puzzled.repository.AddressRepository;
import bonsen.nl.puzzled.repository.AuthorityRepository;
import bonsen.nl.puzzled.repository.PuzzleRepository;
import bonsen.nl.puzzled.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

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
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public String createUser(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        Authority newAuthority = new Authority(user.getUsername(), "ROLE_USER");
        user.addAuthority(newAuthority);
        User newUser = userRepository.save(user);
        Set<Authority> authorities = newUser.getAuthorities();
        for (Authority authority: authorities) {
            authorityRepository.save(authority);
        }
        return newUser.getUsername();
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());
        user.setFirstname(newUser.getFirstname());
        user.setLastname(newUser.getLastname());
        user.addAddress(newUser.getAddress());
        userRepository.save(user);
    }

    @Override
    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    @Override
    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    @Override
    public Optional<Address> getAddress(String id) {
        return addressRepository.findById(id);
    }

    @Override
    public void addAddress(String username, Address address) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAddress(address);
        userRepository.save(user);
    }

    @Override
    public String getPuzzles(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println("Dit is de gebruiker wiens puzzels worden opgevraagd: " + user);
        Collection<Puzzle> puzzleCollection = puzzleRepository.getPuzzlesByOwner(user);
        JSONArray jsonArray = new JSONArray(puzzleCollection);
        /*for (Puzzle puzzle:puzzleCollection) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", puzzle.getId());
            jsonObject.put("title", puzzle.getTitle());
            jsonObject.put("eanCode", puzzle.getEanCode());
            jsonObject.put("numberOfPieces", puzzle.getNumberOfPieces());
            jsonObject.put("puzzleBrand", puzzle.getPuzzleBrand());
            Image image = puzzle.getImage();
            jsonObject.put("imageId", image.getId());
            System.out.println(jsonObject);
            jsonArray.put(jsonObject);
        }*/
        System.out.println(jsonArray);
        return jsonArray.toString();
    }

    @Override
    public void addPuzzle(String username, Puzzle puzzle) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addPuzzle(puzzle);
        userRepository.save(user);
    }

    @Override
    public void removePuzzle(String username, String puzzleId) {
        User user = userRepository.findById(username).get();
        Optional<Puzzle> puzzle = puzzleRepository.findById(puzzleId);
        user.removePuzzle(puzzle);
        userRepository.save(user);
    }
}