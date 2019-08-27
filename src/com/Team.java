package com;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;

    private int cohesionRating;
    private int tactics;

    private PlayerInGame[] players = new PlayerInGame[6];

    public Team(){};

    public void setPlayers( PlayerInGame[] players) {
        this.players = players;
    }

    public int getTactics() {
        return tactics;
    }

    public void setTactics(int tactics) {
        this.tactics = tactics;
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
}
