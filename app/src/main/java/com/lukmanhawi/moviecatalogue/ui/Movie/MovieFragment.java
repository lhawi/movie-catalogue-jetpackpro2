package com.lukmanhawi.moviecatalogue.ui.Movie;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukmanhawi.moviecatalogue.databinding.FragmentMovieBinding;
import com.lukmanhawi.moviecatalogue.utils.CatalogueIdlingResource;
import com.lukmanhawi.moviecatalogue.viewmodel.ViewModelFactory;

public class MovieFragment extends Fragment {

    private FragmentMovieBinding fragmentMovieBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false);
        return fragmentMovieBinding.getRoot();
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            MovieViewModel viewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);
            fragmentMovieBinding.progressBar.setVisibility(View.VISIBLE);
            MovieAdapter moviesAdapter = new MovieAdapter();
            viewModel.getMovies().observe(this, itemEntities -> {
                fragmentMovieBinding.progressBar.setVisibility(View.GONE);
                moviesAdapter.setMovie(itemEntities);
                moviesAdapter.notifyDataSetChanged();
            });

            fragmentMovieBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentMovieBinding.rvMovie.setHasFixedSize(true);
            fragmentMovieBinding.rvMovie.setAdapter(moviesAdapter);
        }
        CatalogueIdlingResource.increment();
        if (!CatalogueIdlingResource.getIdlingResource().isIdleNow()) {
            CatalogueIdlingResource.decrement();
        }
    }
}