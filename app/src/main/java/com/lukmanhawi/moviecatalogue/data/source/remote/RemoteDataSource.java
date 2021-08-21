package com.lukmanhawi.moviecatalogue.data.source.remote;

import android.os.Handler;
import android.os.Looper;

import com.lukmanhawi.moviecatalogue.data.source.remote.response.MovieResponse;
import com.lukmanhawi.moviecatalogue.data.source.remote.response.TVResponse;
import com.lukmanhawi.moviecatalogue.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final long SERVICE_LATENCY_IN_MILLIS = 1000;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public List<MovieResponse> getMovies(LoadMovieCallback callback) {
        handler.postDelayed(()-> callback.onItemsReceived(jsonHelper.loadMovies()), SERVICE_LATENCY_IN_MILLIS);
        return jsonHelper.loadMovies();
    }

    public TVResponse getMovieByID(String id) {
        return jsonHelper.loadTvShowById(id);
    }

    public List<TVResponse> getTvShows(LoadTvCallback callback) {
        handler.postDelayed(()-> callback.onItemsReceived(jsonHelper.loadTvShows()), SERVICE_LATENCY_IN_MILLIS);
        return jsonHelper.loadTvShows();
    }

    public TVResponse getTvShowById(String id) {
        return jsonHelper.loadTvShowById(id);
    }

    public interface LoadMovieCallback {
        void onItemsReceived(List<MovieResponse> itemResponses);
    }
    public interface LoadTvCallback {
        void onItemsReceived(List<TVResponse> itemResponses);
    }

}