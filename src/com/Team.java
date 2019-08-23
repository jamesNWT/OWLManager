package com;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;

    private int spaceRating;
    private int scoutedInfoRating;
    private int positioningRating;

    private PlayerInGame[] players = new PlayerInGame[6];

    public Team(){};

    public void setPlayers( PlayerInGame[] players) {
        this.players = players;
    }
}
