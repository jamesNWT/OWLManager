package simulation;

import java.util.Random;

public class Dice {

    /**
     * returns a random int from 1 to 100
     * @return
     */
    public static int rollOneToHundred() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }
}
