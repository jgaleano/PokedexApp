package test.julio.pokedex.PokemonWS;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Julio on 28/02/16.
 */
public class PokemonRestClient {
    public static final String BASE_URL = "http://pokeapi.co";
    private static final String BASE_DATA_URL = BASE_URL + "/api/v1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_DATA_URL + relativeUrl;
    }
}
