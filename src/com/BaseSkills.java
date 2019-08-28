package com;

import java.awt.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class BaseSkills {

	private int mechanics;
	private int gameSense;
	private int positioning;
	private int communication;

	public BaseSkills(int mech, int sense, int pos, int com) {
		mechanics = mech;
		gameSense = sense;
		positioning = pos;
		communication = com;
	}

	public int sumSkills() {
		return mechanics + gameSense + positioning + communication;
	}

	public int getMechanics() {
		return mechanics;
	}

	public void setMechanics(int mechanics) {
		this.mechanics = mechanics;
	}

	public int getGameSense() {
		return gameSense;
	}

	public void setGameSense(int gameSense) {
		this.gameSense = gameSense;
	}

	public int getPositioning() {
		return positioning;
	}

	public void setPositioning(int positioning) {
		this.positioning = positioning;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getNumSkills() {
		return 4; //TODO find a better way of doing this type of thing
	}
}
