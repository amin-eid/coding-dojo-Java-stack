package com.codingdojo.pokemon2;

public class Pokemon {

	private String name="";
	int health=100;
	private String type="";
	private static int count=0;


	
	public Pokemon() {
		count++;
	}
	
	

	public Pokemon(String name, int health, String type) {
		super();
		setName(name);
		setType(type);
		setHealth(health);
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Pokemon.count = count;
	}
	public void attackPokemon(Pokemon pokemon) {
		pokemon.health-=10;
	}

	
	
}
