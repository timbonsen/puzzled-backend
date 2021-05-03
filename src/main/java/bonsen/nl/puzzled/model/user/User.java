package bonsen.nl.puzzled.model.user;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.model.authority.Authority;
import bonsen.nl.puzzled.model.puzzle.Puzzle;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String emailAddress;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(
            targetEntity = Address.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    @OneToMany(
            targetEntity = Puzzle.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Puzzle> puzzles = new HashSet<>();

    public User(String username, String password, String emailAddress, String firstName, String lastName, Address address) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        Authority authority = new Authority(username,"ROLE_USER");
        authorities.add(authority);
    }

    public User() {
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

    public Set<Puzzle> getPuzzles() {
        return puzzles;
    }
    public void addPuzzle(Puzzle puzzle) {
        this.puzzles.add(puzzle);
    }
    public void removePuzzle(Puzzle puzzle) {
        this.puzzles.remove(puzzle);
    }
}
