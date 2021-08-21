package com.lukmanhawi.moviecatalogue.data.source.remote;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.response.MovieResponse;
import com.lukmanhawi.moviecatalogue.data.source.remote.response.TVResponse;

import java.util.ArrayList;
import java.util.List;

public class CatalogueRepository implements LocalDataSource {
    private volatile static CatalogueRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    private CatalogueRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static CatalogueRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (CatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CatalogueRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public LiveData<List<MovieEntity>> getMovies() {
        MutableLiveData<List<MovieEntity>> movieResult = new MutableLiveData<>();
        remoteDataSource.getMovies(movieResponses -> {
            ArrayList<MovieEntity> movieList = new ArrayList<>();
            for (MovieResponse response : movieResponses) {
                MovieEntity movie =
                        new MovieEntity(
                                response.getMovieId(),
                                response.getTitle(),
                                response.getDate(),
                                response.getDescription(),
                                response.getRate(),
                                response.getImagePath());

                movieList.add(movie);
            }
            movieResult.postValue(movieList);
        });
        return movieResult;
    }

    @Override
    public LiveData<MovieEntity> getMovieById(String id) {
        MutableLiveData<MovieEntity> movieidResult = new MutableLiveData<>();
        remoteDataSource.getMovies(movieResponses -> {
            MovieEntity movie = null;
            for (MovieResponse response : movieResponses) {

                if (response.getMovieId().equals(id)) {
                    movie = new MovieEntity(
                            response.getMovieId(),
                            response.getTitle(),
                            response.getDate(),
                            response.getDescription(),
                            response.getRate(),
                            response.getImagePath());
                }
            }
            movieidResult.postValue(movie);
        });
        return movieidResult;

    }

    @Override
    public LiveData<List<TvEntity>> getTvShows() {
        MutableLiveData<List<TvEntity>> tvResult = new MutableLiveData<>();
        remoteDataSource.getTvShows(tvResponses -> {
            ArrayList<TvEntity> tvshowList = new ArrayList<>();
            for (TVResponse response : tvResponses) {
                TvEntity tvshow =
                        new TvEntity(
                                response.getTvId(),
                                response.getTitle(),
                                response.getDate(),
                                response.getDescription(),
                                response.getRate(),
                                response.getImagePath());

                tvshowList.add(tvshow);
            }
            tvResult.postValue(tvshowList);
        });
        return tvResult;
    }

    @Override
    public LiveData<TvEntity> getTvShowById(String id) {
        MutableLiveData<TvEntity> tvidResult = new MutableLiveData<>();
        remoteDataSource.getTvShows(tvshowResponses -> {
            TvEntity tvshow = null;
            for (TVResponse response : tvshowResponses) {

                if (response.getTvId().equals(id)) {
                    tvshow = new TvEntity(
                            response.getTvId(),
                            response.getTitle(),
                            response.getDate(),
                            response.getDescription(),
                            response.getRate(),
                            response.getImagePath());
                }
            }
            tvidResult.postValue(tvshow);
        });
        return tvidResult;

    }
    }

