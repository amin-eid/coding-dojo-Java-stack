package com.codingdojo.objectmaster2;

public class Samurai extends Human{
	int health=200;
	
	static int count=0;
	public Samurai() {
		count++;
	}
	public void deathBlow(Human x) {
		x.health=0;
		this.health/=2;
		
	}
	public void meditate() {
		this.health+=0.5*this.health;
	}

	public static int howMany() {
		return count;
	}
}
