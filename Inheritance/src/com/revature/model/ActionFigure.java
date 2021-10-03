package com.revature.model;

public class ActionFigure extends Doll {
	
	private String skill;
	
	public ActionFigure() {
		this.name     = "Bennet";
		this.eyeColor = "Blue";
		this.skill    = "Healer";
	}
	
	public ActionFigure(String name, String eyeColor, String skill) {
		this.name     = name;
		this.eyeColor = eyeColor;
		this.skill    = skill;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public void useSkill() {
		System.out.println("Ka Pow! I'm using my skill, " + this.skill);
	}

}
