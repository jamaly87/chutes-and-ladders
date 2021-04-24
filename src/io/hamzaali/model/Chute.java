package io.hamzaali.model;
/**
 * Class representing the Chute Object
 * Contains normal getter methods
 * Prepared by: Hamza Ali
 */
public class Chute {
    //start position of a chute
    private int start;
    //end position of a chute
    private int end;

    public Chute(int start, int end) {
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
