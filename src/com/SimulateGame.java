package com;

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
	
	public void simulateTeamFight(AttackingTeam attackers, DefendingTeam defenders) {
		
		
		skirmishPhase(attackers, defenders);
		
		fightPhase(attackers, defenders);
		
	}

	private void fightPhase(AttackingTeam attackers, DefendingTeam defenders) {
	}

	private void skirmishPhase(Team attackers, Team defenders) {
		
	}

}
