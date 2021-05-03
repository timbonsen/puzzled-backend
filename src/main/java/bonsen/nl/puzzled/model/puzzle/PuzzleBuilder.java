package bonsen.nl.puzzled.model.puzzle;

import bonsen.nl.puzzled.exceptions.AtLeastOneTagException;
import bonsen.nl.puzzled.exceptions.EmptyFieldException;
import bonsen.nl.puzzled.model.puzzleTags.PuzzleTags;
import bonsen.nl.puzzled.model.user.User;

public class PuzzleBuilder {

    private String title;
    private String eanCode;
    private int numberOfPieces;
    private String puzzleBrand;
    private double width;
    private double height;
    private boolean reserved;
    private PuzzleTags puzzleTags;
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
    public PuzzleBuilder withTags(PuzzleTags puzzleTags) {
        this.puzzleTags = puzzleTags;
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
        } else if (puzzleTags.equals(null)) {
            throw new AtLeastOneTagException();
        }
        return new Puzzle(title, eanCode, numberOfPieces, puzzleBrand, width, height, reserved, owner);
    }
}
