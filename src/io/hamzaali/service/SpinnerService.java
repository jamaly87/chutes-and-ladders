package io.hamzaali.service;

import java.util.Random;

/**
 * Spinner service class which reflects the number of steps each player take in their turn.
 * The Number of steps is randomly generated within the range of 1-6
 * Prepared by: Hamza Ali
 */
public class SpinnerService {

    public static int spin(){
        //generated values range from 0 to 5
        int generatedValue = new Random().nextInt(6);
        return (generatedValue==0?1:generatedValue+1);
    }
}
