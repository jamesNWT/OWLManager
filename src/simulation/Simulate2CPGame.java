package simulation;

import java.util.Random;

public class Simulate2CPGame {

    private TeamIn2CPGame team1 = new TeamIn2CPGame();
    private TeamIn2CPGame team2 = new TeamIn2CPGame();


    private double pointACaptureProgress;
    private double pointBCaptureProgress;

    int roundNumber = 0;

    public void playGame(TeamIn2CPGame team1, TeamIn2CPGame team2) {

        boolean gameOver = false;

        TeamIn2CPGame attackers = team1;
        TeamIn2CPGame defenders = team2;
        double pointBThresholdToCapture = 100;

        while (!gameOver) {

            roundNumber++;
            System.out.println("Round " + roundNumber + ": " + attackers.getName() + " is attacking with " + clockTimeMinutesSeconds(attackers.getTime()));

            //Play the round
            while (attackers.getTime() > 0 && pointBCaptureProgress < pointBThresholdToCapture) {

                if (pointACaptureProgress < 100) {

                    int result = teamFightResult(attackers, defenders);
                    int timeTaken = fightTime(result);

                    attackers.setTime(attackers.getTime() - timeTaken);

                    if (result > 0) {
                        pointACaptureProgress = 100;
                        attackers.incrementScore();
                        if (attackers.getTime() > 0) {
                            System.out.println(attackers.getName() + " captured point A with "
                                    + clockTimeMinutesSeconds(attackers.getTime()) + " time left.");
                            attackers.setTime(attackers.getTime() + 180);
                        } else {
                            System.out.println(attackers.getName() + " captured point A in overtime!");
                            attackers.setTime(180);
                        }
                        if (attackers.getScore() > defenders.getScore() && roundNumber%2 == 0) {
                            break;
                        }
                    }
                } else {

                    int result = teamFightResult(attackers, defenders) - 5; // 5 bonus for defending point B
                    int timeTaken = fightTime(result);
                    attackers.setTime(attackers.getTime() - timeTaken);
                    pointBCaptureProgress = calculatePointBCaptureProgress(result, pointBCaptureProgress);

                    if (pointBCaptureProgress > attackers.getMaxPointBCaptureProgress()) {
                        attackers.setMaxPointBCaptureProgress(pointBCaptureProgress);
                    }

                    if(pointBCaptureProgress >= pointBThresholdToCapture && attackers.getTime() > 0) {

                        attackers.incrementScore();
                        System.out.println(attackers.getName() + " captured point B with "
                                + clockTimeMinutesSeconds(attackers.getTime()) + " left");
                    } else if (pointBCaptureProgress >= pointBThresholdToCapture && attackers.getTime() <= 0) {

                        attackers.incrementScore();
                        System.out.println(attackers.getName() + " captured point B in overtime!");
                        attackers.setTime(0);
                    } else if (pointBCaptureProgress < pointBThresholdToCapture) {

                        if (pointBCaptureProgress > 66.7) {

                            pointBCaptureProgress = 66.7;
                        } else if (pointBCaptureProgress > 33.3) {

                            pointBCaptureProgress = 33.3;
                        } else {
                            pointBCaptureProgress = 0;
                        }
                    }

                }
            }
            if (attackers.getTime() < 0) {
                attackers.setTime(0);
            }
            System.out.println("----- Score: " + team1.getScore() + " / " +team2.getScore() + " ----");

            // Check for a winner
            if (roundNumber%2 == 0 && attackers.getScore() > defenders.getScore()) {
                gameOver = true;
                System.out.println(attackers.getName() + " wins by a score of " + attackers.getScore() + " to " +
                        defenders.getScore());
            } else if (defenders.getScore() > attackers.getScore()) {
                gameOver = true;
                System.out.println(defenders.getName() + " wins by a score of " + defenders.getScore() + " to " +
                        attackers.getScore());
            } else if ( roundNumber%2 == 0
                    && attackers.getScore() == defenders.getScore()
                    && isExtraRounds()
                    && attackers.getMaxPointBCaptureProgress() < pointBThresholdToCapture
                    && pointBThresholdToCapture > 33.3)
            {
                System.out.println(attackers.getName() + " needed to capture " + pointBThresholdToCapture
                        + "% of point B, but only captured " + attackers.getMaxPointBCaptureProgress() + "%!");
                gameOver = true;
                defenders.incrementScore();
                System.out.println(defenders.getName() + " wins by a score of " + defenders.getScore() + " to " +
                        attackers.getScore());
            }

            // Set up next round
            if(pointBCaptureProgress < 100) {
                pointBThresholdToCapture = attackers.maxPointBCaptureProgress;
            }

            if((attackers.getTime() < 60 || defenders.getTime() < 60) && (attackers.getScore() == defenders.getScore())) {
                if (attackers.getTime() < defenders.getTime()) {
                    int timeToAdd = 60 - attackers.getTime();
                    attackers.setTime(60);
                    defenders.setTime(defenders.getTime() + timeToAdd);
                } else {
                    int timeToAdd = 60 - defenders.getTime();
                    defenders.setTime(60);
                    attackers.setTime(attackers.getTime() + timeToAdd);
                }
            }
            TeamIn2CPGame temp = attackers;
            attackers = defenders;
            defenders = temp;

            pointACaptureProgress = 0;
            pointBCaptureProgress = 0;

            attackers.setMaxPointBCaptureProgress(33.3);
            defenders.setMaxPointBCaptureProgress(33.3);
        }
    }

    private double calculatePointBCaptureProgress(int result, double pointBCaptureProgress) {

        Random rand = new Random();
        int percentToAdd;

        if (result < 0) {
           percentToAdd = rand.nextInt(32);
        } else {
            percentToAdd = rand.nextInt(67) + 67;
        }

        if (percentToAdd < 0) percentToAdd = 0;

        if (pointBCaptureProgress + percentToAdd >= 100.0) {
            return 100;
        }

        return percentToAdd + pointBCaptureProgress;

    }

    public int teamFightResult(TeamIn2CPGame attackers, TeamIn2CPGame defenders) {
        // The more positive this number is the more heavily the attackers won the fight.
        int result = attackers.getTempRating() + RNG.normallyDistributedOneToOneHundred()
                - (defenders.getTempRating() + RNG.normallyDistributedOneToOneHundred());

        // If the the attackers only have less than 15 seconds for their last fight they're at a disadvantage
        if (attackers.getTime() < 15) {
            result -= 40;
        }

        if (result == 0) result -= 1; //protect against tied fights, favor defenders

        return result;
    }

    // The bigger the result the more decisively it was won, so less time is taken
    public int fightTime(int result) {
        java.util.Random rand = new java.util.Random();

        if (result < 0) result *= -1;

        double dub = 110 - result*(rand.nextDouble()*2);

        if (dub < 20.0) dub = 20.0;

        return ((int) dub);
    }

    public String clockTimeMinutesSeconds(int clockTime) {
         int minutes = clockTime/60;
         int seconds = clockTime%60;
         return minutes + ":" + seconds;
    }

    private boolean isExtraRounds() {
        return roundNumber > 2;
    }

}
