package com.lukmanhawi.moviecatalogue.ui.Tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;
import com.lukmanhawi.moviecatalogue.ui.Movie.MovieViewModel;
import com.lukmanhawi.moviecatalogue.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvViewModelTest {
    private TvViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new TvViewModel(catalogueRepository);
    }

    @Test
    public void getMovies() {
        List<TvEntity> dummyCourses = DataDummy.generateDummyTv();
        MutableLiveData<List<TvEntity>> courses = new MutableLiveData<>();
        courses.setValue(dummyCourses);
        when(catalogueRepository.getTvShows()).thenReturn(courses);
        Observer<List<TvEntity>> observer = mock(Observer.class);
        viewModel.getTvShows().observeForever(observer);
        verify(catalogueRepository).getTvShows();
        List<TvEntity> movieResults = viewModel.getTvShows().getValue();
        assertNotNull(movieResults);
        assertEquals(10, movieResults.size());

        viewModel.getTvShows().observeForever(observer);
        verify(observer).onChanged(dummyCourses);
    }
}