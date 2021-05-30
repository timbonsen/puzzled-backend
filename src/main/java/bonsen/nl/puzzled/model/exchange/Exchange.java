package bonsen.nl.puzzled.model.exchange;

import bonsen.nl.puzzled.model.puzzle.Puzzle;
import bonsen.nl.puzzled.model.user.User;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "exchanges")
public class Exchange {

    @Id
    @Column(nullable = false)
    private String id = randomUUID().toString();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user1", referencedColumnName = "username")
    private User userOne;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user2", referencedColumnName = "username")
    private User userTwo;

    @Column
    private boolean UserOneHasAccepted = false;

    @Column
    private boolean UserTwoHasAccepted = false;

    @OneToMany(
            targetEntity = Puzzle.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Puzzle> puzzlesUserOne = new HashSet<>();

    @OneToMany(
            targetEntity = Puzzle.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Puzzle> puzzlesUserTwo = new HashSet<>();

    public Exchange(User userOne, User userTwo) {
        this.userOne = userOne;
        this.userTwo = userTwo;
    }

    public Exchange() {

    }

    public String getId() {
        return id;
    }

    public User getUserOne() {
        return userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public boolean getUserOneHasAccepted() {
        return UserOneHasAccepted;
    }
    public void setUserOneHasAccepted(boolean userOneHasAccepted) {
        UserOneHasAccepted = userOneHasAccepted;
    }

    public boolean getUserTwoHasAccepted() {
        return UserTwoHasAccepted;
    }
    public void setUserTwoHasAccepted(boolean userTwoHasAccepted) {
        UserTwoHasAccepted = userTwoHasAccepted;
    }

    public Set<Puzzle> getPuzzlesUserOne() {
        return puzzlesUserOne;
    }
    public void addPuzzleToPuzzlesUserOne(Puzzle puzzle) {
        this.puzzlesUserOne.add(puzzle);
    }
    public void removePuzzleFromPuzzlesUserOne(Puzzle puzzle) {
        this.puzzlesUserOne.remove(puzzle);
    }

    public Set<Puzzle> getPuzzlesUserTwo() {
        return puzzlesUserTwo;
    }
    public void addPuzzleToPuzzlesUserTwo(Puzzle puzzle) {
        this.puzzlesUserTwo.add(puzzle);
    }
    public void removePuzzleFromPuzzlesUserTwo(Puzzle puzzle) {
        this.puzzlesUserTwo.remove(puzzle);
    }
}