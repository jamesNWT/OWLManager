package simulation;

public class Simulate2CPGame {

    private TeamIn2CPGame team1 = new TeamIn2CPGame();
    private TeamIn2CPGame team2 = new TeamIn2CPGame();

    private int clockTime = 240;

    private int pointACaptureProgress;
    private int pointBCaptureProgress;

    public void playGame() {

        boolean gameOver = false;

        TeamIn2CPGame attackers = team1;
        TeamIn2CPGame defenders = team2;

        while (!gameOver) {
            // Set up for a round
            TeamIn2CPGame temp = attackers;
            attackers = defenders;
            defenders = temp;

            //Play the round
            while (attackers.getTime() > 0 && pointBCaptureProgress < 100) {

                if (pointACaptureProgress < 100) {
                    int result = attackPointA(attackers, defenders);

                    if (result > 0) {
                        pointACaptureProgress = 100;
                        attackers.incrementScore();
                    }
                } else {
                    // attack point B
                }
            }
            // Check for a winner
            if (defenders.getTime() <= 0 && attackers.getScore() > defenders.getScore()) {
                gameOver = true;
                System.out.println(attackers.getName() + " wins by a score of " + attackers.getScore() + " to " +
                        defenders.getScore());
            } else if (defenders.getScore() > attackers.getScore()) {
                gameOver = true;
                System.out.println(defenders.getName() + " wins by a score of " + defenders.getScore() + " to " +
                        attackers.getScore());
            }
        }
    }

    public int attackPointA(TeamIn2CPGame attackers, TeamIn2CPGame defenders) {
        // The more positive this number is the more heavily the attackers won the fight.
        int result = attackers.getTempRating() + RNG.normallyDistributedOneToOneHundred()
                - (defenders.getTempRating() + RNG.normallyDistributedOneToOneHundred());

        return result;
    }

    // The bigger the result the more decisively it was won, so less time is taken
    public int fightTime(int result) {
        return 0;
    }

}
