package com.lukmanhawi.moviecatalogue.ui.Tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;

import java.util.List;

public class TvViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    public TvViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<List<TvEntity>> getTvShows() {
        return catalogueRepository.getTvShows();
    }
}
