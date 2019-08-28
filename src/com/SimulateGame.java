package com;

import jdk.jfr.StackTrace;

public class SimulateGame {
	
	private Team team1;
	private Team team2;
	private GameClock gameClock;
	
	public Player get1v1Winner(Player player1, Player player2) {
		if (player1.getBaseSkills().sumSkills() > player2.getBaseSkills().sumSkills()) {
			return player1;
		} else {
			return player2;
		}
	}
	
	private void simulateTeamFight() {
		int team1roll = Dice.rollOneToHundred() + team1.avgAllTeamStats();
		int team2roll = Dice.rollOneToHundred() + team2.avgAllTeamStats();

	}

}
