package bonsen.nl.puzzled.model.puzzleTags;

import bonsen.nl.puzzled.model.puzzle.Puzzle;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "puzzleTags")
public class PuzzleTags {

    @Id
    @Column
    private UUID id = UUID.randomUUID();

    @Column
    private String tag1;

    @Column
    private String tag2;

    @Column
    private String tag3;

    @OneToOne(
            targetEntity = Puzzle.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Puzzle puzzle;

    public PuzzleTags(String tag1, String tag2, String tag3, Puzzle puzzle) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.puzzle = puzzle;
    }

    public PuzzleTags() {

    }

    public String getTag1() {
        return tag1;
    }
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }
    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }
    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
