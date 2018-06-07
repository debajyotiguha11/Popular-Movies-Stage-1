package me.debjyotiguha.popularmovies.data;

import java.io.Serializable;


public class Movie implements Serializable {

    private String mTitle;
    private String mPosterUrl;
    private String mSynopsis;
    private double mRating;
    private String mReleaseDate;

    public Movie(String title, String posterUrl, String sysnopsis,
                 double rating, String releaseDate) {
        setTitle(title);
        setPosterUrl(posterUrl);
        setSynopsis(sysnopsis);
        setRating(rating);
        setReleaseDate(releaseDate);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    private void setPosterUrl(String posterUrl) {
        this.mPosterUrl = posterUrl;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    private void setSynopsis(String synopsis) {
        this.mSynopsis = synopsis;
    }

    public double getRating() {
        return mRating;
    }

    private void setRating(double rating) {
        this.mRating = rating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    private void setReleaseDate(String releaseDate) {
        this.mReleaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie:{title:" + getTitle() +
                ",posterUrl:" + getPosterUrl() +
                ",synopsis:" + getSynopsis() +
                ",rating:" + getRating() +
                ",releaseDate:" + getReleaseDate() +
                "}";
    }
}
