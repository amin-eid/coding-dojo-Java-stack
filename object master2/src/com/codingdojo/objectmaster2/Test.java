package com.codingdojo.objectmaster2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ninja nnja1= new Ninja();
		Wizard wzd1= new Wizard();
		Samurai sm1= new Samurai();
		System.out.println(nnja1.health);
		nnja1.runAway();
		System.out.println(nnja1.health);
		sm1.deathBlow(nnja1);
		System.out.println(nnja1.health);
		System.out.println(sm1.health);
		
		Samurai sm2= new Samurai();
		System.out.println(Samurai.howMany());
		
	}

}
