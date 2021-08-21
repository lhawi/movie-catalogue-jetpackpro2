package com.lukmanhawi.moviecatalogue.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;
import com.lukmanhawi.moviecatalogue.di.Injection;
import com.lukmanhawi.moviecatalogue.ui.Movie.MovieViewModel;
import com.lukmanhawi.moviecatalogue.ui.Tv.TvViewModel;
import com.lukmanhawi.moviecatalogue.ui.detail.DetailViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final CatalogueRepository catalogueRepository;

    private ViewModelFactory(CatalogueRepository academyRepository) {
        catalogueRepository = academyRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(TvViewModel.class)) {
            return (T) new TvViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(catalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}