package bonsen.nl.puzzled.model.puzzleTags;

import bonsen.nl.puzzled.exceptions.AtLeastOneTagException;
import bonsen.nl.puzzled.model.puzzle.Puzzle;

public class PuzzleTagsBuilder {

    private String tag1;
    private String tag2;
    private String tag3;
    private Puzzle puzzle;

    public PuzzleTagsBuilder() {

    }

    public PuzzleTagsBuilder withTag1(String tag1) {
        this.tag1 = tag1;
        return this;
    }
    public PuzzleTagsBuilder withTag2(String tag2) {
        this.tag2 = tag2;
        return this;
    }
    public PuzzleTagsBuilder withTag3(String tag3) {
        this.tag3 = tag3;
        return this;
    }
    public PuzzleTagsBuilder withPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
        return this;
    }

    public PuzzleTags build() {
        if (tag1.equals("")) {
            throw new AtLeastOneTagException();
        }
        return new PuzzleTags(tag1, tag2, tag3, puzzle);
    }
}
