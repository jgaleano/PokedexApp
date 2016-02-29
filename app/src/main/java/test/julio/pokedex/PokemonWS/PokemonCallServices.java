package test.julio.pokedex.PokemonWS;

import android.util.Log;

import com.loopj.android.http.*;
import org.json.*;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import test.julio.pokedex.PokemonObjects.Pokemon;

/**
 * Created by Julio on 28/02/16.
 */
public class PokemonCallServices {

    private List<Pokemon> pokemonList;
    private ServicesCallback callback;

    public PokemonCallServices(ServicesCallback callback) {
        this.callback = callback;
    }

    public void getAllPokemon(int offset) throws JSONException {
        PokemonRestClient.get("pokemon/?limit=10&&offset="+offset, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                pokemonList = new ArrayList<>();
                try {
                    JSONArray jsonArray = response.getJSONArray("objects");
                    for(int i=0; i < jsonArray.length(); i++) {
                        JSONObject pokemonJsonObj = jsonArray.getJSONObject(i);
                        Pokemon pokemonObj = new Pokemon();
                        pokemonObj.setName(pokemonJsonObj.getString("name"));
                        pokemonObj.setNationalId(pokemonJsonObj.getString("national_id"));
                        pokemonObj.setMaleFemaleRatio(pokemonJsonObj.getString("male_female_ratio"));
                        pokemonObj.setUrlImage(pokemonJsonObj.getString("resource_uri").replace("/","").replace("apiv1pokemon", "/media/img/")+".png");
                        pokemonList.add(pokemonObj);
                    }
                    callback.onCompleteSuccess(pokemonList);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                callback.onCompleteWithError(responseString);
            }
        });
    }
}
