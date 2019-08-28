package com;

public class Player {
	
	private String firstName;
	private String lastName;
	private String tag;
	private BaseSkills baseSkills;
	
	public Player(String tag, BaseSkills skills) {
		this.tag =  tag;
		this.baseSkills = skills;
	}

	public Player() {}

	public BaseSkills getBaseSkills() {
		return baseSkills;
	}
	
	public String getTag() {
		return tag;
	}

	public int avgAllPlayerStats() {
		return baseSkills.sumSkills() / baseSkills.getNumSkills();
	}

}
