package me.debjyotiguha.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.debjyotiguha.popularmovies.data.Movie;
import me.debjyotiguha.popularmovies.utilities.NetworkUtils;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private GridItemClickListener mOnClickListener;
    private Movie[] mMovies;

    public Movie getMovie(int index){
        return mMovies[index];
    }

    MovieAdapter(GridItemClickListener listener) {
        mOnClickListener = listener;
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        int layoutIdForGridItem = R.layout.movie_grid_item;

        View view = inflater.inflate(layoutIdForGridItem, parent, false);

        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder holder, int position) {

        String posterUrl = NetworkUtils.POSTER_URL_BASE + NetworkUtils.POSTER_SIZE_PATH_URL +
                mMovies[position].getPosterUrl();

        holder.bind(posterUrl);
    }

    @Override
    public int getItemCount() {
        if (mMovies != null)
            return mMovies.length;
        else
            return 0;
    }

    public void setMoviesData(Movie[] movies) {
        mMovies = movies;
        notifyDataSetChanged();
    }

    public interface GridItemClickListener {
        void onGridItemClick(int clickedItemIndex);
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mMoviePoster;
        Context context;

        MovieAdapterViewHolder(View itemView) {
            super(itemView);

            mMoviePoster = (ImageView) itemView.findViewById(R.id.iv_poster);
            context = itemView.getContext();
            itemView.setOnClickListener(this);//set the OnclickListener event
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onGridItemClick(clickedPosition);
        }

        void bind(String posterUrl) {
            NetworkUtils.setImage(context, posterUrl, mMoviePoster);
        }
    }

}