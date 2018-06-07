package me.debjyotiguha.popularmovies.utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.debjyotiguha.popularmovies.data.Movie;


public final class MoviesJsonUtils {

    private static final String TAG = MoviesJsonUtils.class.getName();

    public static Movie[] getMoviesFromJson(String moviesJsonStr)
            throws JSONException {

        JSONObject moviesJson = new JSONObject(moviesJsonStr);
        JSONArray resultsArray = moviesJson.getJSONArray("results");
        Movie[] movies = new Movie[resultsArray.length()];
        for (int i = 0; i < resultsArray.length(); i++) {

            JSONObject movieJson = resultsArray.getJSONObject(i);
            movies[i] = new Movie(
                    movieJson.getString("title"),
                    movieJson.getString("poster_path"),
                    movieJson.getString("overview"),
                    movieJson.getDouble("vote_average"),
                    movieJson.getString("release_date"));

            Log.d(TAG, movies[i].toString());
        }

        return movies;
    }

}
