package com.lukmanhawi.moviecatalogue.di;

import android.content.Context;

import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;
import com.lukmanhawi.moviecatalogue.data.source.remote.RemoteDataSource;
import com.lukmanhawi.moviecatalogue.utils.JsonHelper;

public class Injection {
    public static CatalogueRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return CatalogueRepository.getInstance(remoteDataSource);
    }
}
