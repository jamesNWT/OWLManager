package com;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;

    private int cohesionRating;
    private int tacticsRating;

    public int getTempRating() {
        return tempRating;
    }

    public void setTempRating(int tempRating) {
        this.tempRating = tempRating;
    }

    private int tempRating;

    private PlayerInGame[] players = new PlayerInGame[6];

    public Team(){}

    public Team(int tempRating) {
        this.tempRating = tempRating;
    }

    public void setPlayers( PlayerInGame[] players) {
        this.players = players;
    }

    public int getTactics() {
        return tacticsRating;
    }

    public void setTactics(int tactics) {
        this.tacticsRating = tactics;
    }

    public int getCohesionRating() {
        return cohesionRating;
    }

    public void setCohesionRating(int cohesionRating) {
        this.cohesionRating = cohesionRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int avgAllTeamStats() {
        int result = 0;
        for (PlayerInGame player : players) {
            result += player.avgAllPlayerStats();
        }
        result += ((cohesionRating + tacticsRating) / 2);
        return result;
    }
}
