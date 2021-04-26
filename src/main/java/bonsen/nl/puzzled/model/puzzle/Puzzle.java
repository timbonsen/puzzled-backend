package bonsen.nl.puzzled.model.puzzle;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "puzzles")
public class Puzzle {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id = UUID.randomUUID();

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

    @Column(nullable = false)
    private String mandatoryTag;

    @Column(nullable = false)
    private String owner;

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

    public String getMandatoryTag() {
        return mandatoryTag;
    }

    public void setMandatoryTag(String mandatoryTag) {
        this.mandatoryTag = mandatoryTag;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
