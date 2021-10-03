package com.revature.model;

public class Doll extends Toy{
	String eyeColor;
	
	public Doll() {
		super("Albedo");
		this.eyeColor = "blue";		
	}
	
	public Doll(String name, String eyeColor) {
		super(name);
		this.eyeColor = eyeColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
	public void makeTalk() {
		System.out.println("Hi everyone! I AM-A doll");
	}

}
