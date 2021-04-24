package io.hamzaali.model;
/**
 * Class representing the Ladder Object
 * Contains normal getter methods
 * Prepared by: Hamza Ali
 */
public class Ladder {
    //start position of a ladder
    private int start;
    //end position of a ladder
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
