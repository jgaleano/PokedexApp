package test.julio.pokedex.PokemonList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.paging.listview.PagingBaseAdapter;

import java.util.List;

import test.julio.pokedex.PokemonObjects.Pokemon;
import test.julio.pokedex.R;

/**
 * Created by Julio on 28/02/16.
 */
public class PokemonArrayAdapter extends PagingBaseAdapter<Pokemon> {

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Pokemon getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.pokemon_item_list, parent, false);
        }
        TextView pokemonTextView = (TextView) convertView.findViewById(R.id.pokemonNameTxt);

        pokemonTextView.setText(getItem(position).getName());
        return convertView;
    }

}
