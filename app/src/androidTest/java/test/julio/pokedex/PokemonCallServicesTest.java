package test.julio.pokedex;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import test.julio.pokedex.PokemonObjects.Pokemon;
import test.julio.pokedex.PokemonWS.PokemonCallServices;
import test.julio.pokedex.PokemonWS.ServicesCallback;

/**
 * Created by Julio on 28/02/16.
 */
public class PokemonCallServicesTest extends TestCase {

    private List<Pokemon> pokemons;

    @Test
    public void testCallServicePokemon() throws JSONException {
        PokemonCallServices pokemonCallServices = new PokemonCallServices(new ServicesCallback() {
            @Override
            public void onCompleteSuccess(List<Pokemon> pokemonList) {
                pokemons = pokemonList;
            }

            @Override
            public void onCompleteWithError(String error) {
            }
        });
        pokemonCallServices.getAllPokemon(0);

        Assert.assertNotNull(pokemons);
    }

    @Test
    public void testCallServicePokemonSameSize() throws JSONException {
        PokemonCallServices pokemonCallServices = new PokemonCallServices(new ServicesCallback() {
            @Override
            public void onCompleteSuccess(List<Pokemon> pokemonList) {
                pokemons = pokemonList;
            }

            @Override
            public void onCompleteWithError(String error) {
            }
        });

        pokemonCallServices.getAllPokemon(0);
        Assert.assertEquals(10, pokemons.size());
    }

    @Test
    public void testCallServicePokemonItemsNameNotEmptyOrNull() throws JSONException {
        PokemonCallServices pokemonCallServices = new PokemonCallServices(new ServicesCallback() {
            @Override
            public void onCompleteSuccess(List<Pokemon> pokemonList) {
                pokemons = pokemonList;
            }

            @Override
            public void onCompleteWithError(String error) {
            }
        });

        pokemonCallServices.getAllPokemon(0);

        for(Pokemon pokemon : pokemons) {
            Assert.assertNotNull(pokemon.getName());
            Assert.assertNotSame("", pokemon.getName());
        }
    }

    @Test
    public void testCallServicePokemonItemsImageValue() throws JSONException {
        PokemonCallServices pokemonCallServices = new PokemonCallServices(new ServicesCallback() {
            @Override
            public void onCompleteSuccess(List<Pokemon> pokemonList) {
                pokemons = pokemonList;
            }

            @Override
            public void onCompleteWithError(String error) {
            }
        });

        pokemonCallServices.getAllPokemon(0);

        for(Pokemon pokemon : pokemons) {
            Assert.assertNotNull(pokemon.getUrlImage());
            Assert.assertNotSame("", pokemon.getUrlImage());
        }
    }

}
