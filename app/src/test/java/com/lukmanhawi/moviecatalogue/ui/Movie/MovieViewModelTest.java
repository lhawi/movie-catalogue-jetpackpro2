package com.lukmanhawi.moviecatalogue.ui.Movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.CatalogueRepository;
import com.lukmanhawi.moviecatalogue.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovies() {
        List<MovieEntity> dummyCourses = DataDummy.generateDummyMovies();
        MutableLiveData<List<MovieEntity>> courses = new MutableLiveData<>();
        courses.setValue(dummyCourses);
        when(catalogueRepository.getMovies()).thenReturn(courses);
        Observer<List<MovieEntity>> observer = mock(Observer.class);
        viewModel.getMovies().observeForever(observer);
        verify(catalogueRepository).getMovies();
        List<MovieEntity> movieResults = viewModel.getMovies().getValue();
        assertNotNull(movieResults);
        assertEquals(10, movieResults.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyCourses);
    }
}