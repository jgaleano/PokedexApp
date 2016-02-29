package test.julio.pokedex.PokemonList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import test.julio.pokedex.PokemonObjects.Pokemon;
import test.julio.pokedex.PokemonWS.PokemonCallServices;
import test.julio.pokedex.PokemonWS.PokemonRestClient;
import test.julio.pokedex.R;

/**
 * Created by Julio on 28/02/16.
 */
public class DetailActivity extends AppCompatActivity {

    public static String INTENT_EXTRA_POKEMON_OBJECT = "detailObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Pokemon pokemonObj = (Pokemon) getIntent().getExtras().getSerializable(INTENT_EXTRA_POKEMON_OBJECT);
        ((TextView)findViewById(R.id.nameTxt)).setText(pokemonObj.getName());
        ((TextView)findViewById(R.id.nationalIdTxt)).setText(pokemonObj.getNationalId());
        ((TextView)findViewById(R.id.maleFemaleRatioTxt)).setText(pokemonObj.getMaleFemaleRatio());

        ImageView pokemonImg = (ImageView) findViewById(R.id.pokemonImg);
        Picasso.with(getApplicationContext()).load(PokemonRestClient.BASE_URL + pokemonObj.getUrlImage()).into(pokemonImg);
    }
}
