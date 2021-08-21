package com.lukmanhawi.moviecatalogue.data.source.remote;

import androidx.lifecycle.LiveData;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;

import java.util.List;

public interface LocalDataSource {
    LiveData<List<MovieEntity>> getMovies();

    LiveData<MovieEntity> getMovieById(String courseId);

    LiveData<List<TvEntity>> getTvShows();

    LiveData<TvEntity> getTvShowById(String courseId);
}
