package bonsen.nl.puzzled.model.tags;

import bonsen.nl.puzzled.exceptions.AtLeastOneTagException;
import bonsen.nl.puzzled.model.puzzle.Puzzle;

public class TagsBuilder {

    private String tag1;
    private String tag2;
    private String tag3;
    private Puzzle puzzle;

    public TagsBuilder() {

    }

    public TagsBuilder withTag1(String tag1) {
        this.tag1 = tag1;
        return this;
    }
    public TagsBuilder withTag2(String tag2) {
        this.tag2 = tag2;
        return this;
    }
    public TagsBuilder withTag3(String tag3) {
        this.tag3 = tag3;
        return this;
    }
    public TagsBuilder withPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
        return this;
    }

    public Tags build() {
        if (tag1.equals("")) {
            throw new AtLeastOneTagException();
        }
        return new Tags(tag1, tag2, tag3, puzzle);
    }
}
