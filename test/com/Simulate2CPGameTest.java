package com;

import org.junit.jupiter.api.Test;
import simulation.Simulate2CPGame;
import simulation.TeamIn2CPGame;

public class Simulate2CPGameTest {

    @Test
    public void attackPointATest() {

        Simulate2CPGame instance = new Simulate2CPGame();
        TeamIn2CPGame attackers = new TeamIn2CPGame();
        attackers.setTempRating(85);

        TeamIn2CPGame defenders = new TeamIn2CPGame();
        defenders.setTempRating(80);

        int attCount = 0;
        int defCount = 0;
        int defAgg = 0;
        int attAgg = 0;
        int overallAgg= 0;
        int [] attArray = new int [1000];
        int [] defArray = new int [1000];
        int [] overallArray = new int [1000];

        for(int i = 0; i < 1000; i++) {

            int result = instance.attackPointA(attackers, defenders);
            System.out.println(result);

            overallArray[i] = result;
            overallAgg += result;

            if (result < 0) {
                defArray[defCount] = result;
                defCount++;
                defAgg += result;
            } else {
                attArray[attCount] = result;
                attCount++;
                attAgg += result;
            }
        }

        // --calculate the standard deviations--
        double attAvg = attAgg/attCount;
        double attSumOfSquareDiffs = 0;
        for (int j = 0; j < attCount; j++) {
            attSumOfSquareDiffs += Math.pow((attArray[j] - attAvg), 2);
        }
        double attSD = Math.pow((attSumOfSquareDiffs/attCount), 0.5);

        double defAvg = defAgg/defCount;
        double defSumOfSquareDiffs = 0;
        for (int j = 0; j < defCount; j++) {
            defSumOfSquareDiffs += Math.pow((defArray[j] - defAvg), 2);
        }
        double defSD = Math.pow((defSumOfSquareDiffs/defCount), 0.5);

        double overallSumOfSquareDiffs = 0;
        double overallAvg = overallAgg/1000;
        for(int i = 0; i < 1000; i++) {
            overallSumOfSquareDiffs += Math.pow((overallArray[i] - overallAvg), 2);
        }
        double overallSD = Math.pow((overallSumOfSquareDiffs/1000), 0.5);

        System.out.println("attackers won: " + attCount + " avg result: " + attAvg + " deviation: " + attSD);
        System.out.println("defenders won: " + defCount + " avg result: " + defAvg + " deviation: " + defSD);
        System.out.println("Overall average result: "+ overallAvg + " Overall deviation: " + overallSD);
    }
}
