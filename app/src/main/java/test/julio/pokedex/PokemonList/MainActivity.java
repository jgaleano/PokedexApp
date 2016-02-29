package test.julio.pokedex.PokemonList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.paging.listview.PagingListView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import test.julio.pokedex.PokemonObjects.Pokemon;
import test.julio.pokedex.PokemonWS.PokemonCallServices;
import test.julio.pokedex.PokemonWS.ServicesCallback;
import test.julio.pokedex.R;

public class MainActivity extends AppCompatActivity implements ServicesCallback, AdapterView.OnItemClickListener, PagingListView.Pagingable {

    private PokemonArrayAdapter arrayAdapter;
    private PagingListView pokemonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonListView = (PagingListView) findViewById(R.id.pokemonListView);
        pokemonListView.setHasMoreItems(true);
        arrayAdapter = new PokemonArrayAdapter();
        pokemonListView.setAdapter(arrayAdapter);
        pokemonListView.setPagingableListener(this);

        pokemonListView.setOnItemClickListener(this);

        callService();
    }

    private void callService() {
        PokemonCallServices callServices = new PokemonCallServices(this);
        try {
            callServices.getAllPokemon(arrayAdapter.getCount()+1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    //ServicesCallback methods
    @Override
    public void onCompleteSuccess(List<Pokemon> pokemonList) {
        pokemonListView.onFinishLoading(true, pokemonList);
    }

    @Override
    public void onCompleteWithError(String error) {

    }

    //OnItemClickListener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_EXTRA_POKEMON_OBJECT, arrayAdapter.getItem(position));
        startActivity(intent);
    }

    //Pagination List Listener
    @Override
    public void onLoadMoreItems() {
        callService();
    }
}
