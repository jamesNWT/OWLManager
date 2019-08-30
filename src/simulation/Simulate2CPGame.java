package simulation;

public class Simulate2CPGame {

    private TeamIn2CPGame team1 = new TeamIn2CPGame();
    private TeamIn2CPGame team2 = new TeamIn2CPGame();

    private int team1Score = 0;
    private int team2Score = 0;

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
                    // attack point A
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

}
