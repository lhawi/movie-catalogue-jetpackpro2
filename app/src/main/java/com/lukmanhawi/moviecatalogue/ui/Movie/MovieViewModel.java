package com.lukmanhawi.moviecatalogue.ui.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    public MovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<List<MovieEntity>> getMovies() {
        return catalogueRepository.getMovies();
    }
}
