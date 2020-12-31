package com.codingdojo.pokemon2;

public interface PokemonInterface {
		Pokemon createPokemon(String name, int health, String type);
		String pokemonInfo(Pokemon pokemon);
		void listPokemon();

	}