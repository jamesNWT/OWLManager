package com;

public class SimulateGame {
	
	public Player get1v1Winner(Player player1, Player player2) {
		if (player1.getBaseSkills().sumSkills() > player2.getBaseSkills().sumSkills()) {
			return player1;
		} else {
			return player2;
		}
	}

}
