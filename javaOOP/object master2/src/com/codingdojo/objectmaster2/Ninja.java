package com.codingdojo.objectmaster2;

public class Ninja extends Human {
	int stealth=3;
	
public void steal(Human x) {
	x.health-=this.stealth;
	this.health+=this.health;
}
public void runAway() {
	this.health-=10;
}
}
