package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimulateGameTest {
	
	@Test
	public void simulate1v1Test_player1Stronger() {
		System.out.println("1v1 test player1 stronger");
		Player xqc = new Player("xQc", new BaseSkills(95, 90, 88, 75));
		Player jns = new Player("jNS", new BaseSkills(55, 55, 55, 55));
		
		SimulateGame instance = new SimulateGame();
		Player winner = instance.get1v1Winner(xqc, jns);
		
		assertEquals("xqc should win the 1v1", winner, xqc);
	}
	
	@Test
	public void simulate_1v1Test_Player2Stronger() {
		System.out.println("1v1 test player1 weaker");
		Player xqc = new Player("xQc", new BaseSkills(95, 90, 88, 75));
		Player jns = new Player("jNS", new BaseSkills(55, 55, 55, 55));
		
		SimulateGame instance = new SimulateGame();
		Player winner = instance.get1v1Winner(jns, xqc);
		
		assertEquals("xqc should win the 1v1", winner, xqc);
	}
	
}
