package com.lukmanhawi.moviecatalogue.ui.detail;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;

public class DetailViewModel extends ViewModel {

    private String courseId;
    private Context context;
    private CatalogueRepository catalogueRepository;

    public void setSelectedData(Context context, String courseId) {
        this.context = context;
        this.courseId = courseId;
    }

    public DetailViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<MovieEntity> getMovie() {
        return catalogueRepository.getMovieById(courseId);
    }

    public LiveData<TvEntity> getTvShow() {
        return catalogueRepository.getTvShowById(courseId);
    }

}