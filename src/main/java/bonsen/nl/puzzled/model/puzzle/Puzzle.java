package bonsen.nl.puzzled.model.puzzle;

import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.model.user.User;

import javax.persistence.*;


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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User owner;

    public Puzzle(String title, String eanCode, int numberOfPieces, String puzzleBrand, double width, double height, boolean reserved, String tag1) {
        this.title = title;
        this.eanCode = eanCode;
        this.numberOfPieces = numberOfPieces;
        this.puzzleBrand = puzzleBrand;
        this.width = width;
        this.height = height;
        this.reserved = reserved;
        this.tag1 = tag1;
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

    public String getPuzzleBrand() {
        return puzzleBrand;
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

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public String getTag1() {
        return tag1;
    }
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
