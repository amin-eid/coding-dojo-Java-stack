package com.codingdojo.objectmaster1;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human person1= new Human();
		Human person2= new Human();
		person1.attack(person2);
		person1.attack(person2);
		person1.attack(person2);
		System.out.println(person1.health);
		System.out.println(person2.health);
	}

}
