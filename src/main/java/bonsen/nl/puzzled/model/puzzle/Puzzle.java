package bonsen.nl.puzzled.model.puzzle;

import bonsen.nl.puzzled.model.tags.Tags;
import bonsen.nl.puzzled.model.user.User;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "puzzles")
public class Puzzle {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id = randomUUID();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 13)
    private String eanCode;

    @Column(nullable = false)
    private int numberOfPieces;

    @Column(nullable = false)
    private String puzzleBrand;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private boolean reserved;

    @OneToOne(
            targetEntity = Tags.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Tags tags;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User owner;

    public Puzzle(String title, String eanCode, int numberOfPieces, String puzzleBrand, double width, double height, boolean reserved, Tags tags, User owner) {
        this.title = title;
        this.eanCode = eanCode;
        this.numberOfPieces = numberOfPieces;
        this.puzzleBrand = puzzleBrand;
        this.width = width;
        this.height = height;
        this.reserved = reserved;
        this.tags = tags;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEanCode() {
        return eanCode;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }
    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public String getPuzzleBrand() {
        return puzzleBrand;
    }
    public void setPuzzleBrand(String puzzleBrand) {
        this.puzzleBrand = puzzleBrand;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Tags getTags() {
        return tags;
    }
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
