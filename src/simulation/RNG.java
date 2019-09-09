package simulation;

import java.util.Random;

public class RNG {

    /**
     * returns a random int from 1 to 100
     * @return
     */
    public static int rollOneToHundred() {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt(100) + 1;
    }

    public static int normallyDistributedOneToOneHundred(){
        java.util.Random rand = new java.util.Random();

        Double rgn =  (rand.nextGaussian()*20)+50.5;
        int rgnInt = rgn.intValue();

        if (rgnInt > 100) {rgnInt = 100;} else if (rgnInt < 0) {rgnInt = 0;}

        return rgnInt;

    }
}
