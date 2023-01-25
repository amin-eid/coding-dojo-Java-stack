package com.codingdojo.pokemon2;

public abstract class AbstractPokemon implements PokemonInterface {
    // your code here
	@Override
		public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pkmn=new Pokemon();
		pkmn.setName(name);
		pkmn.setHealth(health);
		pkmn.setType(type);
		return pkmn;
		}
	
	public String pokemonInfo(Pokemon pokemon) {
	
	return "Name: "+pokemon.getName()+" Health: "+pokemon.getHealth()+" Type: "+pokemon.getType();
	}
	

	
}


