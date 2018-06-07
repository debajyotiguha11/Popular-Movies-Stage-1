package me.debjyotiguha.popularmovies.utilities;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    //TODO : Add a API Key here in order to get this class working
    private static final String API_KEY = "";

    private static final String MOVIE_BASE_URL = "https://api.themoviedb.org";
    private static final String MOVIE_PATH_URL = "/3/movie";
    private static final String MOVIE_PATH_POPULAR = "/popular";
    private static final String MOVIE_PATH_TOP_RATED = "/top_rated";
    private static final String PARAM_API_KEY = "api_key";

    public static final int SORT_BY_POPULARITY = 0;
    public static final int SORT_BY_RATING = 1;
    public static final String POSTER_URL_BASE = "http://image.tmdb.org/t/p/";
    public static final String POSTER_SIZE_PATH_URL = "w185";

    public static URL buildUrl(int sortBy) {

        String urlChoosed = MOVIE_BASE_URL + MOVIE_PATH_URL;

        switch (sortBy) {
            case SORT_BY_RATING:
                urlChoosed += MOVIE_PATH_TOP_RATED;
                break;

            case SORT_BY_POPULARITY:
            default:
                urlChoosed += MOVIE_PATH_POPULAR;
                break;
        }

        Uri builtUri = Uri.parse(urlChoosed).buildUpon()
                .appendQueryParameter(PARAM_API_KEY, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "Built URL: " + url);

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static void setImage(Context context, String posterUrl, ImageView imageView){
        Picasso.with(context).setLoggingEnabled(true);
        Log.d(context.toString(), "try load a image using Picasso");
        Picasso.with(context).load(posterUrl).into(imageView);
    }

}
