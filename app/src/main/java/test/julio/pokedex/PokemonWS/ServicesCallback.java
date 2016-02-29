package test.julio.pokedex.PokemonWS;

import java.util.List;

import test.julio.pokedex.PokemonObjects.Pokemon;

/**
 * Created by Julio on 28/02/16.
 */
public interface ServicesCallback {

    public void onCompleteSuccess(List<Pokemon> pokemonList);
    public void onCompleteWithError(String error);
}
