package com.lukmanhawi.moviecatalogue.ui.Movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lukmanhawi.moviecatalogue.R;
import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.databinding.ItemsMovieBinding;
import com.lukmanhawi.moviecatalogue.ui.detail.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<MovieEntity> listMovie = new ArrayList<>();

    void setMovie(List<MovieEntity> listCourses) {
        if (listCourses == null) return;
        this.listMovie.clear();
        this.listMovie.addAll(listCourses);
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsMovieBinding binding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieAdapter.MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.MovieViewHolder holder, int position) {
        MovieEntity movie = listMovie.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final ItemsMovieBinding binding;

        MovieViewHolder(ItemsMovieBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(MovieEntity movie) {
            binding.movieItemTitle.setText(movie.getTitle());
            binding.movieItemDate.setText(movie.getDate());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.getMovieId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(movie.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}