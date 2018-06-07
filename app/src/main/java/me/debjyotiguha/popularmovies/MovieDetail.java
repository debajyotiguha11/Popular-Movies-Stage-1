package me.debjyotiguha.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import me.debjyotiguha.popularmovies.data.Movie;
import me.debjyotiguha.popularmovies.utilities.NetworkUtils;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mTitleTextView = (TextView) findViewById(R.id.tv_movie_title);
        TextView mYearTextView = (TextView) findViewById(R.id.tv_year);
        TextView mRatingTextView = (TextView) findViewById(R.id.tv_rating);
        TextView mSynopsisTextView = (TextView) findViewById(R.id.tv_synopsis);
        ImageView mPosterImageView = (ImageView) findViewById(R.id.iv_poster);


        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra(Movie.class.toString());

        mTitleTextView.setText(movie.getTitle());
        String year = movie.getReleaseDate().substring(0,
                movie.getReleaseDate().lastIndexOf("-"));
        mYearTextView.setText(year);
        String rating = movie.getRating() + "/10";
        mRatingTextView.setText(rating);
        mSynopsisTextView.setText(movie.getSynopsis());
        setTitle(movie.getTitle());

        String posterUrl = NetworkUtils.POSTER_URL_BASE + NetworkUtils.POSTER_SIZE_PATH_URL +
                movie.getPosterUrl();

        NetworkUtils.setImage(this, posterUrl, mPosterImageView);

    }
}
