package bonsen.nl.puzzled.model.puzzle;

import bonsen.nl.puzzled.exceptions.EmptyFieldException;
import bonsen.nl.puzzled.model.user.User;

import java.io.File;

public class PuzzleBuilder {

    private String title;
    private String eanCode;
    private int numberOfPieces;
    private String puzzleBrand;
    private double width;
    private double height;
    private boolean reserved;
    private String tag1;
    private String tag2;
    private String tag3;
    private File image;
    private User owner;

    public PuzzleBuilder() {

    }

    public PuzzleBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    public PuzzleBuilder withEanCode(String eanCode) {
        this.eanCode = eanCode;
        return this;
    }
    public PuzzleBuilder withNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
        return this;
    }
    public PuzzleBuilder withPuzzleBrand(String puzzleBrand) {
        this.puzzleBrand = puzzleBrand;
        return this;
    }
    public PuzzleBuilder withWidth(double width) {
        this.width = width;
        return this;
    }
    public PuzzleBuilder withHeight(double height) {
        this.height = height;
        return this;
    }
    public PuzzleBuilder withReserved(boolean reserved) {
        this.reserved = reserved;
        return this;
    }
    public PuzzleBuilder withTag1(String tag1) {
        this.tag1 = tag1;
        return this;
    }
    public PuzzleBuilder withTag2(String tag2) {
        this.tag2 = tag2;
        return this;
    }
    public PuzzleBuilder withTag3(String tag3) {
        this.tag3 = tag3;
        return this;
    }
    public PuzzleBuilder withImage(File image) {
        this.image = image;
        return this;
    }
    public PuzzleBuilder withOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Puzzle build() {
        if (title.equals("")) {
            throw new EmptyFieldException();
        } else if (eanCode.equals("")) {
            throw new EmptyFieldException();
        }
        return new Puzzle(title, eanCode, numberOfPieces, puzzleBrand, width, height, reserved, tag1, tag2, tag3);
    }
}
