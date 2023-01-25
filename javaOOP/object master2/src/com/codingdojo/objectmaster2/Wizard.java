package com.codingdojo.objectmaster2;

public class Wizard extends Human {
	int intelligence=8;
	int health=50;
	public void heal(Human x) {
		x.health+=this.intelligence;
		
	}
	public void fireball(Human x) {
		x.health-=this.intelligence*3;
	}
}
