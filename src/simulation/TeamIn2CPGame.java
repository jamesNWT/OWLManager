package simulation;

import com.Team;

public class TeamIn2CPGame extends Team {
    private int time = 4*60; // 4 minutes
    private int score = 0;

    public double getMaxPointBCaptureProgress() {
        return maxPointBCaptureProgress;
    }

    public void setMaxPointBCaptureProgress(double maxPointBCaptureProgress) {
        this.maxPointBCaptureProgress = maxPointBCaptureProgress;
    }

    public double maxPointBCaptureProgress = 33.3;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addTime(int timeToAdd) {
        this.time += timeToAdd;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score++;
    }
}
