package bonsen.nl.puzzled.model.puzzle;

import bonsen.nl.puzzled.model.user.User;

import javax.persistence.*;

import java.io.File;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "puzzles")
public class Puzzle {

    @Id
    @Column(nullable = false, unique = true)
    private String id = randomUUID().toString();

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
    private String tag1;

    @Column
    private String tag2;

    @Column
    private String tag3;

    @Column
    private File image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User owner;

    public Puzzle(String title, String eanCode, int numberOfPieces, String puzzleBrand, double width, double height, boolean reserved, String tag1, String tag2, String tag3, File image, User owner) {
        this.title = title;
        this.eanCode = eanCode;
        this.numberOfPieces = numberOfPieces;
        this.puzzleBrand = puzzleBrand;
        this.width = width;
        this.height = height;
        this.reserved = reserved;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.image = image;
        this.owner = owner;
    }

    public Puzzle() {

    }

    public String getId() {
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

    public File getImage() {
        return image;
    }
    public void setImage(File image) {
        this.image = image;
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

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
