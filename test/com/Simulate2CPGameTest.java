package com;

import org.junit.jupiter.api.Test;
import simulation.Simulate2CPGame;
import simulation.TeamIn2CPGame;

public class Simulate2CPGameTest {

    @Test
    public void playGameTest() {
        Simulate2CPGame instance = new Simulate2CPGame();
        TeamIn2CPGame team1 = new TeamIn2CPGame();
        team1.setTempRating(83);
        team1.setName("Team South Korea");

        TeamIn2CPGame team2 = new TeamIn2CPGame();
        team2.setTempRating(80);
        team2.setName("Team USA");

        instance.playGame(team1, team2);
    }

    @Test
    public void attackPointATest() {

        final int NUM_ITERATIONS = 10000;

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
        int [] attArray = new int [NUM_ITERATIONS];
        int [] defArray = new int [NUM_ITERATIONS];
        int [] overallArray = new int [NUM_ITERATIONS];

        for(int i = 0; i < NUM_ITERATIONS; i++) {

            int result = instance.teamFightResult(attackers, defenders);

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
        double attAvg = attAgg/(double)attCount;
        double attSumOfSquareDiffs = 0;
        for (int j = 0; j < attCount; j++) {
            attSumOfSquareDiffs += Math.pow((attArray[j] - attAvg), 2);
        }
        double attSD = Math.pow((attSumOfSquareDiffs/attCount), 0.5);

        double defAvg = defAgg/(double)defCount;
        double defSumOfSquareDiffs = 0;
        for (int j = 0; j < defCount; j++) {
            defSumOfSquareDiffs += Math.pow((defArray[j] - defAvg), 2);
        }
        double defSD = Math.pow((defSumOfSquareDiffs/defCount), 0.5);

        double overallSumOfSquareDiffs = 0;
        double overallAvg = overallAgg/(double)NUM_ITERATIONS;
        for(int i = 0; i < NUM_ITERATIONS; i++) {
            overallSumOfSquareDiffs += Math.pow((overallArray[i] - overallAvg), 2);
        }
        double overallSD = Math.pow((overallSumOfSquareDiffs/NUM_ITERATIONS), 0.5);

        System.out.println("attackers won: " + attCount + " avg result: " + attAvg + " deviation: " + attSD);
        System.out.println("defenders won: " + defCount + " avg result: " + defAvg + " deviation: " + defSD);
        System.out.println("Overall average result: "+ overallAvg + " Overall deviation: " + overallSD);
    }
}
