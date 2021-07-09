package com.qa.spring.golfers.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// We need to specify all the variables in this class
@Entity // This annotation marks this class as a table

public class Players {

//	Declare variables and mark Id as a primary key

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String playerName;
	private String homeCourse;
	private int majorsWon;
	private boolean legend;

//	add constructors

//	add empty constructor
	public Players() {
	}

//	add constructor not including id
	public Players(String playerName, String homeCourse, int majorsWon, boolean legend) {
		this.playerName = playerName;
		this.homeCourse = homeCourse;
		this.majorsWon = majorsWon;
		this.legend = legend;
	}

//	add constructor including Id
	public Players(Long id, String playerName, String homeCourse, int majorsWon, boolean legend) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.homeCourse = homeCourse;
		this.majorsWon = majorsWon;
		this.legend = legend;
	}

	// add Getters and Setters - ie add methods

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getHomeCourse() {
		return homeCourse;
	}

	public void setHomeCourse(String homeCourse) {
		this.homeCourse = homeCourse;
	}

	public int getMajorsWon() {
		return majorsWon;
	}

	public void setMajorsWon(int majorsWon) {
		this.majorsWon = majorsWon;
	}

	public boolean isLegend() {
		return legend;
	}

	public void setLegend(boolean legend) {
		this.legend = legend;
	}

}
